import java.util.ArrayList;

public class Biblioteca { // aqui foi criado a classe biblioteca
    private String nome;
    private ArrayList<Livro> livros;
    private ArrayList<midiaDigital> midiasDigitais;

    public Biblioteca(String nome) { // aqui foi criado o construtor da classe biblioteca
        this.nome = nome;
        this.livros = new ArrayList<>();
        this.midiasDigitais = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) { // aqui foi criado o método adicionarLivro

        this.livros.add(livro); // aqui foi criado o método adicionarLivro
    }

    public void adicionarMidiaDigital(midiaDigital midiaDigital) { // aqui foi criado o método adicionarMidiaDigital
        this.midiasDigitais.add(midiaDigital); // aqui foi criado o método adicionarMidiaDigital
    }

    public void listarLivros() { // aqui foi criado o método listarLivros
        System.out.println("Livros disponíveis na biblioteca " + nome + ":"); // aqui foi criado o método listarLivros
        for (Livro livro : livros) { // irá imprimir os livros
            System.out.println(livro.toString());
        }
    }

    public void listarMidiasDigitais() { // aqui foi criado o método listarMidiasDigitais
        System.out.println("Mídias digitais disponíveis na biblioteca " + nome + ":"); // aqui foi criado o método
                                                                                       // listarMidiasDigitais
        for (midiaDigital midiaDigital : midiasDigitais) { // irá imprimir as midias digitais
            System.out.println(midiaDigital.toString());
        }
    }

    public String getNome() { // aqui foi criado o método getNome
        return nome;
    }

    public void emprestarLivro(String tituloLivro) throws EmprestimoException { // aqui foi criado o método
                                                                                // emprestarLivro
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(tituloLivro) && livro.isDisponivel()) { // se o livro estiver disponível, ele
                                                                                 // irá emprestar
                livro.emprestar();
                return;
            }
        }
        throw new EmprestimoException("Livro não encontrado ou não disponível para empréstimo."); // se o livro não
                                                                                                  // estiver
                                                                                                  // disponível, irá
                                                                                                  // aparecer a
                                                                                                  // mensagem de
                                                                                                  // erro
    }

    public void devolverLivro(String tituloLivro) throws DevolucaoException { // aqui foi criado o método devolverLivro
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(tituloLivro) && !livro.isDisponivel()) { // se o livro não estiver
                                                                                  // disponível, ele irá devolver
                livro.devolver();
                return;
            }
        }
        throw new DevolucaoException("Livro não encontrado ou já disponível na biblioteca.");
    }

    public void emprestarMidiaDigital(String tituloMidia) throws EmprestimoException { // aqui foi criado o método
                                                                                       // emprestarMidiaDigital
        for (midiaDigital midiaDigital : midiasDigitais) {
            if (midiaDigital.getTitulo().equals(tituloMidia) && midiaDigital.isDisponivel()) { // se a midia digital
                                                                                               // estiver
                                                                                               // disponível, ele irá
                                                                                               // emprestar
                midiaDigital.emprestar();
                return;
            }
        }
        throw new EmprestimoException("Mídia digital não encontrada ou não disponível para empréstimo.");
    }

    public void devolverMidiaDigital(String tituloMidia) throws DevolucaoException { // aqui foi criado o método
                                                                                     // devolverMidiaDigital
        for (midiaDigital midiaDigital : midiasDigitais) {
            if (midiaDigital.getTitulo().equals(tituloMidia) && !midiaDigital.isDisponivel()) { // se a midia digital
                                                                                                // não estiver
                                                                                                // disponível, ele irá
                                                                                                // devolver
                midiaDigital.devolver();
                return;
            }
        }
        throw new DevolucaoException("Mídia digital não encontrada ou já disponível na biblioteca.");
    }
}