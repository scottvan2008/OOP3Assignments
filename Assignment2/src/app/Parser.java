package app;

import implementations.MyQueue;
import implementations.MyStack;
import utilities.QueueADT;
import utilities.StackADT;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Parser <xmlFilePath>");
            return;
        }

        String filePath = args[0];
        StackADT<String> tagStack = new MyStack<>();
        StackADT<Integer> lineStack = new MyStack<>();
        QueueADT<String> errorQ = new MyQueue<>();
        QueueADT<Integer> errorLineQ = new MyQueue<>();

        Pattern startTagPattern = Pattern.compile("<([a-zA-Z0-9]+)(\\s+[^>/]*)?>");
        Pattern endTagPattern = Pattern.compile("</([a-zA-Z0-9]+)>");
        Pattern selfClosingPattern = Pattern.compile("<([a-zA-Z0-9]+)(\\s+[^>]*)?\\s*/>");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNum = 1;
            while ((line = reader.readLine()) != null) {

                Matcher selfClosing = selfClosingPattern.matcher(line);
                if (selfClosing.find()) {
                    lineNum++;
                    continue;
                }

                Matcher startTag = startTagPattern.matcher(line);
                Matcher endTag = endTagPattern.matcher(line);

                while (startTag.find()) {
                    String tag = startTag.group(1);
                    tagStack.push(tag);
                    lineStack.push(lineNum);
                }

                while (endTag.find()) {
                    String endTagName = endTag.group(1);

                    if (tagStack.isEmpty()) {
                        errorQ.enqueue("/" + endTagName);
                        errorLineQ.enqueue(lineNum);
                    } else {
                        String topTag = tagStack.peek();
                        if (topTag.equals(endTagName)) {
                            tagStack.pop();
                            lineStack.pop();
                        } else if (stackContains(tagStack, endTagName)) {
                            // pop all unmatched tags
                            while (!tagStack.isEmpty()) {
                                String wrongTag = tagStack.pop();
                                int wrongLine = lineStack.pop();
                                errorQ.enqueue(wrongTag);
                                errorLineQ.enqueue(wrongLine);
                                if (wrongTag.equals(endTagName)) {
                                    break;
                                }
                            }
                        } else {
                            errorQ.enqueue("/" + endTagName);
                            errorLineQ.enqueue(lineNum);
                        }
                    }
                }
                lineNum++;
            }

            while (!tagStack.isEmpty()) {
                errorQ.enqueue(tagStack.pop());
                errorLineQ.enqueue(lineStack.pop());
            }

            if (errorQ.isEmpty()) {
                System.out.println("XML document is constructed correctly.");
            } else {
                while (!errorQ.isEmpty()) {
                    System.out.println("Error at line: " + errorLineQ.dequeue()
                            + " <" + errorQ.dequeue() + "> is not constructed correctly.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static boolean stackContains(StackADT<String> stack, String tagName) {
        Object[] arr = stack.toArray();
        for (Object o : arr) {
            if (o.equals(tagName)) return true;
        }
        return false;
    }
}
