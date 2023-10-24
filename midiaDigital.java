public class midiaDigital {
    private String titulo;
    private String album;
    private boolean disponivel;

    public midiaDigital(String titulo, String album, boolean disponivel) {
        this.titulo = titulo;
        this.album = album;
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public boolean getDisponivel() {
        return this.disponivel;
    }

    public boolean emprestar() {
        if (this.disponivel) {
            this.disponivel = false;
            return true; // Mídia emprestada com sucesso.
        }
        return false; // Mídia não disponível para empréstimo.
    }

    public boolean devolver() {
        if (!this.disponivel) {
            this.disponivel = true;
            return true; // Mídia devolvida com sucesso.
        }
        return false; // Mídia já estava disponível.
    }

    public String toString() {
        return "Título: " + this.titulo + ", Album: " + this.album + ". Disponível: " + (this.disponivel ? "Sim" : "Não");
    }
}