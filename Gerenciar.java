import java.util.Scanner;

public class Gerenciar { // aqui foi criado a classe gerenciar
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca("Minha Biblioteca");

        int op;

        do { // aqui foi criado o método do
            System.out.println("Biblioteca: " + biblioteca.getNome());
            System.out.println("0 - Sair");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Adicionar Mídia Digital");
            System.out.println("3 - Listar Livros Disponíveis");
            System.out.println("4 - Listar Mídias Digitais Disponíveis");
            System.out.println("5 - Adicionar Autor");
            System.out.println("6 - Listar Autores");
            System.out.println("7 - Emprestar Livro");
            System.out.println("8 - Devolver Livro");
            System.out.println("9 - Emprestar Mídia Digital");
            System.out.println("10 - Devolver Mídia Digital");
            try {
                op = sc.nextInt();
            } catch (Exception e) {
                op = -1;
            }

            switch (op) {
                case 0:
                    System.out.println("Saindo...");
                    break;

                case 1: // aqui foi criado Adicionar Livro
                    sc.nextLine(); // Limpar o buffer
                    System.out.println("Digite o título do livro:");
                    String tituloLivro = sc.nextLine();
                    System.out.println("Digite o nome do autor:");
                    String nomeAutor = sc.nextLine();

                    Autor autor = new Autor(nomeAutor);
                    Livro livro = new Livro(tituloLivro, autor);

                    biblioteca.adicionarLivro(livro);
                    break;

                case 2:
                    sc.nextLine(); // Limpar o buffer
                    System.out.println("Digite o título da mídia digital:");
                    String tituloMidia = sc.nextLine();
                    System.out.println("Digite o nome do álbum:");
                    String albumMidia = sc.nextLine();

                    midiaDigital midiaDigital = new midiaDigital(tituloMidia, albumMidia);

                    biblioteca.adicionarMidiaDigital(midiaDigital);
                    break;

                case 3:
                    biblioteca.listarLivros();
                    break;

                case 4:
                    biblioteca.listarMidiasDigitais();
                    break;

                case 5:
                    sc.nextLine(); // Limpar o buffer
                    System.out.println("Digite o nome do autor:");
                    String nomeNovoAutor = sc.nextLine();

                    Autor novoAutor = new Autor(nomeNovoAutor);
                    break;

                case 6:
                    Autor.listarAutores();
                    break;

                case 7:
                    sc.nextLine(); // Limpar o buffer
                    System.out.println("Digite o título do livro para emprestar:");
                    String tituloLivroEmprestar = sc.nextLine();

                    try {
                        biblioteca.emprestarLivro(tituloLivroEmprestar);
                        System.out.println("Livro emprestado com sucesso.");
                    } catch (EmprestimoException e) {
                        System.out.println("Erro ao emprestar o livro: " + e.getMessage());
                    }
                    break;

                case 8:
                    sc.nextLine(); // Limpar o buffer
                    System.out.println("Digite o título do livro para devolver:");
                    String tituloLivroDevolver = sc.nextLine();

                    try {
                        biblioteca.devolverLivro(tituloLivroDevolver);
                        System.out.println("Livro devolvido com sucesso.");
                    } catch (DevolucaoException e) {
                        System.out.println("Erro ao devolver o livro: " + e.getMessage());
                    }
                    break;

                case 9:
                    sc.nextLine(); // Limpar o buffer
                    System.out.println("Digite o título da mídia digital para emprestar:");
                    String tituloMidiaEmprestar = sc.nextLine();

                    try {
                        biblioteca.emprestarMidiaDigital(tituloMidiaEmprestar);
                        System.out.println("Mídia digital emprestada com sucesso.");
                    } catch (EmprestimoException e) {
                        System.out.println("Erro ao emprestar a mídia digital: " + e.getMessage());
                    }
                    break;

                case 10:
                    sc.nextLine(); // Limpar o buffer
                    System.out.println("Digite o título da mídia digital para devolver:");
                    String tituloMidiaDevolver = sc.nextLine();

                    try {
                        biblioteca.devolverMidiaDigital(tituloMidiaDevolver);
                        System.out.println("Mídia digital devolvida com sucesso.");
                    } catch (DevolucaoException e) {
                        System.out.println("Erro ao devolver a mídia digital: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (op != 0);

        sc.close();
    }
}
