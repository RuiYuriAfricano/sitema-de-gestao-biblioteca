package entidades;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Item> itens;
    private ArrayList<Usuario> usuarios;
    private ArrayList<ItemEmprestado> itensEmprestados;

    public Biblioteca() {
        itens = new ArrayList<>();
        usuarios = new ArrayList<>();
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

            System.out.println("------------------------------------------------------------\n\n");
        }
    }
    // ***** Eliminar item
    public void eliminarItem(Item item){
        this.itens.remove(item);
    }
    // ***** Alterar item
    public void alterarItem(Item item){
        for(int i = 0; i < this.itens.size(); i++){
            if(this.itens.get(i) == item)
            {
                this.itens.add(i, item);
            }
        }
    }

    // ***** Inserir usuário
    // ***** Listar usuários
    // ***** Eliminar usuário
    // ***** Alterar usuário

    // Métodos para manipular os usuários
    // ***** Listar Itens Emprestados
    // ***** Emprestar
}
