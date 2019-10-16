/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressao;

import Dynamic_Queue.Dynamic_Queue;
import blackjack.Jogador;
import blackjack.Pontuacao;

/**
 *
 * @author Gabriel Gustavo
 */
public class GerenciadorDeSaidaTerminal {

    protected String exibirResultado(Dynamic_Queue<Jogador> vencedores, Dynamic_Queue<Jogador> perdedores) {
        String resul = "";
        if (!vencedores.isEmpty()) {
            System.out.println("Ganhadores");
            resul += "Ganhadores \n:";

            for (int i = 0; i < vencedores.size(); i++) {

                System.out.println(Pontuacao.exibePontuacao((vencedores.get(i))));
                resul += Pontuacao.exibePontuacao((vencedores.get(i)));
                resul += "\n";
            }
        }

        System.out.println("");
        if (!perdedores.isEmpty()) {
            System.out.println("Perdedores");
            resul += "\n Perdedores";
            for (int i = 0; i < perdedores.size(); i++) {
                System.out.println(Pontuacao.exibePontuacao((perdedores.get(i))));
                resul += Pontuacao.exibePontuacao((perdedores.get(i)));
                resul += "\n";

            }
        }
        return resul;

    }
}
