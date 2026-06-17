package projeto;

public class Livro {
    private long isbn;
    private String titulo;
    private String autor;
    private String area;
    private int quantidade;

    public Livro(long isbn, String titulo, String autor, String area, int quantidade) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.area = area;
        this.quantidade = quantidade;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + " | Título: " + titulo + " | Autor: " + autor + " | Área: " + area + " | Qtd: " + quantidade;
    }
}
