package homework;

import java.util.List;

public class TestBinaryDict {

    public static void main(String[] args) {
        BinaryDictionary<Integer,String> dict = new BinaryDictionary<>();

        dict.put(1,"a");
        dict.put(1,"a");
        dict.put(2,"b");
        dict.put(3,"b222");
        dict.put(4,"b2");
        dict.put(7,"b12");
        dict.put(25,"yssds");
        dict.put(10,"usdsdsdsdsd");

        System.out.println("---------------Test get() method----------------");
        System.out.println(dict.get(2));
        System.out.println(dict.get(10));
        System.out.println(dict.get(12));

        System.out.println("---------------Test toString() method----------------");
        System.out.println(dict);

        System.out.println("---------------Test filter() method----------------");
        List<String> filteredList = dict.filter( (v) -> v.length() > 3);
        System.out.println(filteredList);

    }


}
