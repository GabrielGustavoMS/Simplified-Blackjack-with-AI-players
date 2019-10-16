/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baralho;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Gabriel Gustavo
 */
public class Baralho {

    /**
     * @param args the command line arguments
     */
    ArrayList<Carta> baralho1;
    private int tamanho;
    
    public Carta getCarta(int i){
        return(Carta) baralho1.get(i);
    }

    public int getTamanho() {
        tamanho = baralho1.size();
        return tamanho;
    }

   

    public Baralho() {
        baralho1= new ArrayList();
        String naipes[] = {"Paus", "Copas", "Espadas", "Ouros"};
        String nomes[] = {"Ás", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Dama", "Valete", "Rei"};
        int valores[] = {1,2,3,4,5,6,7,8,9,10,10,10,10};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Carta novaCarta = new Carta();
                novaCarta.setNaipe(naipes[i]);
                novaCarta.setNome(nomes[j]);
                novaCarta.setValor(valores[j]);
                //String carta = novaCarta.getNome() + " " + novaCarta.getNaipe();
                baralho1.add(novaCarta);

            }
        }
        


    }

    public void imprimirBaralho() {
        int j = 13;
        int g = 26;
        int k = 39;
        
        //for (int i = 0; i < baralho1.size(); i++) {
        for (int i = 0; i <13; i++) {
            //System.out.println(baralho1.get(i));
            //Saída formatada - %s - signifca que o parâmetro é uma String e %50 a distância que uma ficara da outra
            System.out.printf("%s%50s%50s%50s\n", baralho1.get(i),baralho1.get(j),baralho1.get(g),baralho1.get(k));
           
            j++;
            g++;
            k++;
            
        }
    }

    public void embaralhar() {
        ArrayList  <Carta> listaTemp = new ArrayList();//Inicia uma lista temporária
        Random rnd = new Random();//Inicia um objeto da classe Random

        while (baralho1.size() > 1) {
            //Recebe uma posição aleatória no intervalo do tamanho do Array
            int posicaoRnd = rnd.nextInt(baralho1.size());
            //A posição aletória é copiada para a lista temporária 
            listaTemp.add(baralho1.get(posicaoRnd));
            /*  
            *Note que para adicionar usamos o método add(objeto a ser adicionado) 
            *o "valor" do objeto é lido por meio do método get(posiçãoArray) 
            *
            * 
             */
            baralho1.remove(posicaoRnd);
            /*    A posição da lista é "excluída" - Na verdade o que ocorre é que 
            *o valor ou objeto da posição escolhida é excluído enquanto os 
            *valores à direita são movidos uma casa para esquerda e por fim, 
            *a última posição que está vazia é exluída e em consequência disso
            *o tamanho da lista é reduzido em 1, cada vez que o loop roda. 
            *        
            *   Com isso, a última posição restante será a 1ª posição, ou seja,
            *a posição de índice 0. Por isso que o loop vai até 1 - pois quando
            *a lista tiver apenas uma posição, não faz sentido gerar um número 
            *aleatório para capturá-la
             */

        }
        listaTemp.add(baralho1.get(0));
        baralho1.clear();//No fim, a lista original é limpa pelo método clear()

        /*Logo após, a estrutura de repetição copia os elementos para a lista 
        original*/
        for (int i = 0; i < listaTemp.size(); i++) {
            baralho1.add(listaTemp.get(i));
        }
        /*   Note!!! Perceba que não existe retorno da lista embaralhada
        *   
        *   Isso ocorre porque os vetores e listas são passados por referência   
        *por uma questão de desempenho, uma vez que esses podem ter muitas 
        *posições, o que demandaria muito tempo para serem copiadas.
        *
        *
        *
         */

    }
    public String retiraCartaAleatoria(){
        Random rnd = new Random();
        int num = rnd.nextInt(52);
        String carta =""+ baralho1.get(num);
        return carta;        
    }

    

}
