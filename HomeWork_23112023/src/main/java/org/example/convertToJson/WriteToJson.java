package org.example.convertToJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.time.LocalDate;

public class WriteToJson {
    public static void main(String[] args) {
       Product product1 = new Product(ProductsType.LAPTOPS, "D-15", "Dell XPS 15");
       Stock stock = new Stock (product1, 100, LocalDate.of(2023,11,25), true);

       System.out.println(stock);
       try {
            File file = new File("Stock.json");
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.writeValue(file, stock);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
