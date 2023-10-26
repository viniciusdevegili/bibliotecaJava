public class midiaDigital { // aqui foi criado a classe midiaDigital
    private String titulo;
    private String album;
    private boolean disponivel;

    public midiaDigital(String titulo, String album) { // aqui foi criado o construtor da classe midiaDigital
        this.titulo = titulo;
        this.album = album;
        this.disponivel = true;
    }

    public String getTitulo() { // aqui foi criado o método getTitulo
        return titulo;
    }

    public String getAlbum() { // aqui foi criado o método getAlbum
        return album;
    }

    public boolean isDisponivel() { // aqui foi criado o método isDisponivel
        return disponivel;
    }

    public void emprestar() throws EmprestimoException { // aqui foi criado o método emprestar
        if (!disponivel) {
            throw new EmprestimoException("A mídia digital não está disponível para empréstimo.");
        }
        disponivel = false;
    }

    public void devolver() throws DevolucaoException { // aqui foi criado o método devolver
        if (disponivel) {
            throw new DevolucaoException("A mídia digital já está disponível na biblioteca.");
        }
        disponivel = true;
    }

    @Override
    public String toString() { // aqui foi criado o método toString
        return "Mídia Digital: " + titulo + " - Album: " + album + " - Disponível: " + (disponivel ? "Sim" : "Não");
    }
}