package principal;

import entidades.Usuario;
import entidades.Autor;
import entidades.Biblioteca;
import entidades.Cd;
import entidades.Item;
import entidades.Livro;
import entidades.Revista;

import java.util.Scanner;
import enums.EnumUsuario;

public class Principal {
    static Biblioteca lib;
    static Usuario loggedUser;

    public static void main(String[] args) {
        lib = new Biblioteca();

        addDefaultUser();

        Scanner input = new Scanner(System.in);
        char reader = '2';

        do {
            System.out.println("************** Bem-Vindo *********************\n\n");

            System.out.println("1) Login\n");
            System.out.println("2) Sair\n");

            reader = input.nextLine().charAt(0);

            if (reader == '1') {
                clean();
                goLogin();

                reader = '2';
            }

        } while (reader != '2');
    }

    private static void clean() {
        System.out.println("\n\n\n");
    }

    private static void addDefaultUser() {
        Usuario isptec = new Usuario("Biblioteca", "Isptec", EnumUsuario.TipoUsuario.bibliotecario, "isptec", "123");
        Usuario jose = new Usuario("José", "Ndonge", EnumUsuario.TipoUsuario.estudante, "jose", "123");

        lib.inserirUsuario(jose);
        lib.inserirUsuario(isptec);
    }

    private static void goLogin() {
        System.out.println("*********** LOGIN **************\n\n");

        int tentativas = 3;

        Scanner input = new Scanner(System.in);

        String username = "";
        String password = "";

        loggedUser = null;

        do {
            System.out.print("Usuário: ");
            username = input.nextLine();

            System.out.print("Senha: ");
            password = input.nextLine();

            for (Usuario iUser : lib.getUsuarios()) {
                if (iUser.getSenha().equals(password) && iUser.getUsername().equals(username)) {
                    loggedUser = iUser;
                    clean();

                    if (EnumUsuario.TipoUsuario.bibliotecario == loggedUser.getTipo())
                        goMainMenu();
                    else
                        goMainMenuUserNormal();
                    break;
                }
            }

            tentativas--;

            if (loggedUser == null) {
                System.out.println("Falha no login restam " + tentativas + " tentativa(s)\n\n");
            }
        } while (loggedUser == null && tentativas > 0);
    }

    private static void goInsertLivro() {
        Scanner input = new Scanner(System.in);
        System.out.println("*********** MENU PRINCIPAL > INSERIR > LIVRO **************\n\n");

        System.out.print("Título: ");
        String titulo = input.nextLine();

        System.out.print("Data: ");
        String data = input.nextLine();

        System.out.print("Nº Páginas: ");
        int nPaginas = input.nextInt();

        Livro livro = new Livro(titulo, data, nPaginas);

        lib.inserirItem(livro);

        System.out.println("\n\n*********** livro inserido com sucesso **************\n\n");
    }

    private static void goInsertCD() {
        Scanner input = new Scanner(System.in);
        System.out.println("*********** MENU PRINCIPAL > INSERIR > CD **************\n\n");

        System.out.print("Título: ");
        String titulo = input.nextLine();

        System.out.print("Data: ");
        String data = input.nextLine();

        System.out.print("Tempo de reprodução: ");
        int tempoDeReproducao = input.nextInt();

        Cd cd = new Cd(titulo, data, tempoDeReproducao);

        lib.inserirItem(cd);

        System.out.println("\n\n*********** CD inserido com sucesso **************\n\n");
    }

    private static void goInsertUtilizador() {
        Scanner input = new Scanner(System.in);
        System.out.println("*********** MENU PRINCIPAL > INSERIR > UTILIZADOR **************\n\n");

        System.out.print("Título: ");
        String titulo = input.nextLine();

        System.out.print("Data: ");
        String data = input.nextLine();

        System.out.print("Tempo de reprodução: ");
        int tempoDeReproducao = input.nextInt();

        Usuario user = new  Usuario(data, data, null, titulo, data)

        lib.inserirUsuario(user);

        System.out.println("\n\n*********** CD inserido com sucesso **************\n\n");
    }

    private static void goInsertRevista() {
        Scanner input = new Scanner(System.in);
        System.out.println("*********** MENU PRINCIPAL > INSERIR > REVISTA **************\n\n");

        System.out.print("Título: ");
        String titulo = input.nextLine();

        System.out.print("Data: ");
        String data = input.nextLine();

        System.out.print("Nº de edições: ");
        int numeroDeEdicoes = input.nextInt();

        Revista revista = new Revista(titulo, data, numeroDeEdicoes);

        lib.inserirItem(revista);

        System.out.println("\n\n*********** Revista inserido com sucesso **************\n\n");
    }

