package org.example.pizza;

public class Main {
    public static void main(String[] args) {
       Pizza pepperoni = Pizza.makerPizza()
               .diameter(DiametersPizza.D45)
               .name("Pepperoni")
               .countSlicesPeperoni(15)
               .typeCheese(TypeCheese.CHEDDAR)
               .make();

       Pizza stromboli = Pizza.makerPizza()
               .name("Stromboli")
               .type(TypePizza.SICILIANA)
               .countSlicesHam(8)
               .countMushrooms(6)
               .countSlicesTomato(12)
               .make();

       Pizza.MakerPizza margarita = Pizza.makerPizza().name("Margarita");
       margarita.countSlicesTomato(10);
       margarita.countSlicesPeperoni(12);
       margarita.typeSouse(TypeSouse.WHITE);
       margarita.make();

        System.out.println(pepperoni);
        System.out.println(stromboli);
        System.out.println(margarita);

    }
}