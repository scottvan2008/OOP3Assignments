package appDomain;

import implementations.BSTree;
import implementations.BSTreeNode;
import utilities.Iterator;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class WordTracker {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java -jar WordTracker.jar <input.txt> -pf|-pl|-po [-f<output.txt>]");
            System.exit(1);
        }

        String inputFile = args[0];
        String option = args[1];
        String outputFile = null;

        if (args.length == 3 && args[2].startsWith("-f")) {
            outputFile = args[2].substring(2);
        }

        BSTree<WordEntry> tree = new BSTree<>();
        processFile(inputFile, tree);

        PrintWriter writer = null;
        boolean exporting = false;
        try {
            if (outputFile != null) {
                writer = new PrintWriter(new FileWriter(outputFile));
                exporting = true;
            }
        } catch (IOException e) {
            System.err.println("Failed to open output file: " + outputFile);
            e.printStackTrace();
            System.exit(2);
        }

        output(tree, option, writer, inputFile);

        if (writer != null) {
            writer.close();
        } else {
            System.out.println("Not exporting file.");
        }
    }

    private static void processFile(String filePath, BSTree<WordEntry> tree) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, " .,;:!?()[]{}<>\"'-");

                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken().toLowerCase();
                    if (word.isEmpty()) continue;

                    WordEntry tempEntry = new WordEntry(word);
                    BSTreeNode<WordEntry> foundNode = tree.search(tempEntry);

                    if (foundNode != null) {
                        foundNode.getElement().addLineNumber(lineNumber);
                    } else {
                        WordEntry newEntry = new WordEntry(word);
                        newEntry.addLineNumber(lineNumber);
                        tree.add(newEntry);
                    }
                }

                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        }
    }

    private static void output(BSTree<WordEntry> tree, String option, PrintWriter writer, String inputFile) {
        if (writer != null) {
            writer.println("Displaying " + option + " format");
        } else {
            System.out.println("Displaying " + option + " format");
        }

        Iterator<WordEntry> iterator = tree.inorderIterator();
        while (iterator.hasNext()) {
            WordEntry entry = iterator.next();
            String outputLine = "";

            if (option.equals("-pf")) {
                outputLine = "Key : ===" + entry.getWord() + "=== found in file: " + inputFile;
            } else if (option.equals("-pl")) {
                outputLine = "Key : ===" + entry.getWord() + "=== found in file: " + inputFile + " on lines: " + entry.getLineNumbersAsString();
            } else if (option.equals("-po")) {
                outputLine = "Key : ===" + entry.getWord() + "=== number of entries: " + entry.getLineNumbers().size()
                        + " found in file: " + inputFile + " on lines: " + entry.getLineNumbersAsString();
            } else {
                System.err.println("Invalid option: " + option);
                System.exit(3);
            }

            if (writer != null) {
                writer.println(outputLine);
            } else {
                System.out.println(outputLine);
            }
        }
    }
}

class WordEntry implements Comparable<WordEntry> {
    private String word;
    private TreeSet<Integer> lineNumbers;

    public WordEntry(String word) {
        this.word = word;
        this.lineNumbers = new TreeSet<>();
    }

    public void addLineNumber(int lineNumber) {
        lineNumbers.add(lineNumber);
    }

    public String getWord() {
        return word;
    }

    public TreeSet<Integer> getLineNumbers() {
        return lineNumbers;
    }

    public String getLineNumbersAsString() {
        StringBuilder sb = new StringBuilder();
        for (int num : lineNumbers) {
            if (sb.length() > 0) sb.append(",");
            sb.append(num);
        }
        return sb.toString();
    }

    @Override
    public int compareTo(WordEntry other) {
        return this.word.compareTo(other.word);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WordEntry that = (WordEntry) obj;
        return word.equals(that.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public String toString() {
        return word + " " + lineNumbers;
    }
}
