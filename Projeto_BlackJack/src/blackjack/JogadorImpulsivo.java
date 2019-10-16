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
public class JogadorImpulsivo extends Jogador {    

    public JogadorImpulsivo() {
       super("Jogador Impulsivo");
    }
   
    @Override
    public boolean querCarta(Dealer d) {
        if (this.getPontos() < 21) {
            return true;
        } else {
            this.setParou(true);
            return false;
        }
    } 
}
