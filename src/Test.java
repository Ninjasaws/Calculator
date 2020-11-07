import Controller.BinaryCalculator;
import Controller.DecimalCalculator;
import Model.*;

import java.util.HashMap;

public class Test {

     static  HashMap<String, Integer> indexMap = new HashMap<>();//done?
     static  HashMap<Integer, String> typeMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        indexMap.put("b", 0);
        indexMap.put("B", 1);
        indexMap.put("kb", 2);
        indexMap.put("KB", 3);
        indexMap.put("mb", 4);
        indexMap.put("MB", 5);
        indexMap.put("gb", 6);
        indexMap.put("GB", 7);
        indexMap.put("tb", 8);
        indexMap.put("TB", 9); // done

        typeMap.put(0, "b"); // done
        typeMap.put(1, "B");
        typeMap.put(2, "kb");
        typeMap.put(3, "KB");
        typeMap.put(4, "mb");
        typeMap.put(5, "MB");
        typeMap.put(6, "gb");
        typeMap.put(7, "GB");
        typeMap.put(8, "tb");
        typeMap.put(9, "TB");

        SizeUnit band = new SizeUnit(5000,"KB");

        System.out.println(band);

        System.out.println(band.convertTo("TB"));

        System.out.println(typeMap.get(0));

        System.out.println(DataConverter("500000","KB","b") + " b");
        System.out.println(DataConverter("500000","KB","B") + " B");
        System.out.println(DataConverter("500000","KB","kb") + " kb");
        System.out.println(DataConverter("500000","KB","KB") + " KB");
        System.out.println(DataConverter("500000","KB","mb") + " mb");
        System.out.println(DataConverter("500000","KB","MB") + " MB");
        System.out.println(DataConverter("500000","KB","gb") + " gb");
        System.out.println(DataConverter("500000","KB","GB") + " GB");
        System.out.println(DataConverter("500000","KB","tb") + " tb");
        System.out.println(DataConverter("500000","KB","TB") + " TB");

        System.out.println(new SizeUnit(0.00003,"KB").convertTo("GB"));





    }




    public static double DataConverter(String data, String type, String type2) {

        double rawData = Double.parseDouble(data);
        double index = indexMap.get(type);
        double i = indexMap.get(type2);

        if (index % 2 == 0) {
            if ((i + index) % 2 == 0) {

                if (i >= index)
                    return (rawData * Math.pow(0.001, (i - index) / 2));

                else if (i < index)
                    return (rawData / Math.pow(0.001, (index - i) / 2));

            } else if (Math.abs(i - index) % 2 == 1) {

                if (i >= index)
                    return (rawData * Math.pow(0.001, (i - index - 1) / 2) * 0.125);

                else if (i < index)
                    return ((rawData / Math.pow(0.001, (index - i + 1) / 2)) * 0.125);
            }
        } else if (index % 2 == 1) {
            if ((i + index) % 2 == 0) {

                if (i >= index)
                    return (rawData * Math.pow(0.001, (i - index) / 2));

                else if (i < index)
                    return (rawData / Math.pow(0.001, (index - i) / 2));

            } else if ((i + index) % 2 == 1) {

                if (i >= index)
                    return (rawData * Math.pow(0.001, (i - index - 1) / 2) * 0.008);
                else if (i < index) {
                    return ((1.0 * rawData / Math.pow(0.001, ((index - i + 1) / 2))) * 0.008);
                }
            }
        } else {
            System.out.println("Error: i = " + i + " index = " + index + " data = " + data);
        }
        return -1;}

}
