public class Livro {
    private String titulo;
    private Autor autor;
    private boolean disponivel;

    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() throws EmprestimoException {
        if (!disponivel) {
            throw new EmprestimoException("O livro não está disponível para empréstimo.");
        }
        disponivel = false;
    }

    public void devolver() throws DevolucaoException {
        if (disponivel) {
            throw new DevolucaoException("O livro já está disponível na biblioteca.");
        }
        disponivel = true;
    }

    @Override
    public String toString() {
        return "Livro: " + titulo + " - Autor: " + autor.getNome() + " - Disponível: " + (disponivel ? "Sim" : "Não");
    }
}
