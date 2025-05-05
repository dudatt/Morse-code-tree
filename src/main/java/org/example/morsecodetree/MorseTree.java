package org.example.morsecodetree;

public class MorseTree {
    private Node root;

    public MorseTree() {
        root = new Node('\0');
        buildTree();
    }

    private void buildTree() {
        insert(".-", 'A');
        insert("-...", 'B');
        insert("-.-.", 'C');
        insert("-..", 'D');
        insert(".", 'E');
        insert("..-.", 'F');
        insert("--.", 'G');
        insert("....", 'H');
        insert("..", 'I');
        insert(".---", 'J');
        insert("-.-", 'K');
        insert(".-..", 'L');
        insert("--", 'M');
        insert("-.", 'N');
        insert("---", 'O');
        insert(".--.", 'P');
        insert("--.-", 'Q');
        insert(".-.", 'R');
        insert("...", 'S');
        insert("-", 'T');
        insert("..-", 'U');
        insert("...-", 'V');
        insert(".--", 'W');
        insert("-..-", 'X');
        insert("-.--", 'Y');
        insert("--..", 'Z');
    }

    private void insert(String code, char letter) {
        Node current = root;
        for (char c : code.toCharArray()) {
            if (c == '.') {
                if (current.left == null) {
                    current.left = new Node('\0');
                }
                current = current.left;
            } else if (c == '-') {
                if (current.right == null) {
                    current.right = new Node('\0');
                }
                current = current.right;
            }
        }
        current.letter = letter;
    }

    public char decode(String code) {
        Node current = root;
        for (char c : code.toCharArray()) {
            if (c == '.') {
                if (current.left == null) return '?';
                current = current.left;
            } else if (c == '-') {
                if (current.right == null) return '?';
                current = current.right;
            }
        }
        return current.letter != '\0' ? current.letter : '?';
    }
}
