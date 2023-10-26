import java.util.ArrayList;

public class Autor extends Pessoa { // aqui foi criado a classe autor, com uma extensão para a classe pessoa
    private String nacionalidade;
    private static ArrayList<Autor> autores = new ArrayList<Autor>();

    public Autor(String nome) { // aqui foi criado o construtor da classe autor
        super(nome);
        this.nacionalidade = nacionalidade;
        autores.add(this);
    }

    public Autor(String nome, String nacionalidade) { // aqui foi criado o construtor da classe autor
        super(nome);
        this.nacionalidade = "Brasil";
        autores.add(this);
    }

    public void setNacionalidade(String nacionalidade) { // aqui foi criado o método setNacionalidade
        this.nacionalidade = nacionalidade;
    }

    public String getNacionalidade() { // aqui foi criado o método getNacionalidade
        return this.nacionalidade;
    }

    public static ArrayList<Autor> getAutores() { // aqui foi criado o método getAutores
        return autores;
    }

    public static void listarAutores() { // aqui foi criado o método listarAutores
        for (int i = 0; i < autores.size(); i++) { // aqui foi criado o for para listar os autores
            System.out.println(i + " - " + autores.get(i).toString());

        }
    }

    public String toString() { // aqui foi criado o método toString
        return "Nome: " + this.getNome() + ". Nacionalidade: " + this.nacionalidade;
    }
}