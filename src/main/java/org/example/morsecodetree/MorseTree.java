package org.example.morsecodetree;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MorseTree extends Application {
    private Node root;

    public MorseTree() {
        root = new Node('\0');
        buildTree();
    }

    @Override
    public void start(Stage stage) throws Exception {

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

    public String decodeWord(String morseWord) {
        StringBuilder result = new StringBuilder();
        for (String code : morseWord.trim().split(" ")) {
            result.append(decode(code));
        }
        return result.toString();
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

    // Calcula a altura da árvore
    public int getHeight() {
        return getHeight(root);
    }
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    // Desenha a árvore
    public void drawTree(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        // Começa o desenho da árvore na raiz
        drawNode(gc, root, canvas.getWidth() / 2, 40, canvas.getWidth() / 4,
                1);
    }
    private void drawNode(GraphicsContext gc, Node node, double x, double y,
                          double xOffset, int level) {
        if (node == null) {
            return;
        }
        // Desenha um círculo ao redor do nó
        gc.setStroke(Color.BLACK);
        gc.strokeOval(x - 15, y - 15, 30, 30); // Desenha o círculo com raio 15
        // Desenha a letra dentro do círculo
        gc.strokeText(String.valueOf(node.letter == ' ' ? ' ' : node.letter), x
                - 5, y + 5);
        // Desenho das linhas para os nós filhos
        if (node.left != null) {
            double newX = x - xOffset;
            double newY = y + 120; // Aumentei o espaçamento vertical
            gc.strokeLine(x, y + 15, newX, newY - 15); // Linha entre o nó atual e o filho à esquerda
            drawNode(gc, node.left, newX, newY, xOffset / 2, level + 1);
        }
        if (node.right != null) {
            double newX = x + xOffset;
            double newY = y + 120; // Aumentei o espaçamento vertical
            gc.strokeLine(x, y + 15, newX, newY - 15); // Linha entre o nó atual e o filho à direita
            drawNode(gc, node.right, newX, newY, xOffset / 2, level + 1);
        }
    }
}
