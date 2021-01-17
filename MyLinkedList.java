import java.util.LinkedList;

public class MyLinkedList {
    private class node{
        int value;
        node next;
        node prev;
        private node(int val, node next, node prev){
            value = val;
            this.next = next;
            this.prev = prev;
        }
        private node(){
            value = 0;
            this.next = null;
            this.prev = null;
        }
        private node getNext(){
            return next;
        }
        private node getPrev(){
            return prev;
        }
        private int getValue(){
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(node next) {
            this.next = next;
        }

        public void setPrev(node prev) {
            this.prev = prev;
        }
    }
    node head;
    node tail;
    int size;


    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int element){
        if(size == 0){
            head = new node();
            tail = head;
            head.value = element;
            size = 1;
        }else{
            tail.next = new node();
            tail.next.value = element;
            tail.next.prev = tail;
            tail = tail.next;
            size++;
        }
    }
    public void add(int index, int element){
        if(size == 0){
            node newnode = new node(element,null,null);
            head = newnode;
            tail = newnode;
            size++;
        }else if(index <= size){
            node temp;
            node newnode = new node();
            newnode.value = element;
            temp = head;
            for(int i = 0; i < index && temp.next!= null; i++){
                temp = temp.next;
            }
            newnode.next = temp;
            newnode.prev = temp.prev;
            if(newnode.next != null) {
                newnode.next.prev = newnode;
            }else{
                tail = newnode;
            }
            if(newnode.prev != null) {
                newnode.prev.next = newnode;
            }else {
                head = newnode;
            }
            size++;
        }else {
            throw new IndexOutOfBoundsException();
        }
    }
    public int get(int index){
        if(index < size && index > -1){
            node temp = head;
            for(int i =  0; i < index && temp.next!=null; i++){
                temp = temp.next;
            }
            return temp.value;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    public int pop(){
        node temp = head;
        head = head.next;
        size--;
        return temp.value;
    }
    public void push(int element){
        node newnode = new node(element,head,null);
        head = newnode;
    }
    public int remove(int index){
        node temp = head;
        for(int i = 0; i<index && temp.next!= null; i++){
            temp = temp.next;
        }
        if(temp.prev != null){
            temp.prev.next = temp.next;
        }else{
            head = temp.next;
        }
        if(temp.next != null){
            temp.next.prev = temp.prev;
        }else{
            tail = temp.prev;
        }
        size--;
        return temp.value;
    }
    public int remove(){
        return remove(0);
    }

    public String toString() {
        String s = "[";
        node temp = head;
        while(temp!=null){
            s+= temp.value;
            if(temp.next!=null){
                s+= ",";
            }
            temp = temp.next;
        }
        s+="]";
        return s;
    }



}
