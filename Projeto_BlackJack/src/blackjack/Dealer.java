/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import Dynamic_Queue.Dynamic_Queue;
import baralho.Baralho;
import baralho.Carta;

import pilhaDinamica.PilhaDinamica;



/**
 *
 * @author Gabriel Gustavo
 */
public class Dealer {
    private PilhaDinamica  baralho;
    private static PilhaDinamica cartasDaMesa;
    public Dealer(){
        baralho = new PilhaDinamica();
        //Cria baralho
        Baralho bar = new Baralho();
        //Emabaralha cartas
        bar.embaralhar();
        //Forma pilha de cartas
        for(int i = 0;i<bar.getTamanho();i++){
            baralho.push(bar.getCarta(i));
        }
        //Coloca duas cartas sobre a mesa
        cartasDaMesa = new PilhaDinamica();
        
        cartasDaMesa.push(baralho.pop());
        
        cartasDaMesa.push(baralho.pop());
    }
    
    public Carta entregarCarta(){
        Carta c = (Carta) baralho.pop();
        return c;
    }
    public boolean baralhoVazio(){
        return baralho.isEmpty();
    }
    public static Carta mostrarCartaDaMesa(Dynamic_Queue<Jogador> jogadores){
        //Cosidera  Carta para todos em jogo
        for (int i = 0; i < jogadores.size(); i++) {
            
            ( jogadores.get(i)).verificarCarta((Carta)cartasDaMesa.top());
        }
        //Remove para q não seja considerada novamente
        return(Carta) cartasDaMesa.pop();
        
    }
}
