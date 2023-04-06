package entidades;

import java.util.ArrayList;

import enums.EnumUsuario.TipoUsuario;;

public class Usuario {
    // Atributos
    private String nome;
    private String sobrenome;
    private TipoUsuario tipo;
    private String username;
    private String senha;
    private ArrayList<Item> itensEmprestados;

    // construtor
    public Usuario(String nome, String sobrenome, TipoUsuario tipo, String username, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipo = tipo;
        this.username = username;
        this.senha = senha;

        itensEmprestados = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.itensEmprestados.add(item);
    }

    public void addItems(ArrayList<Item> items) {
        this.itensEmprestados = items;
    }

    public ArrayList<Item> getItens() {
        return this.itensEmprestados;
    }

    // Getters e Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}
