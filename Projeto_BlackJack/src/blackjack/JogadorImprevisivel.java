/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;

/**
 *
 * @author Gabriel Gustavo
 */
public class JogadorImprevisivel extends Jogador{

    public JogadorImprevisivel() {
        super("Jogador Imprevisível");
    }

    @Override
    public boolean querCarta(Dealer d) {
        Random rnd = new Random();
        int num = rnd.nextInt(1);
        
        if(num==1 && this.getPontos()<17){
            return true;
        }else{
            this.setParou(true);
            return false;
        }
        
    }
    
}
