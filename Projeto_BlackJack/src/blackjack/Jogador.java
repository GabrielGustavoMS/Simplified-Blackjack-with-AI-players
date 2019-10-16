/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import baralho.Carta;
import pilhaDinamica.PilhaDinamica;


/**
 *
 * @author Gabriel Gustavo
 */
public abstract class Jogador {
    private int pontos;
    private int numeroDeCartas = 0;
    private PilhaDinamica<Carta> pilhaCartasJogador;
    private String perfil;
    private boolean parou = false;

    public boolean isParou() {
        return parou;
    }

    public void setParou(boolean parou) {
        this.parou = parou;
    }

    public Jogador(String perfil) {
        this.perfil = perfil;
        this.pontos = 0;
        pilhaCartasJogador = new PilhaDinamica();
    }
    
    

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
     public int getNumeroDeCartas() {
        return numeroDeCartas;
    }

    public void setNumeroDeCartas(int numeroDeCartas) {
        this.numeroDeCartas = numeroDeCartas;
    }

    public PilhaDinamica getPilhaCartasJogador() {
        return pilhaCartasJogador;
    }

    public void addPilhaCartasJogador(Carta c) {
        this.pilhaCartasJogador.push(c);
        ++numeroDeCartas;
        Main.saida.adicionarCarta(c, this.perfil);      
        
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void pedirCartas(Dealer d) {
        Carta c = d.entregarCarta();
        this.pontos = pontos + (c.getValor());
        this.addPilhaCartasJogador(c);

    }
     public void verificarCarta(Carta c){
        this.pontos = pontos + (c.getValor());
        /*this.addPilhaCartasJogador(c);*/
         this.pilhaCartasJogador.push(c);
        ++numeroDeCartas;
    }
     
      public void comportamentoInicial(Dealer d) {
        this.pedirCartas(d);
        this.pedirCartas(d);

    }
     public void comportamento(Dealer d) {
        if (querCarta(d)&&!parou) {
            this.pedirCartas(d);
        }

    }
    public abstract boolean querCarta(Dealer d);

    @Override
    public String toString() {
        return "Quantidade de Carta: [" + this.getNumeroDeCartas() + "]"+"\n"+
                "Soma das cartas: [" + this.getPontos() + "]"+"\n"+
                "Cartas: "+"\n"+
                this.getPilhaCartasJogador().toString()+"\n"+
                "Perfil: "+this.perfil+
                "\n \n";
    }
    
    
}
