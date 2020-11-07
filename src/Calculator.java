import java.util.ArrayList;

public abstract class Calculator { // Retired?

    public void add() {}

    public void subtract() {}

    public void divide() {}

    public void multiply() {}

    public static class BinDecHexCalc extends Bandwidth {

        /** This method serves to Subtract two hexadecimals then return the Sum of the
         * two in a String in hexadecimal form
         *
         * @param Hex1 first hexadecimal input to Subtract
         * @param Hex2 second hexadecimal input to that will Subtract from the first
         * @return String which is the result of the subtraction
         */
        public static String HexSub(String Hex1, String Hex2) throws Exception {

            if(!isHex(Hex1)) throw new Exception("Invalid Hexadecimal input (1) -> " + Hex1 );
            if(!isHex(Hex1)) throw new Exception("Invalid Hexadecimal input (2) -> " + Hex2 );

            if(HexToDec(Hex1) - HexToDec(Hex2) < 0)
                return "-" + DecToHex( -1* (HexToDec(Hex1) - HexToDec(Hex2)) +"");
            return DecToHex( HexToDec(Hex1) - HexToDec(Hex2) +"");
        }

        /** This method serves to Add two hexadecimals together and return the Sum of the
         * two in a String
         *
         * @param Hex1 first hexadecimal input to Add
         * @param Hex2 second hexadecimal input to Add
         * @return String which is the result of the first and second
         * hexadecimal adding together
         */
        public static String HexAdd(String Hex1, String Hex2) throws Exception {

            if(!isHex(Hex1)) throw new Exception("Invalid Hexadecimal input (1) -> " + Hex1 );
            if(!isHex(Hex1)) throw new Exception("Invalid Hexadecimal input (2) -> " + Hex2 );

            return DecToHex( HexToDec(Hex1) + HexToDec(Hex2) +"");
        }

        /** This method serves to take in two Hexadecimals and divides
         * the first Hexadecimal input by the second Hexadecimal input returning a result with a remained of the two in the form of a String
         *
         * @param Hex1 first Hexadecimal input that will be divided
         * @param Hex2 secon Hexadecimal input that will divide the first
         * @return String the result of the division of the two hexadecimal
         */
        public static String HexDivide(String Hex1, String Hex2) throws Exception {

            if(Hex2.equals("0")) throw new Exception("You cannot divide by zero! ");
            if(!isHex(Hex1)) throw new Exception("Invalid Hexadecimal input (1) -> " + Hex1 );
            if(!isHex(Hex1)) throw new Exception("Invalid Hexadecimal input (2) -> " + Hex2 );

            if(HexToDec(Hex1) % HexToDec(Hex2) == 0)
                return DecToHex( HexToDec(Hex1) / HexToDec(Hex2) +"");
            return DecToHex( HexToDec(Hex1) / HexToDec(Hex2) +"") + " Remainder: " + DecToHex(HexToDec(Hex1) % HexToDec(Hex2) + "");
        }

        /** This method serves to multiply two Hexadecimals together and return the result in a String
         * in the form of Hexadecimal
         *
         * @param Hex1 String first Hexadecimal input
         * @param Hex2 String second Hexadecimal input
         * @return String result of the Hexadecimal input in the form of Hexadecimal
         */
        public static String HexMulti(String Hex1,String Hex2) throws Exception {

            if(!isHex(Hex1)) throw new Exception("Invalid Hexadecimal input (1) -> " + Hex1 );
            if(!isHex(Hex1)) throw new Exception("Invalid Hexadecimal input (2) -> " + Hex2 );

            return DecToHex( HexToDec(Hex1) * HexToDec(Hex2) +"");
        }

        /** This method serves to convert a Decimal input to the form of a Hexadecimal
         *
         * @param dec String Decimal input
         * @return String returns a Hexadecimal in the form of a Decimal
         */
        public static String DecToHex(String dec) throws Exception {

            if(!isDec(dec)) throw new Exception("Invalid Decimal input -> " + dec);

            return BinToHex(DecToBin(dec));
        }

    //    public static String DecToHex2(String Dec){
    //
    //        if(Dec.equals("0")) return "0";
    //
    //        ArrayList<Character> valList = new ArrayList<>();
    //        ArrayList<Integer> powList = new ArrayList<>();
    //        long tempDec = Long.parseLong(Dec);
    //        while(tempDec > 1){
    //            int temp = (int) (Math.log(tempDec)/(4*Math.log(2)));
    //            powList.add(temp);
    //            char val = ((char) ((char) (tempDec / Math.pow(16,temp))));
    //            if(val >= 10) val +=  55;
    //                else val += 48;
    //            valList.add(val);
    //          tempDec -= Math.pow(16,temp) * ((int) (tempDec / Math.pow(16,temp)) );
    //
    //        }
    //        System.out.println(valList);
    //        System.out.println(powList);
    //
    //        String[] hexArray = new String[valList.get(0)];
    //
    //        for(int i = 0; i < hexArray.length; i++) hexArray[i] = "0";
    //
    //        for(int i = 0; i < valList.size(); i++){
    //
    //            hexArray[powList.get(i)] = valList.get(i) + "";
    //        }
    //
    //        return ArrToStr(hexArray);
    //    }

