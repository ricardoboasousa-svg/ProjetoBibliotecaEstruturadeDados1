package projeto;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(Livro livro) {
        this.raiz = inserirRec(this.raiz, livro);
    }

    private No inserirRec(No atual, Livro livro) {
        if (atual == null) {
            return new No(livro);
        }
        if (livro.getIsbn() < atual.livro.getIsbn()) {
            atual.esquerda = inserirRec(atual.esquerda, livro);
        } else if (livro.getIsbn() > atual.livro.getIsbn()) {
            atual.direita = inserirRec(atual.direita, livro);
        }
        return atual;
    }

    public Livro buscar(long isbn) {
        No resultado = buscarRec(this.raiz, isbn);
        if (resultado != null) {
            return resultado.livro;
        }
        return null;
    }

    private No buscarRec(No atual, long isbn) {
        if (atual == null || atual.livro.getIsbn() == isbn) {
            return atual;
        }
        if (isbn < atual.livro.getIsbn()) {
            return buscarRec(atual.esquerda, isbn);
        }
        return buscarRec(atual.direita, isbn);
    }

    public void remover(long isbn) {
        this.raiz = removerRec(this.raiz, isbn);
    }

    private No removerRec(No atual, long isbn) {
        if (atual == null) {
            return null;
        }
        if (isbn < atual.livro.getIsbn()) {
            atual.esquerda = removerRec(atual.esquerda, isbn);
        } else if (isbn > atual.livro.getIsbn()) {
            atual.direita = removerRec(atual.direita, isbn);
        } else {
            if (atual.esquerda == null) {
                return atual.direita;
            } else if (atual.direita == null) {
                return atual.esquerda;
            }
            atual.livro = encontrarMinimo(atual.direita).livro;
            atual.direita = removerRec(atual.direita, atual.livro.getIsbn());
        }
        return atual;
    }

    private No encontrarMinimo(No atual) {
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    public void exibirEmOrdem() {
        exibirEmOrdemRec(this.raiz);
        System.out.println();
    }

    private void exibirEmOrdemRec(No atual) {
        if (atual != null) {
            exibirEmOrdemRec(atual.esquerda);
            System.out.println(atual.livro);
            exibirEmOrdemRec(atual.direita);
        }
    }

    public void exibirPreOrdem() {
        exibirPreOrdemRec(this.raiz);
        System.out.println();
    }

    private void exibirPreOrdemRec(No atual) {
        if (atual != null) {
            System.out.println(atual.livro);
            exibirPreOrdemRec(atual.esquerda);
            exibirPreOrdemRec(atual.direita);
        }
    }

    public void exibirPosOrdem() {
        exibirPosOrdemRec(this.raiz);
        System.out.println();
    }

    private void exibirPosOrdemRec(No atual) {
        if (atual != null) {
            exibirPosOrdemRec(atual.esquerda);
            exibirPosOrdemRec(atual.direita);
            System.out.println(atual.livro);
        }
    }

    public Livro mostrarMaiorIsbn() {
        if (this.raiz == null) {
            return null;
        }
        No atual = this.raiz;
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual.livro;
    }

    public Livro mostrarMenorIsbn() {
        if (this.raiz == null) {
            return null;
        }
        No atual = this.raiz;
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual.livro;
    }

    public int mostrarQuantidade() {
        return contarRec(this.raiz);
    }

    private int contarRec(No atual) {
        if (atual == null) {
            return 0;
        }
        return 1 + contarRec(atual.esquerda) + contarRec(atual.direita);
    }

    public int mostrarAltura() {
        return calcularAlturaRec(this.raiz);
    }

    private int calcularAlturaRec(No atual) {
        if (atual == null) {
            return -1;
        }
        int alturaEsq = calcularAlturaRec(atual.esquerda);
        int alturaDir = calcularAlturaRec(atual.direita);
        if (alturaEsq > alturaDir) {
            return alturaEsq + 1;
        } else {
            return alturaDir + 1;
        }
    }
}
