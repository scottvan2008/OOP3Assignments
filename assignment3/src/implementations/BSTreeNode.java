package implementations;

import java.io.Serializable;

public class BSTreeNode<E> implements Serializable {
    private static final long serialVersionUID = 1L;

    private E element;
    private BSTreeNode<E> left;
    private BSTreeNode<E> right;

    public BSTreeNode(E element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public BSTreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(BSTreeNode<E> left) {
        this.left = left;
    }

    public BSTreeNode<E> getRight() {
        return right;
    }

    public void setRight(BSTreeNode<E> right) {
        this.right = right;
    }

    // Additional constructor for cloning nodes if needed
    public BSTreeNode(BSTreeNode<E> node) {
        if (node != null) {
            this.element = node.getElement();
            this.left = (node.getLeft() != null) ? new BSTreeNode<>(node.getLeft()) : null;
            this.right = (node.getRight() != null) ? new BSTreeNode<>(node.getRight()) : null;
        }
    }
}
