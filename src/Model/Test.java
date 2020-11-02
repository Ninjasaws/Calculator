package Model;

public class Test {

    public static void main(String[] args) {
        System.out.println("Testing model!");
        Decimal bin = new Decimal("111");

        System.out.println(bin);
        bin.setNumber("101010");
        System.out.println(bin);
        bin.setNumber("9");
        System.out.println(bin);
        bin.setNumber("278");
        System.out.println(bin);
        bin.setNumber("102F");
        System.out.println(bin);
    }
}
