public class midiaDigital {
    private String titulo;
    private String album;
    private boolean disponivel;

    public midiaDigital(String titulo, String album) {
        this.titulo = titulo;
        this.album = album;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAlbum() {
        return album;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() throws EmprestimoException {
        if (!disponivel) {
            throw new EmprestimoException("A mídia digital não está disponível para empréstimo.");
        }
        disponivel = false;
    }

    public void devolver() throws DevolucaoException {
        if (disponivel) {
            throw new DevolucaoException("A mídia digital já está disponível na biblioteca.");
        }
        disponivel = true;
    }

    @Override
    public String toString() {
        return "Mídia Digital: " + titulo + " - Album: " + album + " - Disponível: " + (disponivel ? "Sim" : "Não");
    }
}