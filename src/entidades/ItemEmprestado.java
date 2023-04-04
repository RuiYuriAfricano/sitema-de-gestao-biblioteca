package entidades;

public class ItemEmprestado {
    // Atributos
    private Item item;
    private Usuario usuario;
    private String dataEmprestimo;
    private String dataDevolucao;

    // construtor
    public ItemEmprestado(Item item, Usuario usuario, String dataEmprestimo, String dataDevolucao) {
        this.item = item;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    // setters e getters
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

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }
}
