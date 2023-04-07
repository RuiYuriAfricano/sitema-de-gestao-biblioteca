package entidades;

import dados.UsuarioDAO;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Item> itens;
    private ArrayList<Usuario> usuarios;
    private ArrayList<ItemEmprestado> itensEmprestados;

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public ArrayList<ItemEmprestado> getItensEmprestados() {
        return itensEmprestados;
    }

    public void setItensEmprestados(ArrayList<ItemEmprestado> itensEmprestados) {
        this.itensEmprestados = itensEmprestados;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
    
    public Biblioteca() {
        itens = new ArrayList<>();
        usuarios = new ArrayList<>();
        itensEmprestados = new ArrayList<>();
    }

    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    // Métodos para o bibliotecário manipular
    // ***** Inserir item
    public void inserirItem(Item item) {
        itens.add(item);
    }

    // ***** Listar item
    public void listarItens() {
       
    }

    // ***** Inserir usuário
    public void inserirUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    // ***** Listar usuários
    public void listarUsuario() {
        
    }

    // ***** Eliminar usuário
    public void eliminarUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    // ***** Alterar usuário
    public void alterarUsuario(Usuario usuario) {
      
    }

    // Métodos para o usuario manipular
    // ***** Listar Itens Emprestados
    public void visualizarItensEmprestado(Usuario user) {

        
    }

}
