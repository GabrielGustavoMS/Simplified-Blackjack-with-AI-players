/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author Gabriel Gustavo
 */
public class Janela {

    private JFrame frame;
    private String title;
    private int width, height;
    //Paineis de cartas:
    private JLayeredPane jCauteloso;
    private JLayeredPane jImpulsivo;
    private JLayeredPane jImprevisivel;
    private JLayeredPane jPreguiçoso;
    private JLayeredPane cartasDaMesa;

    private final int margem = 70;
    private final int larguraPainelCarta = 140;
    private final int marginTop = 350;
    //Variáveis de controle de posição vertical de cada carta.
    private int hPositionCauteloso = 30;
    private int hPositionImpulsivo = 30;
    private int hPositionImprevisilvel = 30;
    private int hPositionPreguiçoso = 30;
    //Etiqueta que recebe a carta virada para baixo.
    private JLabel carta2;
    //Etiqueta que mostra o resultado da partida.
    private JLabel resul;

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public JLayeredPane getjCauteloso() {
        return jCauteloso;
    }

    public void setjCauteloso(JLayeredPane jCauteloso) {
        this.jCauteloso = jCauteloso;
    }

    public int gethPositionCauteloso() {
        return hPositionCauteloso;
    }

    public void sethPositionCauteloso(int hPositionCauteloso) {
        this.hPositionCauteloso = hPositionCauteloso;
    }

    public JLayeredPane getjImpulsivo() {
        return jImpulsivo;
    }

    public void setjImpulsivo(JLayeredPane jImpulsivo) {
        this.jImpulsivo = jImpulsivo;
    }

    public int gethPositionImpulsivo() {
        return hPositionImpulsivo;
    }

    public void sethPositionImpulsivo(int hPositionImpulsivo) {
        this.hPositionImpulsivo = hPositionImpulsivo;
    }

    public JLayeredPane getjImprevisivel() {
        return jImprevisivel;
    }

    public void setjImprevisivel(JLayeredPane jImprevisivel) {
        this.jImprevisivel = jImprevisivel;
    }

    public int gethPositionImprevisilvel() {
        return hPositionImprevisilvel;
    }

    public void sethPositionImprevisilvel(int hPositionImprevisilvel) {
        this.hPositionImprevisilvel = hPositionImprevisilvel;
    }

    public JLayeredPane getjPreguiçoso() {
        return jPreguiçoso;
    }

    public void setjPreguiçoso(JLayeredPane jPreguiçoso) {
        this.jPreguiçoso = jPreguiçoso;
    }

    public JLayeredPane getCartasDaMesa() {
        return cartasDaMesa;
    }

    public void setCartasDaMesa(JLayeredPane cartasDaMesa) {
        this.cartasDaMesa = cartasDaMesa;
    }

    public int gethPositionPreguiçoso() {
        return hPositionPreguiçoso;
    }

    public void sethPositionPreguiçoso(int hPositionPreguiçoso) {
        this.hPositionPreguiçoso = hPositionPreguiçoso;
    }

    public JLabel getCarta2() {
        return carta2;
    }

    public void setCarta2(JLabel carta2) {
        this.carta2 = carta2;
    }

    public JLabel getResul() {
        return resul;
    }

    public void setResul(JLabel resul) {
        this.resul = resul;
    }

    public Janela(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        //Cria instâncias para paineis de cartas.
        this.jCauteloso = new JLayeredPane();
        this.jImpulsivo = new JLayeredPane();
        this.jImprevisivel = new JLayeredPane();
        this.jPreguiçoso = new JLayeredPane();
        this.cartasDaMesa = new JLayeredPane();
        createDisplay();

    }

