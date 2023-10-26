import java.util.ArrayList;

public class Midia { // aqui foi criado a classe midia
    public String titulo;
    private boolean disponivel;

    public static ArrayList<Midia> midias = new ArrayList<>();

    public Midia(String titulo, boolean disponivel) { // aqui foi criado o construtor da classe midia
        this.titulo = titulo;
        this.disponivel = disponivel;
    }

    public static void main(String[] args) { // aqui foi criado o método main
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

    public class EmprestimoException extends Exception { // aqui foi criado a classe EmprestimoException
        public EmprestimoException(String message) {
            super(message);
        }
    }

    public class DevolucaoException extends Exception { // aqui foi criado a classe DevolucaoException
        public DevolucaoException(String message) {
            super(message);
        }
    }

    public String getTitulo() { // aqui foi criado o método getTitulo
        return this.titulo;
    }

    public void setTitulo(String titulo) { // aqui foi criado o método setTitulo
        this.titulo = titulo;
    }

    public boolean getDisponivel() { // aqui foi criado o método getDisponivel
        return this.disponivel;
    }

    public static void listarMidias() { // aqui foi criado o método listarMidias
        for (int i = 0; i < midias.size(); i++) {
            System.out.println(i + " - " + midias.get(i).toString());
        }
    }

    public static ArrayList<Midia> getMidias() { // aqui foi criado o método getMidias
        return midias;
    }

    public void emprestar() throws EmprestimoException { // aqui foi criado o método emprestar
        if (!this.disponivel) {
            throw new EmprestimoException("A mídia já está emprestada.");
        }
        this.disponivel = false;
    }

    public void devolver() throws DevolucaoException { // aqui foi criado o método devolver
        if (this.disponivel) {
            throw new DevolucaoException("A mídia já está disponível.");
        }
        this.disponivel = true;
    }

    public String toString() { // aqui foi criado o método toString
        return "Título: " + this.titulo + ". Disponível: " + (this.disponivel ? "Sim" : "Não");
    }
}