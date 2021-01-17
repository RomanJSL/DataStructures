/*
Simple demonstrative example of a dynamic array (or array list) of integers
Copyright Roman Lewandowski 2021
 */

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

public class MyArrayList {

    private int internalArray[];//this parameter will store the actual array
    private int size;//this perameter stores the amount of used space in the array (the largest used index)

    ArrayList<Integer> al = new ArrayList<>();

    public MyArrayList(){
        internalArray = new int[10];
        size = 0;
    }
    public MyArrayList(int[] list){
        internalArray = list;
        size = list.length;
    }

    public int get(int index){
        return internalArray[index];
    }

    public void set(int index, int value){
        if(index <= size) {
            internalArray[index] = value;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    private void resize(){
        /*
        check to see if more or less space is needed
         */
        if(internalArray.length < 1.5*size){
            //Array is too small, make it bigger
            int tempArray[] = new int[2*size];
            for(int i = 0; i < internalArray.length; i++){
                tempArray[i] = internalArray[i];
            }
            internalArray = tempArray;

        }else if(internalArray.length > 4*size){
            //Array is too big, make it smaller
            int tempArray[] = new int[2*size];
            for(int i = 0; i < tempArray.length; i++){
                tempArray[i] = internalArray[i];
            }
            internalArray = tempArray;
        }
    }
    public void add(int value){
        internalArray[size] = value;
        size++;
        resize();
    }
    public int remove(int index){
        int temp = internalArray[index];
        for(int i = index; i < internalArray.length-1; i++){
            internalArray[i] = internalArray[i+1];
        }
        size--;
        resize();
        return temp;
    }

    public int remove(){
        int temp = internalArray[size];
        internalArray[size] = 0;
        size--;
        resize();
        return temp;
    }
    public int size(){
        return size;
    }
    public String toString(){
        String s = "[";
        if(size<1){
            return "[]";
        }
        for(int i = 0; i < size - 1; i++){
            s += internalArray[i]+",";
        }
        s+= internalArray[size-1]+"]";
        return s;
    }


}
