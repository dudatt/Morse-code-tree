# 📘 Listas Não-Lineares - Código Morse

**Disciplina:** Resolução de Problemas Estruturados </br>
**Trabalho em Trio:** [Jun](https://github.com/julia-tatim), [Duda](https://github.com/dudatt), [Lau](https://github.com/kyoulau). </br>
**Tema:** Implementação de uma Árvore Binária para representar o Código Morse </br>
**Data:** 06/05/2025

---

## 📌 Objetivo

Implementar uma árvore binária que representa o alfabeto codificado em Morse, onde cada ponto (`.`) representa uma ramificação à esquerda e cada traço (`-`) representa uma ramificação à direita. O sistema permite a decodificação de palavras a partir de uma sequência de códigos Morse e a visualização da estrutura em forma de árvore binária.

---

## ✅ Requisitos Atendidos

### ✅ Inserção conforme heurística do código Morse (3,0)

A classe `MorseTree` implementa o método `insert`, que constrói a árvore seguindo a regra:

* `.` → segue para o filho à esquerda
* `-` → segue para o filho à direita

Cada letra do alfabeto (de A a Z) é inserida conforme seu padrão Morse.

### ✅ Decodificação de palavras inseridas via input (2,0)

A função `decode(String code)` percorre a árvore e retorna a letra correspondente a uma sequência de pontos e traços. Pode ser adaptada para processar palavras completas separando os caracteres por espaços.

### ✅ Impressão da árvore binária (1,5)

A estrutura da árvore é exibida com o auxílio do arquivo `TreeVisualizer.java`, que pode ser executado com ou sem interface gráfica. A visualização é clara e evidencia a hierarquia da árvore binária construída.

### ✅ Modularização e boas práticas (1,5)

O projeto está devidamente organizado:

* Classes separadas (`MorseTree` e `Node`)
* Métodos específicos e reutilizáveis (`buildTree`, `insert`, `decode`)
* Nomenclatura em padrão camelCase e código limpo

---

## 🧱 Estrutura de Classes

### `class MorseTree`

Responsável por:

* Construir a árvore com `buildTree()`
* Inserir letras com `insert(String code, char letter)`
* Decodificar um código Morse com `decode(String code)`

### `class Node`

Representa os nós da árvore Morse:

```java
public class Node {
    char letter;
    Node left, right;

    Node(char letter) {
        this.letter = letter;
    }
}
```

Cada nó pode conter uma letra (ou `\0` caso vazio), e ponteiros para os filhos esquerdo (ponto) e direito (traço).

---

## 💻 Execução

1. **Pré-requisito (JavaFX)**
   Siga a documentação oficial do JavaFX: [https://openjfx.io/openjfx-docs/](https://openjfx.io/openjfx-docs/)

2. **Visualização da Árvore**
   Execute `TreeVisualizer.java` para imprimir a árvore no console ou via interface.

3. **Entrada do Usuário**
   É possível usar `Scanner` para ler uma palavra em código Morse e decodificá-la no terminal com o método `decode`.

---

## 📎 Exemplo de Uso

```java
MorseTree tree = new MorseTree();
System.out.println(tree.decode("...")); // S
System.out.println(tree.decode(".-"));  // A
```
---