    private static void goInsert() {
        char chave = '1';
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("*********** MENU PRINCIPAL > INSERIR **************\n\n");

            System.out.println("1) Livro\n");
            System.out.println("2) CD\n");
            System.out.println("3) Revista\n");
            System.out.println("4) Utilizador\n");
            System.out.println("5) Autor\n");
            System.out.println("x) Voltar\n");

            chave = input.nextLine().charAt(0);

            if (chave == '1')
                goInsertLivro();

            if (chave == '2')
                goInsertCD();

            if (chave == '3')
                goInsertRevista();

            if (chave == '4')
                goInsertUtilizador();

        } while (chave != 'x');
    }

    private static void goListLivro() {
        System.out.println("\n\n*********** LISTA DE LIVROS **************\n");

        for (Item item : lib.getItens()) {
            if (item instanceof Livro) {
                Livro k = (Livro) item;
                System.out.println("Título: " + k.getTitulo());
                System.out.println("Data: " + k.getData());
                System.out.println("Nº Páginas: " + k.getNumeroDePaginas());
                System.out.println("\n******* Autores ******\n");
                for (Autor autor : k.getAutores()) {
                    System.out.println(autor.getNome() + " " + autor.getSobrenome());
                }
            }
        }

        System.out.println("\n\n");
    }

    private static void goListCD() {
        System.out.println("\n\n*********** LISTA DE CD **************\n");

        for (Item item : lib.getItens()) {
            if (item instanceof Cd) {
                Cd k = (Cd) item;
                System.out.println("Título: " + k.getTitulo());
                System.out.println("Data: " + k.getData());
                System.out.println("Tempo de Reprodução: " + k.getTempoDeReproducao());
                System.out.println("\n******* Autores ******\n");
                for (Autor autor : k.getAutores()) {
                    System.out.println(autor.getNome() + " " + autor.getSobrenome());
                }
            }
        }

        System.out.println("\n\n");
    }

    private static void goListRevista() {
        System.out.println("\n\n*********** LISTA DE REVISTA **************\n");

        for (Item item : lib.getItens()) {
            if (item instanceof Revista) {
                Revista k = (Revista) item;
                System.out.println("Título: " + k.getTitulo());
                System.out.println("Data: " + k.getData());
                System.out.println("Número de Edições: " + k.getNumeroDeEdicoes());
                System.out.println("\n******* Autores ******\n");
                for (Autor autor : k.getAutores()) {
                    System.out.println(autor.getNome() + " " + autor.getSobrenome());
                }
            }
        }

        System.out.println("\n\n");
    }

    private static void goListUtilizador() {
        System.out.println("\n\n*********** LISTA DE UTILIZADOR **************\n");

        for (Usuario user : lib.getUsuarios()) {
            System.out.println("Nome: " + user.getNome());
            System.out.println("Sobrenome: " + user.getSobrenome());
            System.out.println("Tipo: " + user.getTipo());
            System.out.println("Username: " + user.getUsername());
        }

        System.out.println("\n\n");
    }

    private static void goList() {
        char chave = '1';
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("*********** MENU PRINCIPAL > LISTAR **************\n\n");

            System.out.println("1) Livro\n");
            System.out.println("2) CD\n");
            System.out.println("3) Revista\n");
            System.out.println("4) Utilizador\n");
            System.out.println("x) Voltar\n");

            chave = input.nextLine().charAt(0);

            if (chave == '1')
                goListLivro();

            if (chave == '2')
                goListCD();

            if (chave == '3')
                goListRevista();

            if (chave == '4')
                goListUtilizador();

        } while (chave != 'x');
    }

    private static void goMainMenu() {
        char chave = '1';
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("*********** MENU PRINCIPAL **************\n\n");

            System.out.println("1) Inserir\n");
            System.out.println("2) Listar\n");
            System.out.println("3) Alterar\n");
            System.out.println("4) Eliminar\n");
            System.out.println("x) Sair\n");

            chave = input.nextLine().charAt(0);

            if (chave == '1') {
                clean();
                goInsert();
            }

            if (chave == '2') {
                clean();
                goList();
            }

        } while (chave != 'x');
    }

    private static void goMainMenuUserNormal() {
        char chave = '1';
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("*********** MENU PRINCIPAL **************\n\n");

            System.out.println("1) Emprestar Livro\n");
            System.out.println("2) Emprestar CD\n");
            System.out.println("3) Emprestar Revista\n");

            System.out.println("4) Ver Itens Imprestados\n");
            System.out.println("5) Ver Itens Disponiveis\n");

            System.out.println("x) Sair\n");

            chave = input.nextLine().charAt(0);

        } while (chave != 'x');
    }
}
