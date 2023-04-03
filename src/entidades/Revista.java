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
public class Revista extends Item {
    //Atributos
    private int numeroDeEdicoes;

    //setters e getters
    public void setNumeroDeEdicoes(int numeroDeEdicoes) {
        this.numeroDeEdicoes = numeroDeEdicoes;
    }
    public int getNumeroDeEdicoes() {
        return numeroDeEdicoes;
    }
}
