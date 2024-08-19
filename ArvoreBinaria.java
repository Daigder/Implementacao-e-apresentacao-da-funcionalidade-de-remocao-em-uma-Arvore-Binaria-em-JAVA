package org.example;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public No inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                } else {
                    pai = atual;
                    atual = atual.getDir();
                }
            }
            if (novoNo.getValor() < pai.getValor()) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
        return novoNo;
    }

    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public No getRaiz() {
        return this.raiz;
    }
    public boolean remover(int valor) {
        No atual = raiz; // Começa a busca pelo nó com o valor dado a partir da raiz da árvore.
        No pai = null; // Armazena o pai do nó atual, inicialmente não há pai.
        boolean ehFilhoEsquerdo = false; // Marca se o nó atual é um filho esquerdo ou direito do pai.

        // Encontrar o nó a ser removido e seu pai.
        while (atual != null && atual.getValor() != valor) {
            pai = atual; // Atualiza o pai para o nó atual.

            // Se o valor a ser removido é menor que o valor do nó atual, vai para o filho esquerdo.
            if (valor < atual.getValor()) {
                atual = atual.getEsq(); // Move para o filho esquerdo do nó atual.
                ehFilhoEsquerdo = true; // Marca que o nó atual é um filho esquerdo do pai.
            } else {
                atual = atual.getDir(); // Move para o filho direito do nó atual.
                ehFilhoEsquerdo = false; // Marca que o nó atual é um filho direito do pai.
            }
        }

        // Se o nó atual é null, o valor não foi encontrado na árvore.
        if (atual == null) {
            return false; // Retorna false indicando que o nó não foi encontrado.
        }

        // Caso 1: Nó sem filhos (nó folha).
        if (atual.getEsq() == null && atual.getDir() == null) {
            if (atual == raiz) {
                raiz = null; // Se o nó a ser removido é a raiz e é uma folha, a raiz é definida como null.
            } else if (ehFilhoEsquerdo) {
                pai.setEsq(null); // Se o nó é um filho esquerdo, o ponteiro esquerdo do pai é definido como null.
            } else {
                pai.setDir(null); // Se o nó é um filho direito, o ponteiro direito do pai é definido como null.
            }
        }
        // Caso 2: Nó com um filho.
        else if (atual.getEsq() == null || atual.getDir() == null) {
            No filho = (atual.getEsq() != null) ? atual.getEsq() : atual.getDir(); // Define o filho como o único filho do nó.

            if (atual == raiz) {
                raiz = filho; // Se o nó a ser removido é a raiz, a raiz é atualizada para o filho.
            } else if (ehFilhoEsquerdo) {
                pai.setEsq(filho); // Se o nó é um filho esquerdo, o ponteiro esquerdo do pai é atualizado para o filho.
            } else {
                pai.setDir(filho); // Se o nó é um filho direito, o ponteiro direito do pai é atualizado para o filho.
            }
        }
        // Caso 3: Nó com dois filhos.
        else {
            No substituto = encontrarMinimo(atual.getDir());
            int valorSubstituto = substituto.getValor();
            remover(valorSubstituto); // Remove o nó substituto da sua posição original
            atual.setValor(valorSubstituto); // Substitui o valor do nó a ser removido pelo valor do substituto
        }

        return true; // Retorna que o nó foi removido com sucesso
    }

    // Função para encontrar o nó com o menor valor na subárvore
    private No encontrarMinimo(No raiz) {
        while (raiz.getEsq() != null) {
            raiz = raiz.getEsq(); // Continua movendo para o filho esquerdo até encontrar o nó com o menor valor
        }
        return raiz; // Retorna o nó com o menor valor encontrado
    }
}