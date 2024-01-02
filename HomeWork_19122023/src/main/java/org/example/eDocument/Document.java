package org.example.eDocument;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Document {
    private ReentrantReadWriteLock rwLock;
    private List<String> list;

    public Document() {
        this.rwLock = new ReentrantReadWriteLock();
        this.list = new ArrayList<>();
    }

    public void writeToList(String str){
        Lock writeLock = rwLock.writeLock();
        writeLock.lock();
        try {
            list.add(str);
        }finally {
            writeLock.unlock();
        }
    }

    public String readFromList (int index){
        Lock readLock = rwLock.readLock();
        readLock.lock();
        try{
            return list.get(index);
        }finally {
            readLock.unlock();
        }
    }

    public int size(){
        Lock readLock = rwLock.readLock();
        readLock.lock();
        try{
            return list.size();
        }finally {
            readLock.unlock();
        }
    }

}
