import java.util.*;
public class UserInterface extends FileInput{

    public static void main(String[] args) throws Exception {

        ArrayList<String> tokens = new ArrayList<>();

        //set(true);
        setValues();
        welcomeText();

        Scanner scan = new Scanner(System.in);
        String input = "";


        while(!input.equals("exit")){
            tokens.clear();
            System.out.print("Main Menu -> ");
            input = scan.nextLine();
            Scanner strToken = new Scanner(input);
            System.out.println();

            while(strToken.hasNext())
                tokens.add(strToken.next());

            switch(tokens.get(0)) {
                case "1":
                    input = DataUnits();
                    break;
                case "2":
                    input = DataUnitsMod();
                    break;
                case "3":
                    input = ConvUnit();
                    break;
                case "4":
                    input = Usage();
                    break;
                case "5":
                    input = loadTime();
                    break;
                case "6":
                    input = webSite();
                    break;
                case "file":
                    // Send name of file tokens.get(1) to be read.
                    break;
                default:
                    break;
            }
        }
    }

    public static void welcomeText(){
        System.out.println("\n\n               Welcome to Calculator.exe");
        System.out.println("To select an option, enter a number from the corresponding action");

        System.out.println("");
        System.out.println("~           Hexadecimal / Decimal / Binary           ~\n");
        System.out.println("(1) Conversions: DataTypes ");
        System.out.println("(2) Calculate ~: Add / Subtract / Multiply / Divide");
        System.out.println("");
        System.out.println("~                 Website  DataUnits                 ~\n");
        System.out.println("(3) Conversions: dataUnit to another dataUnit");
        System.out.println("(4) Conversions: Bandwidth / Monthly Usage");
        System.out.println("(5) Calculate ~: Download/Upload time");
        System.out.println("(6) Calculate ~: Website bandwidth");
        System.out.println("");
        System.out.println("~                      Commands                      ~\n");
        System.out.println("Exit Program: \"exit\"");
        System.out.println("Main-menu   : \"main\"");
        System.out.println("Save result : \"save\"");
        System.out.println("Help page   : \"help\"");
        System.out.println("input file  : \"file <file Name>\"");
        System.out.println("");
    }

    public static void dataUnitList() {
        System.out.println("dataUnit List: <b> - bits, <kb> - kilobits,  <mb> - megabits, <gb> - gigabits, <tb> - terabits");
        System.out.println("             : <B> - Bytes, <KB> - Kilobytes, <MB> - Megabytes,  <GB> - Gigabytes, <TB> - Terabytes ");
    }
    public static void bandwidthType(){
        System.out.println("bandwidthType are the following in carrots <>");
        System.out.println("<b>/s -> bits per second");
        System.out.println("<kb>/s -> kilobits per second");
        System.out.println("<mb>/s -> megabits per second");
        System.out.println("<gb>/s -> gigabits per second");
        System.out.println("<tb>/s -> terabits per second");
    }

    public static String DataUnits() throws Exception {
        String input = "";


        Scanner scan = new Scanner(System.in);

        System.out.println("To convert DataTypes, type in the format \"<#value> <DataType> -> <DataType>\"");
        System.out.println("dataType List: <B> - Binary, <D> - Decimal,  <H> - Hexadecimal");
        System.out.println("To save results to the output file, add \"s\" to the end of your input\n");

        while(!(input.equals("exit") || input.equals("main"))) {
            ArrayList<String> tokens = new ArrayList<>();

            System.out.print("Convert: ");
            input = scan.nextLine();
            if(!(input.equals("exit") || input.equals("main"))) {
                Scanner words = new Scanner(input);
                while (words.hasNext())
                    tokens.add(words.next().toUpperCase());

                System.out.println(tokens);

                if (tokens.get(1).equals("B")) {
                    if (tokens.get(2).equals("D"))
                        input = "" + BinToDec(tokens.get(0));
                    else if (tokens.get(2).equals("H"))
                        input = "" + BinToHex(tokens.get(0));
                    else input = "Error Binary";
                } else if (tokens.get(1).equals("D")) {
                    if (tokens.get(2).equals("B"))
                        input = "" + DecToBin(tokens.get(0));
                    else if (tokens.get(2).equals("H"))
                        input = "" + DecToHex(tokens.get(0));
                    else input = "Error Decimal";
                } else if (tokens.get(1).equals("H")) {
                    if (tokens.get(2).equals("B"))
                        input = "" + HexToBin(tokens.get(0));
                    else if (tokens.get(2).equals("D"))
                        input = "" + HexToDec(tokens.get(0));
                    else input = "Error Hexadecimal";
                }
                else input = "USER ERROR?";
                System.out.println("result : " + input);
            }
            else System.out.println("oof");
        }
        return input;

    }

