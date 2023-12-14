package org.example.manufacture;

import org.example.inventoryControl.Product;
import org.example.inventoryControl.Stock;
import org.example.readProperties.Utils;

import java.time.LocalTime;

public class Producer extends Thread {
    private Stock stock;

    public Producer(int id, Stock stock) {
        super("Producer " + id);
        this.stock = stock;
    }

    @Override
    public void run() {
        int producerCount = Utils.getProperties("producerCount");
        while (true) {
            for (int i = 0; i < producerCount; i++) {
                try {
                    Product product = new Product();
                    stock.putProduct(product);
                    System.out.printf(LocalTime.now() + "; № потока %d; тип потока %s; %s произвел продукт №%d %n",
                            Thread.currentThread().getId(), Thread.currentThread().getName(), getName(), product.getId());
                    Thread.sleep(Utils.getProperties("producerTime"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
//Есть producerCount потоков, производящих ресурс. Каждый производитель производит 1 единицу ресурса
// в producerTime времени.
//
//Производители помещают ресурсы на склад, размера storageSize. Больше, чем storageSize ресурсов,
// на складе хранить нельзя.
//
//Производители и потребители так же имеют идентификаторы (порядковые номера)

//Писать в лог (консоль) сообщение: время, номер и тип потока, id-ресурса, событие (произведен или потреблен).
//
//10) Писать в лог сообщение: количество ресурсов на складе при доставке/потреблении на склад.
//
//11) Писать в лог сообщение: время, номер и тип потока, событие (когда потоки переходят в режим ожидания или возобновляют работу).