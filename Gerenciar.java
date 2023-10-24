import java.util.Scanner;

public class Gerenciar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op = 0;

        do {
            System.out.println("Minha Biblioteca");
            System.out.println("0 - Sair");
            System.out.println("1 - Criar autor");
            System.out.println("2 - Criar livro");
            System.out.println("3 - Criar biblioteca");
            System.out.println("4 - Adicionar livro");
            System.out.println("5 - Emprestar livro");
            System.out.println("6 - Devolver livro");
            System.out.println("7 - Listar livros");
            System.out.println("8 - Criar midia");
            System.out.println("9 - Emprestar midia");
            System.out.println("10 - Devolver midia");
            System.out.println("11 - Listar midias");
            try {
                op = sc.nextInt();
            } catch (Exception e) {
                op = 99;
            }

            switch (op) {
                case 0: {
                    System.out.println("Sair....");
                    break;
                }
                case 1: {
                    System.out.println("Digite o nome do autor");
                    String nome = sc.next();
                    System.out.println("Digite o nacionalidade do autor");
                    String nacionalidade = sc.next();
                    new Autor(nome, nacionalidade);
                    break;
                }
                case 2: {
                    System.out.println("Digite o titulo");
                    String titulo = sc.next();
                    int posicaoAutor = -1;
                    do {
                        Autor.listarAutores();
                        try {
                            posicaoAutor = sc.nextInt();
                            if (posicaoAutor >= Autor.getAutores().size()) {
                                throw new Exception("Autor inválido");
                            }
                        } catch (Exception e) {
                            System.out.println("Autor inválido");
                            posicaoAutor = -1;
                        }
                    } while (posicaoAutor < 0);

                    Autor autor = Autor.getAutores().get(posicaoAutor);
                    new Livro(titulo, autor, true);
                    break;
                }
                case 3: {
                    System.out.println("Digite o nome da biblioteca");
                    String nomeBiblioteca = sc.next();
                    new Biblioteca(nomeBiblioteca, null);
                    break;
                }
                case 4: {
                    int posicaoBiblioteca = -1;
                    do {
                        Biblioteca.listarBibliotecas();
                        try {
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca inválida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca inválida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);

                    Biblioteca biblioteca = Biblioteca.bibliotecas.get(posicaoBiblioteca);

                    int posicaoLivro = -1;
                    do {
                        Livro.listarLivros();
                        try {
                            posicaoLivro = sc.nextInt();
                            if (posicaoLivro >= Livro.livros.size()) {
                                throw new Exception("Livro inválido");
                            }
                        } catch (Exception e) {
                            System.out.println("Livro inválido");
                            posicaoLivro = -1;
                        }
                    } while (posicaoLivro < 0);

                    Livro livro = Livro.livros.get(posicaoLivro);

                    biblioteca.adicionarLivro(livro);
                    break;
                }
                case 5: {
                    int posicaoBiblioteca = -1;
                    do {
                        Biblioteca.listarBibliotecas();
                        try {
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca inválida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca inválida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);

                    Biblioteca biblioteca = Biblioteca.bibliotecas.get(posicaoBiblioteca);

                    int posicaoLivro = -1;
                    do {
                        biblioteca.listarLivros();
                        try {
                            posicaoLivro = sc.nextInt();
                            if (posicaoLivro >= Livro.livros.size()) {
                                throw new Exception("Livro inválido");
                            }
                        } catch (Exception e) {
                            System.out.println("Livro inválido");
                            posicaoLivro = -1;
                        }
                    } while (posicaoLivro < 0);

                    Livro livro = biblioteca.livros.get(posicaoLivro);
                    try {
                        livro.emprestar();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 6: {
                    int posicaoBiblioteca = -1;
                    do {
                        Biblioteca.listarBibliotecas();
                        try {
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca inválida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca inválida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);

                    Biblioteca biblioteca = Biblioteca.bibliotecas.get(posicaoBiblioteca);

                    int posicaoLivro = -1;
                    do {
                        biblioteca.listarLivros();
                        try {
                            posicaoLivro = sc.nextInt();
                            if (posicaoLivro >= Livro.livros.size()) {
                                throw new Exception("Livro inválido");
                            }
                        } catch (Exception e) {
                            System.out.println("Livro inválido");
                            posicaoLivro = -1;
                        }
                    } while (posicaoLivro < 0);

                    Livro livro = biblioteca.livros.get(posicaoLivro);
                    try {
                        livro.devolver();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 7: {
                    System.out.println("Lista de Livros Disponíveis:");
                    for (Biblioteca biblioteca : Biblioteca.bibliotecas) {
                        biblioteca.listarLivros();
                    }
                    break;
                }
                case 8: {
                    System.out.println("Digite o nome do título: ");
                    String novoTitulo = sc.next();

                    Midia novaMidia = new Midia(novoTitulo, true);

                    Midia.midias.add(novaMidia);
                    System.out.println("Mídia criada com sucesso: " + novaMidia.toString());
                    break;
                }
                    case 9: {
                        int posicaoMidia = -1;
                        do {
                            Midia.listarMidias();
                            try {
                                posicaoMidia = sc.nextInt();
                                if (posicaoMidia < 0 || posicaoMidia >= Midia.getMidias().size()) {
                                    throw new Exception("Mídia inválida");
                                }
                            } catch (Exception e) {
                                System.out.println("Mídia inválida");
                                sc.nextLine(); // Limpa o buffer de entrada
                                posicaoMidia = -1;
                            }
                        } while (posicaoMidia < 0);
                    
                        Midia midia = Midia.getMidias().get(posicaoMidia);
                    
                        System.out.println("1 - Emprestar a mídia");
                        System.out.println("2 - Devolver a mídia");
                        int opcao = sc.nextInt();
                    
                        if (opcao == 1) {
                            try {
                                midia.emprestar();
                                System.out.println("Mídia emprestada com sucesso.");
                            } catch (EmprestimoException e) {
                                System.out.println("Erro ao emprestar a mídia: " + e.getMessage());
                            }
                        } else if (opcao == 2) {
                            try {
                                midia.devolver();
                                System.out.println("Mídia devolvida com sucesso.");
                            } catch (DevolucaoException e) {
                                System.out.println("Erro ao devolver a mídia: " + e.getMessage());
                            }
                    
                        break;
                    }
                }
                case 10: {
                    int posicaoMidia = -1;
                    do {
                        Midia.listarMidias();
                        try {
                            posicaoMidia = sc.nextInt();
                            if (posicaoMidia >= Midia.getMidias().size()) {
                                throw new Exception("Mídia inválida");
                            }
                        } catch (Exception e) {
                            System.out.println("Mídia inválida");
                            posicaoMidia = -1;
                        }
                    } while (posicaoMidia < 0);

                    Midia midia = Midia.getMidias().get(posicaoMidia);

                    break;
                }
                case 11: {
                    System.out.println("Lista de Midias Disponíveis:");
                    for (Midia midias : Midia.midias) {
                        midias.listarMidias();
                    }
                    break;
                }
                default: {
                    System.out.println("Opção inválida");
                    break;
                }
            }
        } while (op != 0);
        sc.close();
    }
}