    public static String DataUnitsMod() throws Exception {
        String input = "";


        Scanner scan = new Scanner(System.in);

        System.out.println("To do math on DataTypes, type in the format \"<DataType> <#value> <mathSymbol> <#value>\"");
        System.out.println("dataType List: <B> - Binary, <D> - Decimal,  <H> - Hexadecimal");
        System.out.println("To save results to the output file, add \"s\" to the end of your input\n");
        System.out.println("Note: Only binary numbers can be inputted as negatives");

        while(!(input.equals("exit") || input.equals("main"))) {
            ArrayList<String> tokens = new ArrayList<>();

            System.out.print("Math: ");
            input = scan.nextLine();
            if(!(input.equals("exit") || input.equals("main"))) {
                Scanner words = new Scanner(input);
                while (words.hasNext())
                    tokens.add(words.next().toUpperCase());

                System.out.println(tokens);

                if (tokens.get(0).equals("B")) {
                    if (tokens.get(2).equals("+"))
                        input = "" + binAdd(tokens.get(1),tokens.get(3));
                    else if (tokens.get(2).equals("-"))
                        input = "" + binSub(tokens.get(1),tokens.get(3));
                    else if (tokens.get(2).equals("/"))
                        input = "" + binDivide(tokens.get(1),tokens.get(3));
                    else if (tokens.get(2).equals("*"))
                        input = "" + binMulti(tokens.get(1),tokens.get(3));
                    else input = "Error Binary";
                }else if (tokens.get(0).equals("D")) {
                    if (tokens.get(2).equals("+"))
                        input = "" + (Long.parseLong( tokens.get(1))+Long.parseLong( tokens.get(3)));
                    else if (tokens.get(2).equals("-"))
                        input = "" + (Long.parseLong( tokens.get(1))-Long.parseLong( tokens.get(3)));
                    else if (tokens.get(2).equals("/"))
                        input = "" + (Long.parseLong( tokens.get(1))/Long.parseLong( tokens.get(3)) + "Remainder: " + Long.parseLong( tokens.get(1))%Long.parseLong( tokens.get(3)));
                    else if (tokens.get(2).equals("*"))
                        input = "" + (Long.parseLong( tokens.get(1))*Long.parseLong( tokens.get(3)));
                    else input = "Error Binary";
                }else if (tokens.get(0).equals("H")) {
                    if (tokens.get(2).equals("+"))
                        input = "" + HexAdd(tokens.get(1),tokens.get(3));
                    else if (tokens.get(2).equals("-"))
                        input = "" + HexSub(tokens.get(1),tokens.get(3));
                    else if (tokens.get(2).equals("/"))
                        input = "" + HexDivide(tokens.get(1),tokens.get(3));
                    else if (tokens.get(2).equals("*"))
                        input = "" + HexMulti(tokens.get(1),tokens.get(3));
                    else input = "Error Binary";
                }
                else input = "USER ERROR?";
                System.out.println("result: " + input);
            }
        }
        return input;
    }

    public static String ConvUnit() throws Exception{
        String input = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("To convert dataUnits, type in the format \"<#value> <dataUnit> -> <dataUnit>\"");
        dataUnitList();
        System.out.println("To save results to the output file, add \"s\" to the end of your input\n");


        while(!(input.equals("exit") || input.equals("main"))) {
            ArrayList<String> tokens = new ArrayList<>();

            System.out.print("Convert: ");
            input = scan.nextLine();
            if(!(input.equals("exit") || input.equals("main"))) {
                Scanner words = new Scanner(input);
                while (words.hasNext())
                    tokens.add(words.next());

                System.out.println(tokens);

                if (!(tokens.size() > 4 ||tokens.size() < 3))
                    input = DataConverter(tokens.get(0),tokens.get(1),tokens.get(2)) +"";
                else input = "USER ERROR?";
                System.out.println("result: " + input);
            }
        }
        return input;
    }

