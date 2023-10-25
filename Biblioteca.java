import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    private ArrayList<Livro> livros;
    private ArrayList<midiaDigital> midiasDigitais;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
        this.midiasDigitais = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void adicionarMidiaDigital(midiaDigital midiaDigital) {
        this.midiasDigitais.add(midiaDigital);
    }

    public void listarLivros() {
        System.out.println("Livros disponíveis na biblioteca " + nome + ":");
        for (Livro livro : livros) {
            System.out.println(livro.toString());
        }
    }

    public void listarMidiasDigitais() {
        System.out.println("Mídias digitais disponíveis na biblioteca " + nome + ":");
        for (midiaDigital midiaDigital : midiasDigitais) {
            System.out.println(midiaDigital.toString());
        }
    }

    public String getNome() {
        return nome;
    }

    public void emprestarLivro(String tituloLivro) throws EmprestimoException {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(tituloLivro) && livro.isDisponivel()) {
                livro.emprestar();
                return;
            }
        }
        throw new EmprestimoException("Livro não encontrado ou não disponível para empréstimo.");
    }

    public void devolverLivro(String tituloLivro) throws DevolucaoException {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(tituloLivro) && !livro.isDisponivel()) {
                livro.devolver();
                return;
            }
        }
        throw new DevolucaoException("Livro não encontrado ou já disponível na biblioteca.");
    }

    public void emprestarMidiaDigital(String tituloMidia) throws EmprestimoException {
        for (midiaDigital midiaDigital : midiasDigitais) {
            if (midiaDigital.getTitulo().equals(tituloMidia) && midiaDigital.isDisponivel()) {
                midiaDigital.emprestar();
                return;
            }
        }
        throw new EmprestimoException("Mídia digital não encontrada ou não disponível para empréstimo.");
    }

    public void devolverMidiaDigital(String tituloMidia) throws DevolucaoException {
        for (midiaDigital midiaDigital : midiasDigitais) {
            if (midiaDigital.getTitulo().equals(tituloMidia) && !midiaDigital.isDisponivel()) {
                midiaDigital.devolver();
                return;
            }
        }
        throw new DevolucaoException("Mídia digital não encontrada ou já disponível na biblioteca.");
    }
}