        /** This method serves to convert a Hexadecimal input and convert it to a Decimal
         * with the return being in the form of a String
         *
         * @param Hex String The Hexadecimal input that will be converted
         * @return String returns the result, of the Hexadecimal converted to a Decimal.
         */
        public static long HexToDec(String Hex) throws Exception {

            if(!isHex(Hex)) throw new Exception("Invalid Hexadecimal input -> " + Hex );

            long bin = 0;

            for(int i = 0; i < Hex.length(); i++){ // If value at HexString is found to be a symbol, then it is subtracted to correct binary to be x 16^(x)
                double pow = Math.pow(16, Hex.length() - 1 - i);
                if(Hex.charAt(i) > 60) bin += ((Hex.charAt(i) - 55) * pow); // -54
                else bin += ((Hex.charAt(i) - 48) * pow);// -48
            }

            return bin;
        }

        /** This method serves to convert a Hexadecimal input and convert it to a Binary number
         * with the return being in the form of a String
         *
         * @param Hex String The Hexadecimal input that will be converted
         * @return String returns the result, of the Hexadecimal converted to a Binary number.
         */
        public static String HexToBin(String Hex) throws Exception {

            if(!isHex(Hex)) throw new Exception("Invalid Hexadecimal input -> " + Hex );

            return DecToBin(HexToDec(Hex)+"");

        }

        /** This method serves to convert a Binary number input and convert it to a Hexadecimal
         * with the return being in the form of a String
         *
         * @param Bin String input to be converted to a Hexadecimal
         * @return String returns a Hexadecimal
         */
        public static String BinToHex(String Bin) throws Exception {
            if(!isBinary(Bin)) throw new Exception("Invalid Binary input -> " + Bin);
            long temp;

            StringBuilder Hex = new StringBuilder();

            while(!(Bin.length() < 4)){
                temp = BinToDec(Bin.substring(Bin.length()-4)); // Takes last 4 length of string        Double.parseDouble( new Binary(Bin.substring(Bin.length()-4)).toDecimal().getNumber()   )
                // converts to Dec but if Dec# is > 10 it changes to letter symbol
                if(temp > 9) Hex.insert(0, (char) ('7' + temp));
                else Hex.insert(0, temp);
                Bin = Bin.substring(0,Bin.length()-4);
            }

            if(Bin.length() > 0) return BinToDec(Bin) + Hex.toString();
            return Hex.toString();

        }

        /** This method serves to divide two Binary inputs against each other,
         * the first input will be divided by the second, returning the result in a String in the
         * form of a Binary number
         *
         * @param bin1 String first binary input
         * @param bin2 String second binary input
         * @return String returns result of the division of the two binary numbers in a binary number
         */
        public static String binDivide(String bin1, String bin2)throws Exception{

            if(bin2.equals("0")) throw new Exception("You cannot divide by zero!");
            if(!isBinary(bin1)) throw new Exception("Invalid Binary input (1) \""+bin1+"\" ");
            if(!isBinary(bin2)) throw new Exception("Invalid Binary input (2) \""+bin2+"\" ");

            long remain = BinToDec(bin1) % BinToDec(bin2);
            long wholeNum = BinToDec(bin1) / BinToDec(bin2);

            if(remain == 0)
                return DecToBin(BinToDec(bin1) / BinToDec(bin2)+"");

            return DecToBin(wholeNum+"") + " Remainder: " + DecToBin(remain+"");
        }

        /** This method serves to Multiply two Binary inputs against each other,
         * the first input will be Multiplied by the second, returning the result in a String in the
         * form of a Binary number
         *
         * @param bin1 String first binary input
         * @param bin2 String second binary input
         * @return String returns result of the Multiplication of the two binary numbers in a binary number
         */
        public static String binMulti(String bin1, String bin2) throws Exception {
            if(!isBinary(bin1)) throw new Exception("Invalid Binary input (1) \""+bin1+"\" ");
            if(!isBinary(bin2)) throw new Exception("Invalid Binary input (2) \""+bin2+"\" ");
            long temp = BinToDec(bin1) * BinToDec(bin2);
            if(temp < 0) return "-" + DecToBin(temp + "");
            return DecToBin(temp + "");
        }

        /** This method serves to take in a Binary number in the form of a String and convert and return the result to
         * a Decimal number that will take a form of a Long!
         *
         * @param bin String input of a Binary number
         * @return Long returns result conversion of Binary to Decimal
         */
        public static long BinToDec(String bin) throws Exception {

            if(!isBinary(bin)) throw new Exception("Invalid Binary input -> \""+bin+"\" ");

            long result = 0;
            for(int i = bin.length()-1; i >= 0; i--){
                if(bin.charAt(i)=='1'){
                    result += Math.pow(2,bin.length() - i -1);
                }
            }
            return result;
        }

