/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Total Energies
 */
public class Livro extends Item {
    //Atributos
    private int numeroDePaginas;

    //Construtor
    public Livro(String titulo, String data, int numeroDePaginas){
        super(titulo, data);
        this.numeroDePaginas = numeroDePaginas;
    }
    public Livro(){
    }

    //getters e setters
    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }
    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }
}
