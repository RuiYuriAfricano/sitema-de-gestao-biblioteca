package entidades;

import java.util.ArrayList;

public class Biblioteca {

    public ArrayList<Item> itens;
    public ArrayList<Usuario> usuarios;

    public Biblioteca(){
        itens = new ArrayList<>();
        usuarios = new ArrayList<>();
    }
    //Métodos para o bibliotecário manipular 
    //***** Inserir item
    public void inserirItem(Item item){
        itens.add(item);
    }


    //***** Listar item
    public void listarItens(){
        System.out.println("Tipo    Titulo  Lista de autores    DataPublicação");
        for(Item item: this.itens){
            
        }
    }
    //***** Listar Itens Emprestados
    //***** Eliminar item
    //***** Alterar item
    

    //***** Inserir usuário
    //***** Listar usuários
    //***** Eliminar usuário
    //***** Alterar usuário


    //Métodos para manipular os usuários
    //***** Listar Itens Emprestados
    //***** Emprestar
}