        /** This method serves to convert a String Decimal number to a binary number also in the form of a String,
         * this is done by finding the closed power of 2 associated with the binary input,
         * with this each power corresponds to a "1" in a location in the binary number which
         * the location is the number of the power. From this a Decimal to Binary conversion takes place
         *
         * @param dec String Decimal input to be converted to Binary
         * @return String returns a Binary number.
         */
        public static String DecToBin(String dec) throws Exception {

            if(!isDec(dec)) throw new Exception("Invalid Decimal input -> " + dec);

            if(dec.equals("0")) return dec;

            double count = Integer.parseInt(dec);

            ArrayList<Integer> powList = new ArrayList<>();


            while(count > 1){
                int temp = (int)    (Math.log(count) / (Math.log(2) ) ) ; // Finds a power of 2 within Dec
                count -= Math.pow(2,temp);
                powList.add(temp);

            }
            if(count == 1) powList.add(0);

            String[] binArr = new String[powList.get(0)+1];

            for (Integer x:powList) {
                binArr[powList.get(0)-x] = "1";
            }

            for(int i = 0; i < binArr.length; i++){
                if(binArr[i] == null) binArr[i] = "0";
            }

            return ArrToStr(binArr);
        }

        /** This method serves to Subtract two Binary numbers, the first Binary number get Subtracted by the second Binary number input.
         * The result of it will be a String taking the form of a Binary number. Note that if the result is negative,
         * the return String will contain a '-' dash symbol in the beginning of the String.
         *
         * @param bin1 String first Binary input
         * @param bin2 String second Binary input
         * @return String returns a Binary number that is the result of the Subtraction of two Binary numbers.
         */
        public static String binSub(String bin1, String bin2) throws Exception {
            if(!isBinary(bin1)) throw new Exception("Invalid Binary input (1) \""+bin1+"\" ");
            if(!isBinary(bin2)) throw new Exception("Invalid Binary input (2) \""+bin2+"\" ");

            long temp = BinToDec(bin1) - BinToDec(bin2);
            if(temp < 0) return  "-" + DecToBin(Math.abs(temp) + "");
            return DecToBin(temp + "");
        }

        /** This method serves to Add two binary inputs together, returning a Binary number in the form of a String.
         *
         * @param bin1 String first Binary input
         * @param bin2 String second Binary input
         * @return String returns result of the Addition of two binary numbers
         */
        public static String binAdd(String bin1, String bin2) throws Exception {
            if(!isBinary(bin1)) throw new Exception("Invalid Binary input (1) \""+bin1+"\" ");
            if(!isBinary(bin2)) throw new Exception("Invalid Binary input (2) \""+bin2+"\" ");

            return DecToBin(BinToDec(bin1) + BinToDec(bin2) + ""); // Had conversion done a different way (arrays, etc..),
            // but this way is simpler and mostly faster and more efficient.
        }

        // This method is used internally that will take a String array and one by one
        // Add what it contains into a String, returning the result.
        private static String ArrToStr(String[] StrArr){
            String str = "";

            for (String temp: StrArr) {
                str += temp;
            }

            if(str.length() > 2)
                if(str.charAt(0) == '0' && str.charAt(1) == '0')
                    str = str.substring(1);

            return str;
        }

        //Checks if input Binary
        private static boolean isBinary(String testBinary){
            boolean isSafe = true;
            for(int i = 0; i < testBinary.length(); i++)
                if(!(testBinary.charAt(i) == '0' || testBinary.charAt(i) == '1'))
                    isSafe = false;
                return isSafe;
        }

        //Checks if input Decimal
        private static boolean isDec(String testDec){

            for(int i = 0; i < testDec.length(); i++){
                if (!(testDec.charAt(i) == '0' ||
                        testDec.charAt(i) == '1'||
                        testDec.charAt(i) == '2'||
                        testDec.charAt(i) == '3'||
                        testDec.charAt(i) == '4'||
                        testDec.charAt(i) == '5'||
                        testDec.charAt(i) == '6'||
                        testDec.charAt(i) == '7'||
                        testDec.charAt(i) == '8'||
                        testDec.charAt(i) == '9'))
                    return false;
            }

            return true;
        }

        //Checks if input Hexadecimal
        private static boolean isHex(String testHex){

            for(int i = 0; i < testHex.length(); i++){
                if (!(testHex.charAt(i) == '0' ||
                        testHex.charAt(i) == '1'||
                        testHex.charAt(i) == '2'||
                        testHex.charAt(i) == '3'||
                        testHex.charAt(i) == '4'||
                        testHex.charAt(i) == '5'||
                        testHex.charAt(i) == '6'||
                        testHex.charAt(i) == '7'||
                        testHex.charAt(i) == '8'||
                        testHex.charAt(i) == '9'||
                        testHex.charAt(i) == 'A'||
                        testHex.charAt(i) == 'B'||
                        testHex.charAt(i) == 'C'||
                        testHex.charAt(i) == 'D'||
                        testHex.charAt(i) == 'E'||
                        testHex.charAt(i) == 'F'))
                    return false;
            }

            return true;
        }

    }
}
