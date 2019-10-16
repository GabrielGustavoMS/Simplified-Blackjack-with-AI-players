/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressao;

import Dynamic_Queue.Dynamic_Queue;
import baralho.Carta;
import blackjack.Jogador;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import view.Janela;

/**
 *
 * @author Gabriel Gustavo.
 */
public class GerenciadorDaView {

    private Janela j;

    public GerenciadorDaView() {
        j = new Janela("Black Jack", 1210, 1000);
    }

    public void addCartaNaView(Carta c, String perfil) {
        JLabel lbl = new JLabel();
        

        int lblheight = 211;
        int lblwidth = 138;
        int cardMarginTop = 50;
        //Armazena url da imagem da carta.
        String url = "/blackjack/cards/" + c.getNaipe() + c.getNome() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        if (icon == null) {
            System.out.println("Erro");
        }

        try {
            dormir(3);
        } catch (InterruptedException ex) {
            System.out.println("Erro");
        }
        //Avalia em qual painel a carta deve ser adicionada.
        switch (perfil) {
            case "Jogador Cauteloso":
                j.getjCauteloso().add(lbl);
                lbl.setLayout(null);
                lbl.setSize(lblwidth, lblheight);
                lbl.setLocation(0, j.gethPositionCauteloso());

                j.getjCauteloso().moveToFront(lbl);
                //Redimensiona imagem para tamanho da label 
                icon.setImage(icon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), 1));
                lbl.setIcon(icon);
                //Incrementa variável de localização vertical.
                j.sethPositionCauteloso(j.gethPositionCauteloso() + cardMarginTop);

                break;
            case "Jogador Imprevisível":
                j.getjImprevisivel().add(lbl);
                lbl.setLayout(null);
                lbl.setSize(lblwidth, lblheight);
                lbl.setLocation(0, j.gethPositionImprevisilvel());

