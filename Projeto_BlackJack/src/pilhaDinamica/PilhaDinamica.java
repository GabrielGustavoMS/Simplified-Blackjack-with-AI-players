/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilhaDinamica;

/**
 *
 * @author Gabriel Gustavo
 * @param <E>
 */
public class PilhaDinamica<E> {

    private Node topo = null;

    public PilhaDinamica() {
        this.topo = null;
    }
    //Verifica se a pilha está vazia
    public boolean isEmpty() {
        return (topo == null);
    }
    
    public Node push(Object x) {
        try {
            //Não permite novo objeto nulo
            if (x == null) {
                return null;
            }
            //Aloca memória para um novo objeto
            Node novo = new Node();
            //Atribui-se valor para o novo nó
            novo.setValue(x);
            //Config end no proximo no
            novo.setNext(topo);
            topo = novo;
            return novo;
        } catch (Exception ex) {
            return null;//Quando a memória é insuficiente
        }
    }

    public Object pop() {
        if (topo == null) {
            //Caso a pilha esteja vazia
            return null;
        }
        Object valor = topo.getValue();
        Node temp = topo;
        //Avança o topo para proximo elemento
        topo = topo.getNext();
        temp = null;
        //Retorna valor do elemento que estava no topo 
        return valor;
    }

    public Object top() {
        if (topo == null) {
            return null;
        } else {
            //Retorna valor do elemento do topo sem eliminá-lo
            return topo.getValue();
        }
    }

    public String toString() {
        //Retorna os intens guardados na pilha neste formato -> 
        //P:[ a, b, c, topo ]
        if (!isEmpty()) {
            String resp = "";
            Node aux = topo;
            while(aux!=null){
                resp = aux.getValue().toString() + resp;
                aux = aux.getNext();
            }
            return (resp)+" ";
        }else {
            return "Pilha vazia!!!";
        }
    }
    /**
     * Os métodos anteriores possuem eficiência O(1), mas toString é O(n) 
     */
 

}
