package View;

import Controller.BinaryCalculator;
import Controller.HexCalculator;
import Controller.InternetCalculator;
import Model.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput { // Plan to add console text removal, and finish/simplify wording/commands

    public void goof(File input) throws Exception {

        String result = "";

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
                    String operator = line.next().toUpperCase();

                    switch (Location) {
                        case "BINARY" -> {
                            String bin1 = line.next();
                            String bin2 = line.next();
                            switch (operator) {
                                case "+":
                                    result = bin1 + " + " + bin2 + " = " + new BinaryCalculator(new Binary(bin1)).Add(new Binary(bin2));
                                    break;
                                case "-":
                                    result = bin1 + " - " + bin2 + " = " + new BinaryCalculator(new Binary(bin1)).Subtract(new Binary(bin2));
                                    break;
                                case "/":
                                    result = bin1 + " / " + bin2 + " = " + new BinaryCalculator(new Binary(bin1)).Divide(new Binary(bin2))
                                            + " remainder: " + new BinaryCalculator(new Binary(bin1)).Modulus(new Binary(bin2));
                                    break;
                                case "*":
                                    result = bin1 + " * " + bin2 + " = " + new BinaryCalculator(new Binary(bin1)).Multiply(new Binary(bin2));
                                    break;
                                case "TO":
                                    if (bin1.toUpperCase().equals("DECIMAL"))
                                        result = "Binary (" + bin2 + ") to Decimal = " + new Binary(bin2).toDecimal();
                                    break;
                                default:
                                    result = "Binary Calculation Error";
                                    break;
                            }
                        }
                        case "HEXADECIMAL" -> {
                            String Hex1 = line.next().toUpperCase();
                            String Hex2 = line.next().toUpperCase();
                            if (operator.equals("+"))
                                result = Hex1 + " + " + Hex2 + " = " + new HexCalculator(new Hexadecimal(Hex1)).Add(new Hexadecimal(Hex2));
                            if (operator.equals("-"))
                                result = Hex1 + " - " + Hex2 + " = " + new HexCalculator(new Hexadecimal(Hex1)).Subtract(new Hexadecimal(Hex2));
                            if (operator.equals("/"))
                                result = Hex1 + " / " + Hex2 + " = " + new HexCalculator(new Hexadecimal(Hex1)).Divide(new Hexadecimal(Hex2))
                                        + " remainder: " + new HexCalculator(new Hexadecimal(Hex1)).Modulus(new Hexadecimal(Hex2));
                            if (operator.equals("*"))
                                result = Hex1 + " * " + Hex2 + " = " + new HexCalculator(new Hexadecimal(Hex1)).Multiply(new Hexadecimal(Hex2));
                            if (operator.equals("TO")) {
                                if (Hex1.equals("DECIMAL"))
                                    result = "Hexadecimal (" + Hex2 + ") to Decimal = " + new Hexadecimal(Hex2).toDecimal();
                            }
                        }
                        case "DECIMAL" -> {
                            String state = line.next().toUpperCase();
                            String Dec = line.next();
                            if (state.equals("BINARY")) {
                                result = "Decimal (" + Dec + ") to Binary = " + new Decimal(Dec).toBinary();
                            }
                            if (state.equals("HEXADECIMAL")) {
                                result = "Decimal (" + Dec + ") to Hexadecimal = " + new Decimal(Dec).toHexadecimal();
                            }
                        }
                        case "DATA", "WEBSITE", "MONTHLY", "DOWNLOAD/UPLOAD" -> result = CalculateWeb(Location + " " + operator + line.nextLine());
                        default -> throw new IllegalStateException("Unexpected value: " + Location);
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

        //System.out.println(operator);
        //System.out.println(lastTokens);
        if(operator.equals("DATA")){
            result = new SizeUnit(Double.parseDouble( lastTokens.get(lastTokens.size()-1)),"b").convertTo(lastTokens.get(lastTokens.size()-2)).getVal() + ""; //
            result = lastTokens.get(lastTokens.size()-1) + " bit(s) to " + lastTokens.get(lastTokens.size()-2) + " = " + result + " " + lastTokens.get(lastTokens.size()-2);
        }

        if(operator.equals("DOWNLOAD/UPLOAD")){
            result = new InternetCalculator().estimateTime(new SizeUnit(Double.parseDouble(lastTokens.get(1)),lastTokens.get(2)),
                    new RateUnit(Double.parseDouble(lastTokens.get(3)),lastTokens.get(4))); }


        if(operator.equals("WEBSITE")){
            if(lastTokens.size() == 7)
            result = new InternetCalculator().websiteBandwidth(new FrequencyUnit(Double.parseDouble(lastTokens.get(1)),lastTokens.get(3)),
                    new SizeUnit(Double.parseDouble(lastTokens.get(4)),lastTokens.get(5)),Integer.parseInt(lastTokens.get(6)));
                    else result = new InternetCalculator().websiteBandwidth(new FrequencyUnit(Double.parseDouble(lastTokens.get(1)),lastTokens.get(3)),
                    new SizeUnit(Double.parseDouble(lastTokens.get(4)),lastTokens.get(5)));
        }
        if(operator.equals("MONTHLY")){

            if(!(new RateUnit().wordMap.containsKey( lastTokens.get(lastTokens.size()-2)))){
                result = new InternetCalculator().hostingBandwidth(new RateUnit(Double.parseDouble(lastTokens.get(4)),lastTokens.get(5)),lastTokens.get(3));
                //hostingBandwidth(RateUnit Bandwidth,String sizeType)
            }
            else {
                result = new InternetCalculator().hostingBandwidth(new SizeUnit(Double.parseDouble(lastTokens.get(3)),lastTokens.get(4)),lastTokens.get(5));
            }//hostingBandwidth(SizeUnit monthlyUse,String bandwidthUnit)
        }

        return result;
    }
}
