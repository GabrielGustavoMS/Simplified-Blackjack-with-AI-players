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
public class JogadorPreguiçoso extends Jogador{

    public JogadorPreguiçoso() {
        super("Jogador Preguiçoso");
    }

    @Override
    public boolean querCarta(Dealer d) {
      if(this.getNumeroDeCartas()<3){
          return true;
      }else{
        this.setParou(true);
        return false;   
      }
       
       
       
       
    }
    
}
