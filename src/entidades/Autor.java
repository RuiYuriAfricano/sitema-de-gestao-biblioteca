package entidades;

public class Autor {
    //Atributos
    private String nome;
    private String sobrenome;

    //Construtor
    public Autor(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
