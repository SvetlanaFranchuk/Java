package translator;

import java.util.*;

public class Translator {
    static Map<String, List<String>> wordToTranslate = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        firstFillDictionary();

        String userWord = "";
        List<String> translate = new ArrayList<>();
        do {
            System.out.print("Enter word for translate: ");
            userWord = scanner.nextLine();
            if (userWord.equals("stopTranslate")) return;
            translate = wordToTranslate.get(userWord.toLowerCase());
            if (translate==null) {
                addToDictionary(userWord);}
            else System.out.println(translate);
        }while (true);
     }

    private static void addToDictionary(String userWord){
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("This word is absent in dictionary. Are you want to add translation (y/n)? ");
        if (scanner1.next().equals("y")){
            System.out.print("Enter translate: ");
            Scanner scanner2 = new Scanner(System.in);
            String[] userTranslate = scanner2.nextLine().split(",");
            List<String> translateNew = new ArrayList<>();
            for (String s : userTranslate) {
                translateNew.add(s);
            }
            wordToTranslate.put(userWord, translateNew);
        }
        else return;
    }
    private static void firstFillDictionary(){
        List<String> translate1 = new ArrayList<>();
        translate1.add("ссылка");
        wordToTranslate.put("hyperlink", translate1);

        List<String> translate2 = new ArrayList<>();
        translate2.add("узел сети");
        wordToTranslate.put("node", translate2);

        List<String> translate3 = new ArrayList<>();
        translate3.add("пропускная способность");
        wordToTranslate.put("bandwidth", translate2);

        List<String> translate4 = new ArrayList<>();
        translate3.add("загрузка");
        translate3.add("загрузить");
        wordToTranslate.put("boot", translate3);

    }

}
//Создайте программу-переводчик с английского языка. Пользователь вводит слово на английском языке,
// переводчик показывает перевод. Если переводчик не обнаружил в словаре введённое слово,
// то он просит пользователя ввести перевод, после чего сохраняет слово и его перевод в словарь.
// Программа продолжается, пока пользователь не введёт stopTranslate.