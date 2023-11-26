package org.example.convertToJson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Stock {
    private Product product;
    private int count;
    private LocalDate receiptDate;
    private Boolean onlyForRetail;


    @Override
    public String toString() {
        return "Stock{" +
                "\n product=" + product +
                ",\n count=" + count +
                ",\n receiptDate=" + receiptDate +
                ",\n onlyForRetail=" + onlyForRetail +
                '}';
    }
}
