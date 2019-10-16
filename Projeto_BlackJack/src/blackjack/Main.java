/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import impressao.Exibir;

/**
 *
 * @author Gabriel Gustavo
 */
public class Main {
    //Controle de saída.
    static Exibir saida;

    public static void main(String[] args) {
        saida = new Exibir(Exibir.modosDeExibicao.JANELA);
        JogoPadrao.run();
        //Jogo1.runSimulation();
    }
}
