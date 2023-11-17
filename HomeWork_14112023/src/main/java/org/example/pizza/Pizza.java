package org.example.pizza;

import lombok.ToString;

@ToString
public class Pizza {
    private DiametersPizza diameter;
    private TypePizza type;
    private String name;
    private TypeSouse typeSouse;
    private TypeCheese typeCheese;
    private int countSlicesHam;
    private int countSlicesTomato;
    private int countMushrooms;
    private int countBlackOlives;
    private int gramRedOnion;
    private int countGramChicken;
    private int countSlicesPeperoni;

    private Pizza(DiametersPizza diameter, TypePizza type, String name, TypeSouse typeSouse, TypeCheese typeCheese,
                  int countSlicesHam, int countSlicesTomato, int countMushrooms, int countBlackOlives, int gramRedOnion,
                  int countGramChicken, int countSlicesPeperoni) {
        this.diameter = diameter;
        this.type = type;
        this.name = name;
        this.typeSouse = typeSouse;
        this.typeCheese = typeCheese;
        this.countSlicesHam = countSlicesHam;
        this.countSlicesTomato = countSlicesTomato;
        this.countMushrooms = countMushrooms;
        this.countBlackOlives = countBlackOlives;
        this.gramRedOnion = gramRedOnion;
        this.countGramChicken = countGramChicken;
        this.countSlicesPeperoni = countSlicesPeperoni;
    }

    public static MakerPizza makerPizza (){
        return  new MakerPizza();
    }

    @ToString
    public static class MakerPizza{
        private DiametersPizza diameter = DiametersPizza.D35;
        private TypePizza type = TypePizza.NAPOLETANA;
        private String name;
        private TypeSouse typeSouse = TypeSouse.TOMATO;
        private TypeCheese typeCheese = TypeCheese.MOZZARELLA;
        private int countSlicesHam;
        private int countSlicesTomato;
        private int countMushrooms;
        private int countBlackOlives;
        private int gramRedOnion;
        private int countGramChicken;
        private int countSlicesPeperoni;

        public MakerPizza diameter (DiametersPizza diameter){
            this.diameter=diameter==null ? DiametersPizza.D35: diameter;
            return this;
        }

        public MakerPizza type (TypePizza type){
            this.type= type == null ? TypePizza.NAPOLETANA:type;
            return this;
        }

        public MakerPizza name (String name){
            this.name=name;
            return this;
        }
        public MakerPizza typeSouse (TypeSouse typeSouse){
            this.typeSouse=typeSouse==null ? TypeSouse.TOMATO: typeSouse;
            return this;
        }

        public MakerPizza typeCheese (TypeCheese typeCheese){
            this.typeCheese=typeCheese==null ? TypeCheese.MOZZARELLA: typeCheese;
            return this;
        }

        public MakerPizza countSlicesHam (int countSlicesHam){
            this.countSlicesHam=countSlicesHam;
            return this;
        }

        public MakerPizza countSlicesTomato (int countSlicesTomato){
            this.countSlicesTomato=countSlicesTomato;
            return this;
        }

        public MakerPizza countMushrooms (int countMushrooms){
            this.countMushrooms=countMushrooms;
            return this;
        }

        public MakerPizza countBlackOlives (int countBlackOlives){
            this.countBlackOlives=countBlackOlives;
            return this;
        }

        public MakerPizza gramRedOnion (int gramRedOnion){
            this.gramRedOnion=gramRedOnion;
            return this;
        }

        public MakerPizza countGramChicken (int countGramChicken){
            this.countGramChicken=countGramChicken;
            return this;
        }

        public MakerPizza countSlicesPeperoni (int countSlicesPeperoni){
            this.countSlicesPeperoni=countSlicesPeperoni;
            return this;
        }

        public Pizza make(){
            return new Pizza(diameter, type, name, typeSouse,typeCheese, countSlicesHam, countSlicesTomato,
                    countMushrooms, countBlackOlives, gramRedOnion, countGramChicken, countSlicesPeperoni);
        }

    }


}
//Создайте класс Пицца с минимум 5 полями. Реализуйте внутренний класс-строитель,
// помогающий компоновать объект Пицца.