    private void createDisplay() {
        //Cria janela com o título do construtor
        frame = new JFrame(title);
        //Configura a dimensão do frame
        frame.setSize(width, height);
        //Configura - X encerra o processo 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Não Permite que a janela seja redimendionada quando false
        frame.setResizable(false);
        //Configura a localização da janela como centro - quando null
        frame.setLocationRelativeTo(null);//?
        frame.setLayout(null);

        //Configura background
        String url = "/blackjack/cards/background.png";
        ImageIcon background = new ImageIcon(getClass().getResource(url));
        frame.setContentPane(new JLabel(background));
        background.setImage(background.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), 1));
        frame.setIconImage(background.getImage());
        //Configura icone da janela
        String urlIcone = "/blackjack/cards/icone.jpg";
        ImageIcon icone = new ImageIcon(getClass().getResource(urlIcone));
        icone.setImage(icone.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), 1));
        Image image = icone.getImage();
        frame.setIconImage(image);

        //Torna a janela visível
        //Adiciona painel para cartas da mesa.
        frame.add(cartasDaMesa);
        cartasDaMesa.setLayout(null);
        cartasDaMesa.setSize(800, 250);
        
        cartasDaMesa.setLocation(larguraPainelCarta + margem, 50);
        JLabel lbl1 = new JLabel();

        cartasDaMesa.add(lbl1);
        lbl1.setText("Cartas da Mesa:");
        lbl1.setSize(200, 30);
        lbl1.setForeground(Color.white);

        //Adiciona painel para jogador cauteso.
        frame.add(jCauteloso);
        jCauteloso.setLayout(null);
        jCauteloso.setSize(larguraPainelCarta, 1000);
        jCauteloso.setLocation(larguraPainelCarta + margem, marginTop);
        JLabel lbl = new JLabel();
        jCauteloso.add(lbl);
        lbl.setSize(200, 30);
        lbl.setLocation(0, 0);
        lbl.setText("Jogador Cauteloso: ");
        lbl.setForeground(Color.white);
        jCauteloso.moveToFront(lbl);

        //Adiciona painel para jogador Impulsivo.
        frame.add(jImpulsivo);
        jImpulsivo.setLayout(null);
        jImpulsivo.setSize(larguraPainelCarta, 1000);
        jImpulsivo.setLocation(2 * (larguraPainelCarta + margem), marginTop);
        JLabel lbl2 = new JLabel();
        jImpulsivo.add(lbl2);
        lbl2.setSize(200, 30);
        lbl2.setLocation(0, 0);
        lbl2.setText("Jogador Impulsivo: ");
        lbl2.setForeground(Color.white);
        jImpulsivo.moveToFront(lbl2);

        //Adiciona painel para jogador Imprevisível.
        frame.add(jImprevisivel);
        jImprevisivel.setLayout(null);
        jImprevisivel.setSize(larguraPainelCarta, 1000);
        jImprevisivel.setLocation(3 * (larguraPainelCarta + margem), marginTop);
        JLabel lbl3 = new JLabel();
        lbl3.setSize(200, 30);
        lbl3.setLocation(0, 0);
        lbl3.setText("Jogador Imprevisível: ");
        lbl3.setForeground(Color.white);
        jImprevisivel.add(lbl3);

        //Adiciona painel para jogador Preguiçoso.
        frame.add(jPreguiçoso);
        jPreguiçoso.setLayout(null);
        jPreguiçoso.setSize(larguraPainelCarta, 1000);
        jPreguiçoso.setLocation(4 * (larguraPainelCarta + margem), marginTop);
        JLabel lbl4 = new JLabel();
        lbl4.setSize(200, 30);
        lbl4.setLocation(0, 0);
        lbl4.setText("Jogador Preguiçoso: ");
        lbl4.setForeground(Color.white);
        jPreguiçoso.add(lbl4);
        resul = new JLabel();
        resul.setText("Resultado...");
        resul.setSize(500, 30);
        resul.setForeground(Color.decode("#D4F7EC"));
        resul.setFont(new Font("monospaced", Font.BOLD, 18));
        frame.add(resul);
        resul.setLocation(30, 30);

        frame.setVisible(true);

    }

}
