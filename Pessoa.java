public class Pessoa { // aqui foi criada a classe Pessoa
    private String nome;

    public Pessoa(String nome) { // aqui foi criado o construtor da classe Pessoa
        this.nome = nome;
    }

    public String getNome() { // aqui foi criado o método getNome
        return nome;
    }
}

class EmprestimoException extends Exception { // aqui foi criado a classe EmprestimoException
    public EmprestimoException(String message) {
        super(message);
    }
}

class DevolucaoException extends Exception { // aqui foi criado a classe DevolucaoException
    public DevolucaoException(String message) {
        super(message);
    }
}