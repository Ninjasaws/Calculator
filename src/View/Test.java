package View;

import Controller.BinaryCalculator;
import Controller.DecimalCalculator;
import Controller.HexCalculator;
import Controller.InternetCalculator;
import Model.*;

public class Test {

    public static void main(String[] args) throws Exception {

        Binary bin1 = new Binary("10101000010111");
        Binary bin2 = new Binary("1010100111");

        Decimal dec1 = new Decimal("10775");
        Decimal dec2 = new Decimal("679");

        Hexadecimal hex1 = new Hexadecimal("2A17");
        Hexadecimal hex2 = new Hexadecimal("2A7");

        System.out.println(new BinaryCalculator(bin1).Add(bin2).toString().equals("10110010111110"));
        System.out.println(new BinaryCalculator(bin1).Subtract(bin2).toString().equals("10011101110000"));
        System.out.println(new BinaryCalculator(bin1).Divide(bin2));
        System.out.println(new BinaryCalculator(bin1).Modulus(bin2));
        System.out.println("1111 Remainder : 01001001110");
        System.out.println(new BinaryCalculator(bin1).Multiply(bin2).toString().equals("11011111010001100000001"));
        System.out.println(bin1.toDecimal().toString().equals("10775"));
        System.out.println(bin1.toHexadecimal().toString().equals("2A17"));

        System.out.println(new BinaryCalculator(bin2).Add(bin1).toString().equals("10110010111110"));
        System.out.println(new BinaryCalculator(bin2).Subtract(bin1).toString().equals("-10011101110000"));
        System.out.println(new BinaryCalculator(bin2).Divide(bin1));
        System.out.println(new BinaryCalculator(bin2).Modulus(bin1));
        System.out.println("0 Remainder : 01010100111");
        System.out.println(new BinaryCalculator(bin2).Multiply(bin1).toString().equals("11011111010001100000001"));
        System.out.println(bin2.toDecimal().toString().equals("679"));
        System.out.println(bin2.toHexadecimal().toString().equals("2A7"));
////////////////
        System.out.println(new DecimalCalculator(dec1).Add(dec2).toString().equals("11454"));
        System.out.println(new DecimalCalculator(dec1).Subtract(dec2).toString().equals("10096"));
        System.out.println(new DecimalCalculator(dec1).Divide(dec2));
        System.out.println(new DecimalCalculator(dec1).Modulus(dec2));
        System.out.println("15 Remainder : 590");
        System.out.println(dec1.toBinary().toString().equals("10101000010111"));
        System.out.println(dec1.toHexadecimal().toString().equals("2A17"));


        System.out.println(new DecimalCalculator(dec2).Add(dec1).toString().equals("11454"));
        System.out.println(new DecimalCalculator(dec2).Subtract(dec1).toString().equals("-10096"));
        System.out.println(new DecimalCalculator(dec2).Divide(dec1));
        System.out.println(new DecimalCalculator(dec2).Modulus(dec1));
        System.out.println("0 Remainder : 679");
        System.out.println(dec2.toBinary().toString().equals("1010100111"));
        System.out.println(dec2.toHexadecimal().toString().equals("2A7"));
///////////////
        System.out.println(new HexCalculator(hex1).Add(hex2).toString().equals("2CBE"));
        System.out.println(new HexCalculator(hex1).Subtract(hex2).toString().equals("2770"));
        System.out.println(new HexCalculator(hex1).Divide(hex2));
        System.out.println(new HexCalculator(hex1).Modulus(hex2));
        System.out.println("F Remainder : 24E");
        System.out.println(new HexCalculator(hex1).Multiply(hex2).toString().equals("6FA301"));
        System.out.println(hex1.toBinary().toString().equals("10101000010111"));
        System.out.println(hex1.toDecimal().toString().equals("10775"));

        System.out.println(new HexCalculator(hex2).Add(hex1).toString().equals("2CBE"));
        System.out.println(new HexCalculator(hex2).Subtract(hex1).toString().equals("-2770"));
        System.out.println(new HexCalculator(hex2).Divide(hex1));
        System.out.println(new HexCalculator(hex2).Modulus(hex1));
        System.out.println("0 Remainder : 2A7");
        System.out.println(new HexCalculator(hex2).Multiply(hex1).toString().equals("6FA301"));
        System.out.println(hex2.toBinary().toString().equals("1010100111"));
        System.out.println(hex2.toDecimal().toString().equals("679"));
        System.out.println("------------");
        new SizeUnit(500,"MB").printAll();

        System.out.println("4000000000 bits (b)");
        System.out.println("500000000 Bytes (B)");
        System.out.println("4000000 kilobits (kb)");
        System.out.println("500000 Kilobytes (KB)");
        System.out.println("4000 megabits (mb)");
        System.out.println("500 Megabytes (MB)");
        System.out.println("4 gigabits (gb)");
        System.out.println("0.5 Gigabytes (GB)");
        System.out.println("0.004 terabits (tb)");
        System.out.println("0.0005 Terabytes (TB)");

        System.out.println(new InternetCalculator().estimateTime(new SizeUnit(500,"MB"),new RateUnit(5,"Mbit/s")));
        System.out.println("----------Download or upload time needed is: ~13 minutes 20 seconds");
        System.out.println(new InternetCalculator().websiteBandwidth(new FrequencyUnit(5000,"day"),new SizeUnit(500,"KB")));
        System.out.println();
        System.out.println(new InternetCalculator().websiteBandwidth(new FrequencyUnit(5000,"day"),new SizeUnit(500,"KB"),2));
        System.out.println();
        System.out.println("----Actual bandwidth needed is 0.23148148148148 Mbits/s or 76.09375 GB per month.\n" +
                "\n" +
                "With redundancy factor of 2, the bandwidth needed is 0.46296296296296 Mbits/s or 152.1875 GB per month.----");
        System.out.println();
        System.out.println(new InternetCalculator().hostingBandwidth(new SizeUnit(1000,"GB"),"Mbit/s"));
        new InternetCalculator().hostingBandwidth(new SizeUnit(1000,"GB"),"Mbit/s");
        System.out.println("-----------1000 Gigabytes (GB) per month is equivalent to 3.0420564301468 Mbit/s.");
        System.out.println(new InternetCalculator().hostingBandwidth(new RateUnit(3,"Mbit/s"),"GB"));
        System.out.println("--------3 Mbit/s is equivalent to 986.175 Gigabytes (GB) per month.");
    }
}
