/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import Dynamic_Queue.Dynamic_Queue;
import baralho.Carta;

/**
 *
 * @author Gabriel Gustavo
 */
public class Rodadas {

    public static void executarPrimeiraRodada(Dynamic_Queue<Jogador> jogadores,
            Dealer d) {
        executarComporatamentoInicialJogadores(jogadores, d);
        Main.saida.exibeMesaInicial(Dealer.mostrarCartaDaMesa(jogadores));
    }

    public static void executarComporatamentoInicialJogadores(
            Dynamic_Queue<Jogador> jogadores, Dealer d) {
        for (int i = 0; i < jogadores.size(); i++) {
            (jogadores.get(i)).comportamentoInicial(d);
        }
    }

    public static void exercutarNRodadas(Dealer d,
            Dynamic_Queue<Jogador> jogadores, Dynamic_Queue<Jogador> vencedores,
            Dynamic_Queue<Jogador> perdedores) {

        if (Pontuacao.existeGanhador(jogadores, d, vencedores, perdedores) == null) {

            //Mostra a segunda carta da mesa para os jogadores
            Carta c = Dealer.mostrarCartaDaMesa(jogadores);
            Main.saida.mostraSegundaCartaDaMesa(c);

            while (Pontuacao.existeGanhador(jogadores, d, vencedores, perdedores) == null && !jogadores.isEmpty()) {
                //Cada jogador da fila executa seu comportamento.
                for (int i = 0; i < jogadores.size(); i++) {
                    (jogadores.get(i)).comportamento(d);
                }
            }
        }
    }
}
