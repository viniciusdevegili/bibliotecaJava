import java.util.ArrayList;

public class Biblioteca {
    public String nome;
    public ArrayList<Livro> livros;
    public ArrayList<Midia> midias;

    public static ArrayList<Biblioteca> bibliotecas = new ArrayList<>();

    public Biblioteca(String nome, Midia midia) {
        this.nome = nome;
        this.livros = new ArrayList<>();
        this.midias = new ArrayList<>();

        bibliotecas.add(this);
    }

    public String toString() {
        return "Nome: " + this.nome;
    }

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void listarLivros() {
        for (int i = 0; i < this.livros.size(); i++) {
            System.out.println(i + " - " + this.livros.get(i).toString());
        }
    }

    public static void listarBibliotecas() {
        for (int i = 0; i < bibliotecas.size(); i++) {
            Biblioteca biblioteca = bibliotecas.get(i);
            System.out.println(i + " - " + biblioteca.toString());
            biblioteca.listarLivros();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public ArrayList<Midia> getMidia() {
        return midias;
    }

    public void setMidia(ArrayList<Midia> midia) {
        this.midias = midia;
    }

    public static ArrayList<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public static void setBibliotecas(ArrayList<Biblioteca> bibliotecas) {
        Biblioteca.bibliotecas = bibliotecas;
    }
}