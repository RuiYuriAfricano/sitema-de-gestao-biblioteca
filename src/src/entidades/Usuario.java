package entidades;

import enums.EnumUsuario.TipoUsuario;;

public class Usuario {
    // Atributos
    private int idUsuario;
    private String nome;
    private String sobrenome;
    private TipoUsuario tipo;
    private String username;
    private String senha;

    // construtor
    public Usuario() {
        
    }
    public Usuario(String nome, String sobrenome, TipoUsuario tipo, String username, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipo = tipo;
        this.username = username;
        this.senha = senha;
    }

    // Getters e Setters
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
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
