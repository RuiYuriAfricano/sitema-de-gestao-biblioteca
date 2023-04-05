package principal;

import entidades.Usuario;
import entidades.Biblioteca;
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

    private static void goMainMenu() {
        System.out.println("*********** MENU PRINCIPAL **************\n\n");
        char chave = '1';
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("1) Criar Livro\n");
            System.out.println("2) Criar CD\n");
            System.out.println("3) Criar Revista\n");
            System.out.println("4) Criar Usuário\n");
            System.out.println("x) Sair\n");

            chave = input.nextLine().charAt(0);

        } while (chave != 'x');
    }

    private static void goMainMenuUserNormal() {
        System.out.println("*********** MENU PRINCIPAL **************\n\n");
        char chave = '1';
        Scanner input = new Scanner(System.in);

        do {
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
