/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import Dynamic_Queue.Dynamic_Queue;

/**
 *
 * @author Gabriel Gustavo
 */
public class Pontuacao {

    public static String exibePontuacao(Jogador j) {
        return j.toString();

    }

    public static Jogador existeGanhador(Dynamic_Queue<Jogador> jogadores,
            Dealer d, Dynamic_Queue<Jogador> vencedores,
            Dynamic_Queue<Jogador> perdedores) {

        /*Remove jogadores cujos pontos passaram de 21 e coloca na fila de 
        perdedores*/
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).getPontos() > 21) {
                perdedores.enqueue(jogadores.get(i));
                jogadores.remove(i);
            }
        }
        for (int i = 0; i < jogadores.size(); i++) {
             if (jogadores.get(i).getPontos() > 21) {
                perdedores.enqueue(jogadores.get(i));
                jogadores.remove(i);
            }
             else if ((jogadores.get(i)).getPontos() == 21) {
                //Remove os perdedores com menos de 21

                vencedores.enqueue(jogadores.get(i));
                //Garante q o vencedor não seja copiado + de uma vez
                jogadores.remove(i);
                //Copia os demais jogadores para lista de perdedores
                for (int j = 0; j < jogadores.size(); j++) {

                    //Não considera empate ****
                    perdedores.enqueue(jogadores.get(j));
                }
                jogadores.clear();
                //Retorna 1º a chegar em 21
                return vencedores.get(0);
            }
            //Se o jogador parar, remover da fila de jogadores
             else if (((jogadores.get(i)).isParou())) {
                perdedores.enqueue(jogadores.get(i));
                jogadores.remove(i);
            }
        }

        return null;
    }

    public static void pescaVencedor(Dynamic_Queue<Jogador> vencedores,
            Dynamic_Queue<Jogador> perdedores) {
        /*Caso não exita nenhum vencedor com 21 pontos, verifica e considera 
        vencedor aquele que chegou mais proximo.*/
        if (vencedores.isEmpty()) {
            //Fila temporária que recebe os jogadores que pararam.
            Dynamic_Queue<Jogador> filaTemp = new Dynamic_Queue();
            for (int i = 0; i < perdedores.size(); i++) {
                Jogador temp = perdedores.get(i);
                if (temp.getPontos() < 21) {
                    filaTemp.enqueue(temp);
                }
            }
            if (!filaTemp.isEmpty()) {
                /*Procura jogador com pontuação mais próxima de 21 dentre os que
                decidiram parar*/
                Jogador vencedor = filaTemp.get(0);
                for (int i = 1; i < filaTemp.size(); i++) {
                    /*Sinal ">" garante que apenas o 1º a ser encontrado seja o
                    vencedor */
                    if (filaTemp.get(i).getPontos() > vencedor.getPontos()) {
                        vencedor = filaTemp.get(i);
                    }
                }
                /*Retira o vencedor da fila dos perdedores e coloca na de
                vencedores*/
                vencedores.enqueue(vencedor);
                perdedores.remove(vencedor);
            }
        }
    }
}
