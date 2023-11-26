package org.example.convertFromJson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class SupportInformation {
    private String serviceName;
    private int code;
    private String userMessage;
    private Boolean isError;
    List<SupportInfo> supportContacts = new ArrayList<>();

    @Override
    public String toString() {
        return "SupportInformation{" +
                "\n serviceName=" + serviceName + ",\n" +
                " code=" + code + ",\n" +
                " userMessage=" + userMessage + ",\n" +
                " isError=" + isError + ",\n" +
                " supportContacts=" + supportContacts;
    }
}
