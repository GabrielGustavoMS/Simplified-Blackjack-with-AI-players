/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Gabriel Gustavo
 */
public class JogadorCauteloso extends Jogador {

    public JogadorCauteloso() {
        super("Jogador Cauteloso");
    }

    @Override
    public boolean querCarta(Dealer d) {

        int pontos = this.getPontos();
        if(pontos>16){
            this.setParou(true);
            return false;
        }
        return true;
    }

}
