package org.example;

import java.util.Arrays;
import java.util.Iterator;

public class CustomDynamicArray implements Iterable<Integer> {
    private int[] data;
    private int count;
    private int size;

    public CustomDynamicArray(int size) {
        this.count = 0;
        this.data = new int[size];
        this.size = size;
    }

    public CustomDynamicArray() {
        this.data = new int[1];
        this.count = 0;
        this.size = 1;
    }

    public void add(int element){
        if (count == size) growSize();
        data[count++]  = element;
    }

    public void growSize() {
        int[] newArray = new int[size*2];
        for (int i = 0; i < data.length; i++) {
           newArray[i]=data[i];
        }
        data = newArray;
        size *=2;
    }

    public void addAt(int index, int element){
        if (index >= count) throw new RuntimeException("Index is out of bounds");
        if (count == size){
            growSize();
        }
        for (int i = count - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        count++;
    }

    public void shrinkSize(){
        if (count < size){
            int[] newArray = new int[count];
            for (int i = 0; i < count; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
            size = count;
        }
    }

    public void remove(){
        data[--count] = 0; // make link to objects null for GC
    }

    public void removeAt(int index){
        if (index < 0 || index >= count) throw new RuntimeException("Index is out of bounds");
        for (int i = index; i < count; i++) {
            data[i] = data[i+1];
        }
        data[--count] = 0;
    }

    public void set(int index, int element){
        if (index < 0 || index >= count) throw new RuntimeException("Index is out of bounds");
        data[index] = element;
    }

    public int get(int index){
        if (index < 0 || index >= count) throw new RuntimeException("Index is out of bounds");
        return data[index];
    }

    public void clear(){
        data = new int[0];
        size = 1;
        count = 0;
    }

    public int contains(int element){
        for (int i = 0; i < count; i++) {
            if(data[i]==element) return i;
        }
        return -1;
    }

    public boolean isEmpty(){
        return count == 0;
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append("CustomDynamicArray[");
        for (int i = 0; i < count; i++) {
            stringBuilder.append(data[i] + (i < count-1 ? ",":""));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void InnerStructure(){
        System.out.println("Inner Structure: " + Arrays.toString(data));
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() {
               return (i < count);
            }

            @Override
            public Integer next() {
                if (i < count) return data[i++];
                return null;
            }
        };
    }
}
