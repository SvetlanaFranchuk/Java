package TaskAuto;
//Создайте Package (щелчок правой кнопкой мыши на папке src -> New -> Package).
//1 В созданном пакете создайте класс Автомобиль. Создайте поля для типа автомобиля – грузовик, спорткар, легковой
// (можно сделать перечисление), мощность двигателя (сколько лошадиных сил),
// поля для марки и модели автомобиля. Одно из полей сделайте публичным, второе – без модификатора доступа,
// остальные – приватными.
//Для приватных полей напишите геттеры и сеттеры.
public class Auto {
    private TypeAuto typeAuto;
    int power;
    public String brand;
    private String model;

    public TypeAuto getTypeAuto() {
        return typeAuto;
    }

    public void setTypeAuto(TypeAuto typeAuto) {
        this.typeAuto = typeAuto;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
