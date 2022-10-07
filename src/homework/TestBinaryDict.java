package homework;

public class TestBinaryDict {

    public static void main(String[] args) {
        BinaryDictionary<Integer,String> dict1 = new BinaryDictionary<>();

        dict1.put(1,"a");
        dict1.put(1,"a");
        dict1.put(2,"b");
        dict1.put(3,"b");
        dict1.put(4,"b");
        dict1.put(7,"b");

        dict1.put(25,"y");
        dict1.put(10,"u");

        System.out.println(dict1.get(2));
        System.out.println(dict1.get(10));
        System.out.println(dict1.get(12));

    }


}
