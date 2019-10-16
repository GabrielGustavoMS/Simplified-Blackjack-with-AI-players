/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dynamic_Queue;

import java.util.Iterator;

/**
 *
 * @author Gabriel Gustavo
 * @param <T>
 */
public class Dynamic_Queue <T>   implements TAD_Queue{

    private Node head;
    private Node tail;
    private int size;
    
     private Iterator iter;
    private Node nodeIter;
    
   

    public<T> Dynamic_Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object enqueue(Object x) {
        if (x == null) {
            //Não permitimos inserir um objeto nulo
            return null;
        }
        try {//Para casos de memória insuficiente
            Node novo = new Node();//Aloca memória para o novo nó
            novo.setValue(x);//Atribuir o valor para o nó
            novo.setNext(null);//Colocar enlace nulo
            if (tail == null) {
                //Caso a fila estiver vazia,head e tail apontarão para novo nó
                head = novo;
                tail = novo;

            } else {
                //caso geral
                tail.setNext(novo);//Antiga carta apontará para o novo nó 
                tail = novo;//a nova cauda é o novo nó
            }
            size++;
            return x;
        } catch (Exception ex) {
            //Memória insuficiente
            return null;
        }
    }

    @Override
    public Object dequeue() {
        //Retira o elemento que está na cabeça da fila dinâmica
        if (head == null) {
            return null;//Impossível retirar de uma fila vazia.
        }
        Object value = head.getValue(); //Pegamos o objeto na cabeça.
        //Node temp = head;//opcional
        head = head.getNext();//Avança a cabeça da fila
        if (head == null) {
            tail = null;//Se ficou vazia
        }
        //temp = null opcional
        size--;
        return value;//Retorna o valor do objeto que estava na cabeça.

    }

    @Override
    public Object peek() {
        if (head == null) {
            return null;
        } else {
            return head.getValue();

        }
    }

    @Override
    public String toString() {
        //Retorna conteúdo da fila dinâmica
        if (!isEmpty()) {
            String saida = "";
            Node aux = head;
            while (aux != null) {
                //O ponteiro aux percorre a lista
                saida += aux.getValue().toString();
                aux = aux.getNext();
                //Para separar objetos simples usamos, ou separar com \n
                if (aux != null) {
                    saida += " ,";
                }
            }
            return ("f:[" + saida + " ]");
        } else {
            return ("f: []");//Fila vazia
        }
    }

    
    public T remove(int idx) {
        if(isEmpty() || idx <0 || idx>=size){//pré condições
            return null;
        }
        int pos = 0;
        Node next = head;
        Node prev = null;
        //Avançar simultamente os ponteiro prev e next até encontrar a
        //posição desejada pos == idx
        while(pos != idx){
            prev = next;
            next = next.getNext();
            pos++;
        }
        T value = (T) next.getValue();///Guardamos o valor a ser retornado
        if(prev != null){
            prev.setNext(next.getNext());//Elimina a ligação do nó eliminado
        }
        if(idx == 0 ){
            head = head.getNext();
        //Caso especial: eliminado o item na cauda -> avançar head
        }
        if(idx == size-1){
            tail = prev;
        //Caso especial: foi eliminado o item na cauda -> modificar tail
        }
        if(head == null){//Para manter os 2 ponteiros com valores nulos
            tail = null;
        }
        next.setNext(null);
        next = null;//Para liberar espaço - do nó eliminado - na memória 
        size--;//ou também: size = size = size = -1
        return value;
    }
    public boolean remove(Object x) {
        if(isEmpty()){
            return false;
        }
        Node next = head, prev = null;
        boolean achou = false;
        //Ciclo para avançar simultaneamente os ponteiro 
        //prev e next até encontrar o item x
        while (next !=null && !achou) {            
            if(x.toString().equalsIgnoreCase(next.getValue().toString())){
                achou = true;
                break;
            }
            prev = next;
            next = next.getNext();
        }
        if(!achou){
            return false;
        }
        ///Caso geral: o nó eliminado não ficará ligado na lista
        if(prev != null){
            prev.setNext(next.getNext());
        }
        //Caso especial: eliminado o item na cabeça -> avançar head
        if(prev == null){
            head = head.getNext();
        }
        //Caso especial: foi eliminado o item na cauda -> modificar tail
        if(next.getNext() == null){
            tail = prev;
        }
        //Para manter os ponteiros com valores nulos
        if(head == null){
            tail = null;
        }
        
        next.setNext(null);
        next = null;
        //Para liberar a memória do nó eliminado
        size--;
        //Ou também: size = zise-1;
        return true;
    }
    public int size() {//Retorna a quantidade de itens na lista
        return size;
    }
    public  T get(int idx) {
         if(isEmpty() || idx <0 || idx>=size){//pré condições
            //return null;
        }
         
         int pos = 0;
         Node next = head;
         Node prev = null;
         //Avançar simultaneamente os ponteiro prev e next
         //até encontrar a posição desejada pos = idx
         while(pos != idx){
             prev = next;
             next = next.getNext();//Valor a ser retornado
             pos++;             
         }
         T value = (T)next.getValue();
         return value;
    }
    public void clear() {
        Node aux = head;
        while (aux != null){
            Node tmp = aux;
            aux = aux.getNext();
            //Liberar memória:
            tmp.setNext(null);
            tmp = null;
        }
        head = null;
        tail=null;
        size = 0;
    }
    
}
