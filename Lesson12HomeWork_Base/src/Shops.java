import java.util.Random;

public class Shops {
    public static void main(String[] args) {
        Random rnd = new Random();
        boolean isEdekaOpen = rnd.nextBoolean();
        boolean isReweOpen = rnd.nextBoolean();
        String result;
        String shopName = "";

        if ((isEdekaOpen && isReweOpen)||(!isEdekaOpen && !isReweOpen)){
            shopName = "any shop";
        }
        else if (isEdekaOpen){
            shopName = "Edeka";
        }
        else if (isReweOpen){
            shopName = "Reve";
        }

        result = canBuy(isEdekaOpen, isReweOpen) ? "I can buy food in " : "I don`t can buy food in ";
        System.out.println(result + shopName);
    }
    static boolean canBuy(boolean firstShop, boolean secondShop) {
        if (firstShop || secondShop) {
            return true;
        }
        else {
            return false;
        }
    }
}