                j.getjImprevisivel().moveToFront(lbl);
                //Redimensiona imagem para tamanho da label 
                icon.setImage(icon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), 1));
                lbl.setIcon(icon);
                //Incrementa variável de localização vertical.
                j.sethPositionImprevisilvel(j.gethPositionImprevisilvel() + cardMarginTop);

                break;
            case "Jogador Impulsivo":
                j.getjImpulsivo().add(lbl);
                lbl.setLayout(null);
                lbl.setSize(lblwidth, lblheight);
                lbl.setLocation(0, j.gethPositionImpulsivo());

                j.getjImpulsivo().moveToFront(lbl);
                //Redimensiona imagem para tamanho da label 
                icon.setImage(icon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), 1));
                lbl.setIcon(icon);
                //Incrementa variável de localização vertical.
                j.sethPositionImpulsivo(j.gethPositionImpulsivo() + cardMarginTop);

                break;
            case "Jogador Preguiçoso":
                j.getjPreguiçoso().add(lbl);
                lbl.setLayout(null);
                lbl.setSize(lblwidth, lblheight);
                lbl.setLocation(0, j.gethPositionPreguiçoso());

                j.getjPreguiçoso().moveToFront(lbl);
                //Redimensiona imagem para tamanho da label 
                icon.setImage(icon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), 1));
                lbl.setIcon(icon);
                //Incrementa variável de localização vertical.
                j.sethPositionPreguiçoso(j.gethPositionPreguiçoso() + cardMarginTop);

                break;

        }

        atualizaJanela();
    }

    public void exibeMesaInicial(Carta c) {
        JLabel cartaDeFaceParaCima = new JLabel();
        JLabel cartaNoTopoDoBaralho = new JLabel();
        j.setCarta2(new JLabel());
        ImageIcon iconeCartaTopo = new ImageIcon(getClass().getResource("/blackjack/cards/green_back.png"));
        ImageIcon iconeCartaDeFaceParaCima = new ImageIcon(getClass().getResource("/blackjack/cards/" + c.getNaipe() + c.getNome() + ".png"));
        //Configura a carta que representará o baralho.
        j.getCartasDaMesa().add(cartaNoTopoDoBaralho);
        cartaNoTopoDoBaralho.setLayout(null);
        cartaNoTopoDoBaralho.setSize(140, 213);
        cartaNoTopoDoBaralho.setLocation(0, 40);
        j.getCartasDaMesa().moveToFront(cartaNoTopoDoBaralho);
        iconeCartaTopo.setImage(iconeCartaTopo.getImage()
                .getScaledInstance(cartaNoTopoDoBaralho.getWidth(),
                        cartaNoTopoDoBaralho.getHeight(), 1));
        cartaNoTopoDoBaralho.setIcon(iconeCartaTopo);

        try {
            dormir(2);
        } catch (InterruptedException ex) {
            System.out.println("Erro");
        }
        //Configura a 1ª carta de face para cima e adiciona na janela.
        j.getCartasDaMesa().add(cartaDeFaceParaCima);
        cartaDeFaceParaCima.setLayout(null);
        cartaDeFaceParaCima.setSize(140, 213);
        cartaDeFaceParaCima.setLocation(250, 40);
        j.getCartasDaMesa().moveToFront(cartaDeFaceParaCima);
        iconeCartaDeFaceParaCima.setImage(iconeCartaDeFaceParaCima.getImage()
                .getScaledInstance(cartaDeFaceParaCima.getWidth(),
                        cartaDeFaceParaCima.getHeight(), 1));
        cartaDeFaceParaCima.setIcon(iconeCartaDeFaceParaCima);

        try {
            dormir(2);
        } catch (InterruptedException ex) {
            System.out.println("Erro");
        }
        //Configura a 2ª carta de face para baixo.
        j.getCartasDaMesa().add(j.getCarta2());
        j.getCarta2().setLayout(null);
        j.getCarta2().setSize(140, 213);
        j.getCarta2().setLocation(400, 40);
        j.getCartasDaMesa().moveToFront(j.getCarta2());
        j.getCarta2().setIcon(iconeCartaTopo);

        atualizaJanela();

    }

    public void mostraSegundaCartaDaMesa(Carta c) {
        //Vira para cima a segunda carta que está de face para baixo.
        try {
            dormir(3);
        } catch (InterruptedException ex) {
            System.out.println("Erro");
        }
        j.getCartasDaMesa().remove(j.getCarta2());
        j.getCartasDaMesa().repaint();
        j.setCarta2(null);
        j.setCarta2(new JLabel());
        j.getCartasDaMesa().add(j.getCarta2());
        //Configura qual imagem será utilizada com ícone.
        ImageIcon icon = new ImageIcon(getClass().getResource("/blackjack/cards/" + c.getNaipe() + c.getNome() + ".png"));
        j.getCarta2().setLayout(null);
        j.getCarta2().setSize(140, 213);
        j.getCarta2().setLocation(400, 40);
        j.getCartasDaMesa().moveToFront(j.getCarta2());
        //Redimensiona imagem do ícone.
        icon.setImage(icon.getImage().getScaledInstance(j.getCarta2().getWidth(), j.getCarta2().getHeight(), 1));
        j.getCarta2().setIcon(icon);

        atualizaJanela();
    }

    private void atualizaJanela() {
        j.getFrame().repaint();
        j.getFrame().setVisible(true);
    }

    public void exibeResultado(Dynamic_Queue<Jogador> vencedores) {
        if (vencedores.isEmpty()) {
            j.getResul().setText("Todos perderam !!!");
        } else {
            j.getResul().setText(vencedores.get(0).getPerfil() + "\n venceu !!!");
        }
    }

    private static void dormir(int tempoMaximoDeEspera) throws InterruptedException {
        Random rnd = new Random();
        int num = 1000 * rnd.nextInt(tempoMaximoDeEspera);
        Thread.currentThread().sleep(num);
    }

}
