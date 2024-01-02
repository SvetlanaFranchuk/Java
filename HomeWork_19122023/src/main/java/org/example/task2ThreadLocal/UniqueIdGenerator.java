package org.example.task2ThreadLocal;

public class UniqueIdGenerator {
    public static ThreadLocal<Integer> generator = ThreadLocal.withInitial(()->0);

     public static Integer generateUniqueId(){
         generator.set(generator.get() + 1);
         return generator.get();
    }


}
