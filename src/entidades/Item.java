package entidades;

import java.util.ArrayList;

public abstract class Item {
    //Atributos
    protected int idItem;
    protected String titulo;
    protected String data;

    //Construtor
    public Item(String titulo, String data){
        this.titulo = titulo;
        this.data = data;
    }
    public Item(){}
    
    
    // Getters e Setters

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    
}
