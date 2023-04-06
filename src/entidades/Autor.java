package entidades;

public class Autor {
    /**/Atributos
    private int idAutor;
    private String nome;
    private String sobrenome;

    //Construtor
    public Autor(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    public Autor(){
    }
    
    public int getIdAutor() {
        return idAutor;
    }

    //Getters e Setters
    public void setIdAutor(int idAutor) {    
        this.idAutor = idAutor;
    }

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
