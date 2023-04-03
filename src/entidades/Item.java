package entidades;

import java.util.ArrayList;

public abstract class Item {
    //Atributos
    protected String titulo;
    protected ArrayList<Autor> autores;
    protected String data;

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }
    public ArrayList<Autor> getAutores() {
        return autores;
    }
    public String getData() {
        return data;
    }
    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
