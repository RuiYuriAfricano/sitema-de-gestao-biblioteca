package entidades;
import enums.EnumUsuario.TipoUsuario;;
public class Usuario {
    //Atributos
    private String nome;
    private String sobrenome;
    private TipoUsuario tipo;

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