    /*
        System.out.println("(6) Calculate ~: Website bandwidth");
     */
    public static String Usage(){
        String input = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("To convert Bandwidth to Monthly Usage, type in the format \"<#value> <bandwidthType> -> <dataUnit>\"");
        System.out.println("To convert Monthly Usage to Bandwidth, type in the format \"<#value> <dataType> -> <bandwidthType>\"");
        System.out.println("Note: DataUnits are in Bytes, while bandwidth is in bits");
        bandwidthType();



        while(!(input.equals("exit") || input.equals("main"))) {
            ArrayList<String> tokens = new ArrayList<>();

            System.out.print("Convert: ");
            input = scan.nextLine();
            if(!(input.equals("exit") || input.equals("main"))) {
                Scanner words = new Scanner(input);
                while (words.hasNext())
                    tokens.add(words.next());

                System.out.println(tokens);


                System.out.println(Character.isLowerCase(tokens.get(1).charAt(0)));

                if(Character.isLowerCase(tokens.get(1).charAt(0))){
                    input = (HostBandConvREV(Double.parseDouble(tokens.get(0)),tokens.get(1),tokens.get(2))) +" ";
                    input += tokens.get(2).toUpperCase() + " per month";
                }
                else {
                    input = HostBandConv(Double.parseDouble(tokens.get(0)),tokens.get(1),tokens.get(2)) +"";
                    input = input.charAt(0) + "" + input.charAt(1) + "" + input.charAt(2)+ " ";
                    input += tokens.get(2).toUpperCase() + "it/s";
                }

                System.out.println("result: " + input);
            }
        }
        return input;
    }

    public static String loadTime(){
        String input = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("To get Download/Upload Time, type in the format \"<#value> <dataUnit> <#value> <dataUnit>\"");
        System.out.println("Note: The first dataUnit parameter is the file Size, while the second is bandwidth measured per second");
        bandwidthType();



        while(!(input.equals("exit") || input.equals("main"))) {
            ArrayList<String> tokens = new ArrayList<>();

            System.out.print("Convert: ");
            input = scan.nextLine();
            if(!(input.equals("exit") || input.equals("main"))) {
                Scanner words = new Scanner(input);
                while (words.hasNext())
                    tokens.add(words.next());

                System.out.println(tokens);

                input = LoadTimeCalc(tokens.get(0),tokens.get(1),tokens.get(2),tokens.get(3));
                System.out.println("result: " + input);
            }
        }
        return input;


    }

    public static String webSite(){
        String input = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("To website bandwidth, type in carrots in the format \"<#value> /per <ScaleUnit>, <#value> <dataUnit> <redundancyFactor>\"");
        System.out.println("ScaleUnit refers to the following; <second>, <minute>, ..., <year>.");
        System.out.println("Note: Redundancy Factor not needed.");



        while(!(input.equals("exit") || input.equals("main"))) {
            ArrayList<String> tokens = new ArrayList<>();

            System.out.print("Convert: ");
            input = scan.nextLine();
            if(!(input.equals("exit") || input.equals("main"))) {
                Scanner words = new Scanner(input);
                while (words.hasNext())
                    tokens.add(words.next());

                System.out.println(tokens);

                double[] arr = new double[2];
                arr = webBandwidth(Double.parseDouble(tokens.get(0)),tokens.get(1).toUpperCase(),Double.parseDouble(tokens.get(2)),tokens.get(3));
                input = "Bandwidth needed: " + arr[1] + " Mbits/s or " + arr[0] + " GB per month";

                if(tokens.size() > 4 && !(tokens.get(4).equals("s")) )
                input += "\nWith Redundancy factor: "+ arr[1] * Double.parseDouble(tokens.get(4)) + " Mbits/s or "
                        + arr[0] * Double.parseDouble(tokens.get(4)) + " GB per month";

                System.out.println("result: " + input);
            }
        }
        return input;
    }
}
