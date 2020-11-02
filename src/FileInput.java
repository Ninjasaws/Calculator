import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileInput  extends Calculator.BinDecHexCalc {

    public static final HashMap<String,String> wordMap = new HashMap<>();

    public static void set(boolean file) throws Exception {

        setValues();

        wordMap.put("BITS", "b");
        wordMap.put("KILOBITS", "kb");
        wordMap.put("MEGABITS", "mb");
        wordMap.put("GIGABITS", "gb");
        wordMap.put("TERABITS", "tb");
        wordMap.put("BYTES", "B");
        wordMap.put("KILOBYTES", "KB");
        wordMap.put("MEGABYTES", "MB");
        wordMap.put("GIGABYTES", "GB");
        wordMap.put("TERABYTES", "TB");
        wordMap.put("BIT/S", "b");
        wordMap.put("KBIT/S", "kb");
        wordMap.put("MBIT/S", "mb");
        wordMap.put("GBIT/S", "gb");
        wordMap.put("TBIT/S", "tb");
        if(file) goof();
    }
    public static void goof() throws Exception {
        String result = "";

        File input = new File("inputData.txt");

        File output = new File("outputData.txt");
        output.createNewFile();
        FileWriter toWrite = new FileWriter(output);

        Scanner sc = new Scanner(input);
        while(sc.hasNextLine()){
            Scanner line = new Scanner(sc.nextLine());
            while(line.hasNext()){
                String word = line.next();

                if(word.toUpperCase().equals("CALCULATE") || word.toUpperCase().equals("CONVERT")){
                    String Location = line.next().toUpperCase();
                    String operator = line.next().toUpperCase();;

                    if(Location.equals("BINARY")){
                        String bin1 = line.next();
                        String bin2 = line.next();
                        if(operator.equals("+")) result = bin1 + " + " + bin2 + " = " + (binAdd(bin1,bin2));
                        else if(operator.equals("-")) result = bin1 + " - " + bin2 + " = " + (binSub(bin1,bin2));
                        else if(operator.equals("/")) result = bin1 + " / " + bin2 + " = " + (binDivide(bin1,bin2));
                        else if(operator.equals("*")) result = bin1 + " * " + bin2 + " = " + (binMulti(bin1,bin2));
                        else if(operator.equals("TO")) {
                            if(bin1.toUpperCase().equals("DECIMAL"))
                                result = "Binary (" + bin2 + ") to Decimal = " + (BinToDec(bin2));
                        }
                        else result = "Binary Calculation Error";

                    }// End Binary

                    else if(Location.equals("HEXADECIMAL")){
                        String Hex1 = line.next().toUpperCase();
                        String Hex2 = line.next().toUpperCase();
                        if(operator.equals("+")) result = Hex1 + " + " + Hex2 + " = " + (HexAdd(Hex1,Hex2));
                        if(operator.equals("-")) result = Hex1 + " - " + Hex2 + " = " + (HexSub(Hex1,Hex2));
                        if(operator.equals("/")) result = Hex1 + " / " + Hex2 + " = " + (HexDivide(Hex1,Hex2));
                        if(operator.equals("*")) result = Hex1 + " * " + Hex2 + " = " + (HexMulti(Hex1,Hex2));
                        if(operator.equals("TO")) {
                            if(Hex1.equals("DECIMAL"))
                                result = "Hexadecimal (" + Hex2 + ") to Decimal = " + (HexToDec(Hex2));
                        }
                    }

                    else if(Location.equals("DECIMAL")){
                        String state = line.next().toUpperCase();;
                        String Dec = line.next();
                        if(state.equals("BINARY")) {
                            result = "Decimal (" + Dec + ") to Binary = " + (DecToBin(Dec));
                        }
                        if(state.equals("HEXADECIMAL")) {
                            result = "Decimal (" + Dec + ") to Hexadecimal = " + (DecToHex(Dec));
                        }
                    }
                    else if(Location.equals("DATA") ||
                            Location.equals("WEBSITE") ||
                            Location.equals("MONTHLY") ||
                            Location.equals("DOWNLOAD/UPLOAD") ){

                        result = CalculateWeb(Location + " " + operator + line.nextLine());
                    }
                }
                else {throw new Exception("Incorrect statement >" + word+ "<"); }
                toWrite.write(result+"\n");
            }// last word on line
        }// last line

        toWrite.close();
    }//main

    public static String CalculateWeb(String line) throws Exception {
        Scanner str = new Scanner(line.toUpperCase());
        String operator = str.next();
        String result = "";

        ArrayList<String> lastTokens = new ArrayList<>();

        while(str.hasNext()) { lastTokens.add(str.next().toUpperCase()); }

        if(operator.equals("DATA")){
            result = (DataConverter(lastTokens.get(lastTokens.size()-1),"b",wordMap.get(lastTokens.get(lastTokens.size()-2))) + "");
            result = lastTokens.get(lastTokens.size()-1) + " bit(s) to " + lastTokens.get(lastTokens.size()-2) + " = " + result + " " + wordMap.get(lastTokens.get(lastTokens.size()-2));
        }

        if(operator.equals("DOWNLOAD/UPLOAD")){
            result = (  LoadTimeCalc( lastTokens.get(lastTokens.size()-4),  wordMap.get(lastTokens.get(lastTokens.size()-3)),
                    lastTokens.get(lastTokens.size()-2),   wordMap.get(lastTokens.get(lastTokens.size()-1)))   ); }

        if(operator.equals("WEBSITE")){
            double[] arr = new double[2];
            arr = webBandwidth( Double.parseDouble( lastTokens.get(lastTokens.size()-6)),lastTokens.get(lastTokens.size()-4), Double.parseDouble( lastTokens.get(lastTokens.size()-3)),wordMap.get(lastTokens.get(lastTokens.size()-2)));
            result = (     "Actual bandwidth needed is " + arr[1] + " Mbit/s or " + arr[0] + " GB per month"     );
            result += (     "\nwith a redundancy factor of "  + Double.parseDouble( lastTokens.get(lastTokens.size()-1)) * arr[1] + " Mbit/s or "
                    + arr[0] * Double.parseDouble( lastTokens.get(lastTokens.size()-1)) + " GB per month."     );
        }
        if(operator.equals("MONTHLY")){

            if(!(wordMap.containsKey(lastTokens.get(lastTokens.size()-2)))){
                result = (HostBandConvREV(Double.parseDouble(lastTokens.get(lastTokens.size()-2)),wordMap.get(lastTokens.get(lastTokens.size()-1)),
                        wordMap.get(lastTokens.get(lastTokens.size()-3))) + "");
                result = lastTokens.get(lastTokens.size()-2) + " " + wordMap.get(lastTokens.get(lastTokens.size()-1)) + " is equivalent to "
                        + result +" "+ lastTokens.get(lastTokens.size()-3) + " per month";
            }
            else {
                result = HostBandConv(Double.parseDouble(lastTokens.get(lastTokens.size() - 3)), wordMap.get(lastTokens.get(lastTokens.size() - 2)),
                        wordMap.get(lastTokens.get(lastTokens.size() - 1))) + " " ;
                result = lastTokens.get(lastTokens.size() - 3) + " " + lastTokens.get(lastTokens.size() - 2) + " is equivalent to "
                        + result.charAt(0) + result.charAt(1) + result.charAt(2) + " " + lastTokens.get(lastTokens.size() - 1);
            }
        }

        return result;
    }
}
