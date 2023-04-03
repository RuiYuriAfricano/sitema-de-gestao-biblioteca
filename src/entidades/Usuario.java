package entidades;
import enums.EnumUsuario.TipoUsuario;;
public class Usuario {
    //Atributos
    private String nome;
    private String sobrenome;
    private TipoUsuario tipo;

    //construtor
    public Usuario(String nome, String sobrenome, TipoUsuario tipo){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipo = tipo;
    }

    //Getters e Setters
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
}
