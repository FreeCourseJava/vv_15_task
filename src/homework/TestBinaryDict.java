package homework;

import java.util.List;

import static java.util.Objects.hash;

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


        System.out.println("---------------Test hash collision ----------------");
        BinaryDictionary<String,String> dict1 = new BinaryDictionary<>();

        System.out.println(hash("A".hashCode()));
        System.out.println(hash("AaAa".hashCode()));
        System.out.println(hash("BBBB".hashCode()));
        System.out.println(hash("Aa".hashCode()));
        System.out.println(hash("BB".hashCode()));
        System.out.println(hash("AaBB".hashCode()));
        System.out.println(hash("BBAa".hashCode()));


        dict1.put("A", "String 1");
        dict1.put("AaAa", "String 2");
        dict1.put("BBBB", "String 3");
        dict1.put("Aa", "String 4");
        dict1.put("BB", "String 5");
        dict1.put("AaBB", "String 6");
        dict1.put("BBAa", "String 7");

        System.out.println(dict1);
        System.out.println(dict1.get("A"));
        System.out.println(dict1.get("AaAa"));
        System.out.println(dict1.get("BBBB"));
        System.out.println(dict1.get("Aa"));
        System.out.println(dict1.get("BB"));
        System.out.println(dict1.get("AaBB"));
        System.out.println(dict1.get("BBAa"));


    }


}
