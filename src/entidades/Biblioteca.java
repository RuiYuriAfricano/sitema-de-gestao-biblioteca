package entidades;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Item> itens;
    private ArrayList<Usuario> usuarios;
    private ArrayList<ItemEmprestado> itensEmprestados;

    public Biblioteca() {
        itens = new ArrayList<>();
        usuarios = new ArrayList<>();
        itensEmprestados = new ArrayList<>();
    }

    // Métodos para o bibliotecário manipular
    // ***** Inserir item
    public void inserirItem(Item item) {
        itens.add(item);
    }

    // ***** Listar item
    public void listarItens() {
        System.out.println("==============================LISTAR ITENS==============================");
        for (Item item : this.itens) {
            System.out.println("------------------------------------------------------------");
            // Mostrar titulo
            System.out.println("Título: " + item.titulo);
            // Mostrar autores
            System.out.println("Autores: ");
            for (Autor autor : item.autores) {
                System.out.println("- " + autor.getNome() + " " + autor.getSobrenome());
            }
            // Mostrar data de publicação
            System.out.println("Data de publicação: " + item.data);

            if (item instanceof Livro) {
                Livro livro = (Livro) item;
                System.out.println("Item: Livro");
                System.out.println("Número de páginas: " + livro.getNumeroDePaginas());
            } else if (item instanceof Revista) {
                Revista revista = (Revista) item;
                System.out.println("Item: Revista");
                System.out.println("Número de edições: " + revista.getNumeroDeEdicoes());
            } else if (item instanceof Cd) {
                Cd cd = (Cd) item;
                System.out.println("Item: Cd");
                System.out.println("Tempo de reprodução: " + cd.getTempoDeReproducao());
            }

            System.out.println("------------------------------------------------------------\n\n");
        }
    }

    // ***** Listar Itens Emprestados
    public void listarItensEmprestado() {
        System.out.println("==============================LISTAR ITENS EMPRESTADOS==============================");
        System.out.println(" DADOS DO ITEM\n_______________");
        for (ItemEmprestado item : this.itensEmprestados) {
            System.out.println("------------------------------------------------------------");
            // Mostrar titulo
            System.out.println("Título: " + item.getItem().titulo);
            // Mostrar autores
            System.out.println("Autores: ");
            for (Autor autor : item.getItem().autores) {
                System.out.println("- " + autor.getNome() + " " + autor.getSobrenome());
            }
            // Mostrar data de publicação
            System.out.println("Data de publicação: " + item.getItem().data);

            if (item.getItem() instanceof Livro) {
                Livro livro = (Livro) item.getItem();
                System.out.println("Item: Livro");
                System.out.println("Número de páginas: " + livro.getNumeroDePaginas());
            } else if (item.getItem() instanceof Revista) {
                Revista revista = (Revista) item.getItem();
                System.out.println("Item: Revista");
                System.out.println("Número de edições: " + revista.getNumeroDeEdicoes());
            } else if (item.getItem() instanceof Cd) {
                Cd cd = (Cd) item.getItem();
                System.out.println("Item: Cd");
                System.out.println("Tempo de reprodução: " + cd.getTempoDeReproducao());
            }
            System.out.println(" DADOS DO USUÁRIO\n__________________");
            System.out
                    .println("Nome Completo: " + item.getUsuario().getNome() + " " + item.getUsuario().getSobrenome());
            System.out.println(" DADOS DO EMPRÉSTIMO\n______________________");
            System.out.println("Data de empréstimo: " + item.getDataEmprestimo());
            System.out.println("Data de devolução: " + item.getDataDevolucao());

            System.out.println("------------------------------------------------------------\n\n");
        }
    }

    // ***** Eliminar item
    public void eliminarItem(Item item) {
        this.itens.remove(item);
    }

    // ***** Alterar item
    public void alterarItem(Item item) {
        for (int i = 0; i < this.itens.size(); i++) {
            if (this.itens.get(i) == item) {
                this.itens.add(i, item);
            }
        }
    }

    // ***** Inserir usuário
    public void inserirUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    // ***** Listar usuários
    public void listarUsuario() {
        System.out.println("==============================LISTAR USUÁRIOS==============================");
        for (Usuario user : this.usuarios) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Nome Completo: " + user.getNome() + " " + user.getSobrenome());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Tipo: " + user.getTipo());
        }
        System.out.println("------------------------------------------------------------\n\n");
    }

    // ***** Eliminar usuário
    public void eliminarUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    // ***** Alterar usuário
    public void alterarUsuario(Usuario usuario) {
        for (int i = 0; i < this.usuarios.size(); i++) {
            if (this.usuarios.get(i) == usuario) {
                this.usuarios.add(i, usuario);
            }
        }
    }

    // Métodos para o usuario manipular
    // ***** Listar Itens Emprestados
    public void visualizarItensEmprestado(Usuario user) {

        System.out.println("==============================LISTAR ITENS EMPRESTADOS==============================");
        System.out.println(" DADOS DO ITEM\n_______________");
        for (ItemEmprestado item : this.itensEmprestados) {

            if (item.getUsuario() == user) {

                System.out.println("------------------------------------------------------------");
                // Mostrar titulo
                System.out.println("Título: " + item.getItem().titulo);
                // Mostrar autores
                System.out.println("Autores: ");
                for (Autor autor : item.getItem().autores) {
                    System.out.println("- " + autor.getNome() + " " + autor.getSobrenome());
                }
                // Mostrar data de publicação
                System.out.println("Data de publicação: " + item.getItem().data);

                if (item.getItem() instanceof Livro) {
                    Livro livro = (Livro) item.getItem();
                    System.out.println("Item: Livro");
                    System.out.println("Número de páginas: " + livro.getNumeroDePaginas());
                } else if (item.getItem() instanceof Revista) {
                    Revista revista = (Revista) item.getItem();
                    System.out.println("Item: Revista");
                    System.out.println("Número de edições: " + revista.getNumeroDeEdicoes());
                } else if (item.getItem() instanceof Cd) {
                    Cd cd = (Cd) item.getItem();
                    System.out.println("Item: Cd");
                    System.out.println("Tempo de reprodução: " + cd.getTempoDeReproducao());
                }
                System.out.println(" DADOS DO USUÁRIO\n__________________");
                System.out.println(
                        "Nome Completo: " + item.getUsuario().getNome() + " " + item.getUsuario().getSobrenome());
                System.out.println(" DADOS DO EMPRÉSTIMO\n______________________");
                System.out.println("Data de empréstimo: " + item.getDataEmprestimo());
                System.out.println("Data de devolução: " + item.getDataDevolucao());

                System.out.println("------------------------------------------------------------\n\n");
            }
        }
    }

    // ***** Emprestar item
    public void emprestarItem(Item item, Usuario user, String dataEmprestimo, String dataDevolucao) {
        ItemEmprestado itemp = new ItemEmprestado(item, user, dataEmprestimo, dataDevolucao);
        this.itensEmprestados.add(itemp);
    }

    // ****** Devolver item
    public void devolverItem(Item item) {
        for (int i = 0; i < itensEmprestados.size(); i++) {
            if (this.itensEmprestados.get(i).getItem() == item) {
                ItemEmprestado itEm = this.itensEmprestados.get(i);
                this.itensEmprestados.remove(itEm);
            }
        }
    }

    // ****** Listar Itens Disponíveis
    public void listarItensDisponiveis() {
        System.out.println("==============================LISTAR ITENS DISPONÍVEIS==============================");
        for (Item item : this.itens) {
            if (!procurarNosEmprestados(item)) {
                System.out.println("------------------------------------------------------------");
                // Mostrar titulo
                System.out.println("Título: " + item.titulo);
                // Mostrar autores
                System.out.println("Autores: ");
                for (Autor autor : item.autores) {
                    System.out.println("- " + autor.getNome() + " " + autor.getSobrenome());
                }
                // Mostrar data de publicação
                System.out.println("Data de publicação: " + item.data);

                if (item instanceof Livro) {
                    Livro livro = (Livro) item;
                    System.out.println("Item: Livro");
                    System.out.println("Número de páginas: " + livro.getNumeroDePaginas());
                } else if (item instanceof Revista) {
                    Revista revista = (Revista) item;
                    System.out.println("Item: Revista");
                    System.out.println("Número de edições: " + revista.getNumeroDeEdicoes());
                } else if (item instanceof Cd) {
                    Cd cd = (Cd) item;
                    System.out.println("Item: Cd");
                    System.out.println("Tempo de reprodução: " + cd.getTempoDeReproducao());
                }

                System.out.println("------------------------------------------------------------\n\n");
            }
        }
    }

    // ***** Procurar na lista dos emprestados
    private boolean procurarNosEmprestados(Item item) {
        int i = 0;
        for (i = 0; i < this.itensEmprestados.size() && this.itensEmprestados.get(i).getItem() != item; i++) {
        }
        if (i < this.itensEmprestados.size())
            return true;

        return false;
    }
}
