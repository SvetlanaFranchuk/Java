package org.example.house;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Flat {
    private int number;
    private List<Room> rooms;
}
