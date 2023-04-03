package entidades;

public class ItemEmprestado {
    //Atributos
    private Item item;
    private Usuario usuario;
    private String dataEmprestimo;

    //construtor
    public ItemEmprestado(Item item, Usuario usuario, String dataEmprestimo){
        this.item = item;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
    }

    //setters e getters
    public void setItem(Item item) {
        this.item = item;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public Item getItem() {
        return item;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }
}
