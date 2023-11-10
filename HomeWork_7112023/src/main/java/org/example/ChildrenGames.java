package org.example;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames=true)
@EqualsAndHashCode
public class ChildrenGames {
    String name;
    int startAge;
    double price;
}
