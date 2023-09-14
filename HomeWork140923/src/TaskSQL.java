import java.util.Arrays;

public class TaskSQL {
    public static void main(String[] args) {
       //1) Берем исходную строку с данными из cars
        //{"model", "V-60", "country", "Germany", "city", "Berlin", "year", null, "active", true}
        //Если значение второго параметра равно null с каждой пары, то параметр не должен попадать в условие отбора, которое задается после ключевого слова WHERE в результирующей строке.
        //Пример: строка с данными из users: {"id", 1, "country", null, "city", "Helsinki", "year", null}
        //Результат, новая строка:  SELECT * FROM users WHERE id = '1'  AND city = 'Helsilnki';
    String str = "{\"model\", \"V-60\", \"country\", \"Germany\", \"city\", \"Berlin\", \"year\", null, \"active\", true}";
    str = str.substring(1,str.length()-1);

    String[] arr = str.split(", ");
    StringBuilder result = new StringBuilder();

    result.append("SELECT * FROM cars WHERE ");
        for (int i = 0; i < arr.length-1; i+=2) {
            if(!arr[i+1].equals("null")){
                if (arr[i].charAt(0)==((char)34)){
                    result.append(arr[i].substring(1,arr[i].length()-1));
                }
               result.append(" = ");
               if (arr[i+1].equals("true")||(arr[i+1].equals("false"))){
                   result.append(arr[i+1]);
                }
                else {
                if (arr[i+1].charAt(0)==((char)34)){
                    result.append("'").append(arr[i+1].substring(1,arr[i+1].length()-1)).append("'");
                }
                }
                if (i<arr.length-2) {
                    result.append(" AND ");
                }
            }
        }
    System.out.println(Arrays.toString(arr));
    System.out.println(result);
    }
}
