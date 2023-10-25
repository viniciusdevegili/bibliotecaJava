public class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class EmprestimoException extends Exception {
    public EmprestimoException(String message) {
        super(message);
    }
}

class DevolucaoException extends Exception {
    public DevolucaoException(String message) {
        super(message);
    }
}