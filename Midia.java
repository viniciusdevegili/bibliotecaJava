import java.util.ArrayList;

public class Midia {
    public String titulo;
    private boolean disponivel;

    public static ArrayList<Midia> midias = new ArrayList<>();

    public Midia(String titulo, boolean disponivel) {
        this.titulo = titulo;
        this.disponivel = disponivel;
    }

    public static void main(String[] args) {
        // Criação de uma lista de mídias
        Midia midia = new Midia("Filme 1", true);
        
        // Adicione as mídias à lista
        midias.add(midia);
    
        try {
            midia.emprestar();
        } catch (EmprestimoException e) {
            System.out.println("Erro ao emprestar a mídia: " + e.getMessage());
        }

        try {
            midia.devolver();
        } catch (DevolucaoException e) {
            System.out.println("Erro ao devolver a mídia: " + e.getMessage());
        }

        listarMidias();
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

    public static void listarMidias() {
        for (int i = 0; i < midias.size(); i++) {
            System.out.println(i + " - " + midias.get(i).toString());
        }
    }

    public static ArrayList<Midia> getMidias() {
        return midias;
    }

    public void emprestar() throws EmprestimoException {
        if (!this.disponivel) {
            throw new EmprestimoException("A mídia já está emprestada.");
        }
        this.disponivel = false;
    }

    public void devolver() throws DevolucaoException {
        if (this.disponivel) {
            throw new DevolucaoException("A mídia já está disponível.");
        }
        this.disponivel = true;
    }

    public String toString() {
        return "Título: " + this.titulo + ". Disponível: " + (this.disponivel ? "Sim" : "Não");
    }
}