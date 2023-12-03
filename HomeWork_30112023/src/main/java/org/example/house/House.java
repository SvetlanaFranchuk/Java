package org.example.house;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class House {

  private List<Flat> flatNumber;

}
//Создайте класс Дом, содержащий список Квартир.
// Каждая квартира содержит список комнат. Каждая комната содержит площадь