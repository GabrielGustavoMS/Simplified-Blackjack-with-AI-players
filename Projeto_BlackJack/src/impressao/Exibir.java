/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressao;

import Dynamic_Queue.Dynamic_Queue;
import baralho.Carta;
import blackjack.Jogador;

/**
 *
 * @author Gabriel Gustavo.
 */
public class Exibir {

    private GerenciadorDaView g;
    private GerenciadorDeSaidaTerminal t;

    public enum modosDeExibicao {
        TERMINAL, JANELA;
    }
    private modosDeExibicao saida;

    public Exibir(modosDeExibicao saida) {
        this.saida = saida;
        if (saida == modosDeExibicao.JANELA) {
            g = new GerenciadorDaView();
        } else {
            t = new GerenciadorDeSaidaTerminal();
        }
    }

    public void adicionarCarta(Carta c, String perfil) {
        if (this.saida == modosDeExibicao.JANELA) {
            g.addCartaNaView(c, perfil);
        }
    }

    public void exibeMesaInicial(Carta c) {
        if (this.saida == modosDeExibicao.JANELA) {
            g.exibeMesaInicial(c);
        }
    }

    public void mostraSegundaCartaDaMesa(Carta c) {
        if (this.saida == modosDeExibicao.JANELA) {
            g.mostraSegundaCartaDaMesa(c);
        }
    }

    public void exibeResultado(Dynamic_Queue<Jogador> vencedores, Dynamic_Queue<Jogador> perdedores) {
        if (this.saida == modosDeExibicao.JANELA) {
            g.exibeResultado(vencedores);
        } else {
            t.exibirResultado(vencedores, perdedores);
        }
    }

}
