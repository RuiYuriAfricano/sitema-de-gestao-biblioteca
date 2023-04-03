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
public class Cd extends Item{
    //Atributos
    private int tempoDeReproducao;

    //Getters Setters
    public void setTempoDeReproducao(int tempoDeReproducao) {
        this.tempoDeReproducao = tempoDeReproducao;
    }
    public int getTempoDeReproducao() {
        return tempoDeReproducao;
    }
}
