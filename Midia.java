public class Midia {
    private String titulo;
    private boolean disponivel;

    public Midia(String titulo, boolean disponivel) {
        this.titulo = titulo;
        this.disponivel = disponivel;
    }

    public static void main(String[] args) {
        Midia midia1 = new Midia("Filme 1", true);
        Midia midia2 = new Midia("Livro 1", false);

        try {
            midia1.emprestar(); // Isso deve gerar uma exceção
        } catch (EmprestimoException e) {
            System.out.println("Erro ao emprestar a mídia: " + e.getMessage());
        }

        try {
            midia2.devolver(); // Isso deve gerar uma exceção
        } catch (DevolucaoException e) {
            System.out.println("Erro ao devolver a mídia: " + e.getMessage());
        }
    }

    public class EmprestimoException extends Exception {
        public EmprestimoException(String message) {
            super(message);
        }
    }

    public class DevolucaoException extends Exception {
        public DevolucaoException(String message) {
            super(message);
        }
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean getDisponivel() {
        return this.disponivel;
    }

    public void emprestar() throws EmprestimoException {
        if (!this.disponivel) {
            try {
                // Código que pode lançar uma exceção
                throw new EmprestimoException("A mídia já está emprestada.");
            } catch (EmprestimoException e) {
                // Trate a exceção ou re-lance-a se necessário
                System.out.println("Erro ao emprestar a mídia: " + e.getMessage());
                // Outras ações de tratamento
            }
        }
    }

    public void devolver() throws DevolucaoException {
        if (this.disponivel) {
            try {
                // Código que pode lançar uma exceção
                throw new DevolucaoException("A mídia já está disponível.");
            } catch (DevolucaoException e) {
                // Trate a exceção ou re-lance-a se necessário
                System.out.println("Erro ao devolver a mídia: " + e.getMessage());
                // Outras ações de tratamento
            }
        }
    }

    public String toString() {
        return "Título: " + this.titulo + ". Disponível: " + (this.disponivel ? "Sim" : "Não");
    }

}
