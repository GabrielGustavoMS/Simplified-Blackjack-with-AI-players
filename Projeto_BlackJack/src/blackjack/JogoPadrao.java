/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import Dynamic_Queue.Dynamic_Queue;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Gabriel Gustavo
 */
public class JogoPadrao {

    public static void run() {

        // Cria lista de jogadores, vencedore e perdedores.
        Dynamic_Queue<Jogador> jogadores = new Dynamic_Queue();
        Dynamic_Queue<Jogador> perdedores = new Dynamic_Queue();
        Dynamic_Queue<Jogador> vencedores = new Dynamic_Queue();

        //Cria Dealer com baralho e coloca 2 cartas sobre a mesa
        Dealer d = new Dealer();
        //Cria e adiciona os jogadores na lista de jogadores
        ArrayList<Integer> vetNum = new ArrayList();
        vetNum.add(1);
        vetNum.add(2);
        vetNum.add(3);
        vetNum.add(4);
        Collections.shuffle(vetNum);
        for (int x : vetNum) {
            switch (x) {
                case 1:
                    jogadores.enqueue(new JogadorImpulsivo());
                    break;
                case 2:
                    jogadores.enqueue(new JogadorImprevisivel());
                    break;
                case 3:
                    jogadores.enqueue(new JogadorCauteloso());
                    break;
                case 4:
                    jogadores.enqueue(new JogadorPreguiçoso());
                    break;
            }
        }
        //Executa a 1ª rodada.
        Rodadas.executarPrimeiraRodada(jogadores, d);
        //Executa as demais rodadas se não existir um vencedor na 1ª
        Rodadas.exercutarNRodadas(d, jogadores, vencedores, perdedores);
        /*Caso não exista um jogador que tenha completa 21, 
        procura o mais próximo*/
        Pontuacao.pescaVencedor(vencedores, perdedores);
        //Impressão

        Main.saida.exibeResultado(vencedores, perdedores);
    }
}
