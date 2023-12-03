package org.example.house;

import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Room {
    private TypeRoom type;
    private double square;
}
