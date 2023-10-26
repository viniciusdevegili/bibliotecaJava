public class Livro { // aqui foi criada a classe Livro
    private String titulo;
    private Autor autor;
    private boolean disponivel;

    public Livro(String titulo, Autor autor) { // aqui foi criado o construtor da classe Livro
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getTitulo() { // aqui foi criado o método getTitulo
        return titulo;
    }

    public Autor getAutor() { // aqui foi criado o método getAutor
        return autor;
    }

    public boolean isDisponivel() { // aqui foi criado o método isDisponivel
        return disponivel;
    }

    public void emprestar() throws EmprestimoException { // aqui foi criado o método emprestar
        if (!disponivel) { // aqui foi criado o if para verificar se o livro está disponível
            throw new EmprestimoException("O livro não está disponível para empréstimo.");
        }
        disponivel = false;
    }

    public void devolver() throws DevolucaoException { // aqui foi criado o método devolver
        if (disponivel) {
            throw new DevolucaoException("O livro já está disponível na biblioteca.");
        }
        disponivel = true;
    }

    @Override
    public String toString() { // aqui foi criado o método toString
        return "Livro: " + titulo + " - Autor: " + autor.getNome() + " - Disponível: " + (disponivel ? "Sim" : "Não");
    }
}
