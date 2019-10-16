/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dynamic_Queue;

/**
 *
 * @author Gabriel Gustavo
 */
public class Node <T>{
    //Valor do nodo
    private Object value;
    //Endereço para o próximo item
    private Node next;
    //Retorna valor do nodo
    public Object getValue() {
        return value;
    }
    //Altera valor do nodo
    public void setValue(T value) {
        this.value = value;
    }
    //Retorna endereço do próximo nodo
    public Node getNext() {
        return next;
    }
    //Altera endereço do proximo nodo
    public void setNext(Node next) {
        this.next = next;
    }
    
   
}
