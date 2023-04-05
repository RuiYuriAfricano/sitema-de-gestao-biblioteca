package entidades;


public class ItemAutor {
    // Atributos
    private Item item;
    private Autor autor;
    
    //Construtor

    public ItemAutor(Item item, Autor autor) {
        this.item = item;
        this.autor = autor;
    }
    public ItemAutor() {
    }
    
    //Getters e setters
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    
}
