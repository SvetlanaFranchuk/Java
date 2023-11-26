package org.example.convertFromJson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("Example2.json");
            ObjectMapper mapper = new ObjectMapper();
            SupportInformation supportInformation = mapper.readValue(file, SupportInformation.class);
            System.out.println(supportInformation);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}