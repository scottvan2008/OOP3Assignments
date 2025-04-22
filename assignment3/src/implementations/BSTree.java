package implementations;

import utilities.BSTreeADT;
import utilities.Iterator;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E>, Serializable {
    private static final long serialVersionUID = 1L;
    private BSTreeNode<E> root;
    private int size;

    public BSTree() {
        root = null;
        size = 0;
    }

    public BSTree(E element) {
        root = new BSTreeNode<>(element);
        size = 1;
    }


    @Override
    public BSTreeNode<E> getRoot() {
        if (root == null) throw new NullPointerException("Root is null");
        return root;
    }

    @Override
    public int getHeight() {
        return height(root);
    }

    private int height(BSTreeNode<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean contains(E entry) {
        if (entry == null) throw new NullPointerException();
        return search(entry) != null;
    }

    @Override
    public BSTreeNode<E> search(E entry) {
        if (entry == null) throw new NullPointerException();
        return searchRecursive(root, entry);
    }

    private BSTreeNode<E> searchRecursive(BSTreeNode<E> node, E entry) {
        if (node == null) return null;
        int cmp = entry.compareTo(node.getElement());
        if (cmp == 0) return node;
        else if (cmp < 0) return searchRecursive(node.getLeft(), entry);
        else return searchRecursive(node.getRight(), entry);
    }

    @Override
    public boolean add(E newEntry) {
        if (newEntry == null) throw new NullPointerException();
        if (root == null) {
            root = new BSTreeNode<>(newEntry);
            size++;
            return true;
        }
        return addRecursive(root, newEntry);
    }

    private boolean addRecursive(BSTreeNode<E> node, E entry) {
        int cmp = entry.compareTo(node.getElement());
        if (cmp == 0) {
            return false;
        } else if (cmp < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new BSTreeNode<>(entry));
                size++;
                return true;
            } else {
                return addRecursive(node.getLeft(), entry);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BSTreeNode<>(entry));
                size++;
                return true;
            } else {
                return addRecursive(node.getRight(), entry);
            }
        }
    }

    @Override
    public BSTreeNode<E> removeMin() {
        if (isEmpty()) return null;
        BSTreeNode<E> parent = null;
        BSTreeNode<E> current = root;
        while (current.getLeft() != null) {
            parent = current;
            current = current.getLeft();
        }
        if (parent == null) {
            root = root.getRight();
        } else {
            parent.setLeft(current.getRight());
        }
        size--;
        return current;
    }

    @Override
    public BSTreeNode<E> removeMax() {
        if (isEmpty()) return null;
        BSTreeNode<E> parent = null;
        BSTreeNode<E> current = root;
        while (current.getRight() != null) {
            parent = current;
            current = current.getRight();
        }
        if (parent == null) {
            root = root.getLeft();
        } else {
            parent.setRight(current.getLeft());
        }
        size--;
        return current;
    }


    @Override
    public Iterator<E> inorderIterator() {
        Stack<BSTreeNode<E>> stack = new Stack<>();
        fillInorder(root, stack);
        return new StackIterator(stack);
    }

    @Override
    public Iterator<E> preorderIterator() {
        Stack<BSTreeNode<E>> stack = new Stack<>();
        fillPreorder(root, stack);
        return new StackIterator(stack);
    }

    @Override
    public Iterator<E> postorderIterator() {
        Stack<BSTreeNode<E>> stack = new Stack<>();
        fillPostorder(root, stack);
        return new StackIterator(stack);
    }

    private void fillInorder(BSTreeNode<E> node, Stack<BSTreeNode<E>> stack) {
        if (node == null) return;
        fillInorder(node.getRight(), stack);
        stack.push(node);
        fillInorder(node.getLeft(), stack);
    }

    private void fillPreorder(BSTreeNode<E> node, Stack<BSTreeNode<E>> stack) {
        if (node == null) return;
        fillPreorder(node.getRight(), stack);
        fillPreorder(node.getLeft(), stack);
        stack.push(node);
    }

    private void fillPostorder(BSTreeNode<E> node, Stack<BSTreeNode<E>> stack) {
        if (node == null) return;
        stack.push(node);
        fillPostorder(node.getRight(), stack);
        fillPostorder(node.getLeft(), stack);
    }

    private class StackIterator implements Iterator<E> {
        private Stack<BSTreeNode<E>> internalStack;

        public StackIterator(Stack<BSTreeNode<E>> stack) {
            this.internalStack = stack;
        }

        @Override
        public boolean hasNext() {
            return !internalStack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            return internalStack.pop().getElement();
        }
    }
}

