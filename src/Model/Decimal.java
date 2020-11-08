package Model;

import java.util.ArrayList;

public class Decimal extends Number<Decimal>{

    public Decimal(){super();}

    public Decimal(String num) {
        super(num); // Need to make sure it is actually a binary num!!
        if (!isType(num)) {
            super.setNumber("0"); // state error!
            System.out.println("ERROR: DEC IS NOW 0");
        }
    }

    public void setNumber(String setTo){
        if(isType(setTo))
            super.setNumber(setTo);
        else System.out.println("Error");
    }

    public int compare(Binary other){
        return -99; // need to convert to dec to find delta
    }

    public boolean isType(String num) {
        for (int i = 0; i < num.length(); i++) {
            if(!(num.charAt(0) == '-' ||
                    num.charAt(i) == '0' ||
                    num.charAt(i) == '1' ||
                    num.charAt(i) == '2' ||
                    num.charAt(i) == '3' ||
                    num.charAt(i) == '4' ||
                    num.charAt(i) == '5' ||
                    num.charAt(i) == '6' ||
                    num.charAt(i) == '7' ||
                    num.charAt(i) == '8' ||
                    num.charAt(i) == '9'))
                return false;
        }
        return true;
    }

    public Binary toBinary(){
        String dec = this.getNumber();
        boolean negative = false;

        if(dec.equals("0")) return new Binary();
        if(dec.charAt(0) == '-'){
            dec = dec.substring(1);
            negative = true;}


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

        if (negative)
            return new Binary("-"+ArrToStr(binArr));
        return new Binary(ArrToStr(binArr));
    }

    public Hexadecimal toHexadecimal(){
        return this.toBinary().toHexadecimal(); }


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


}
