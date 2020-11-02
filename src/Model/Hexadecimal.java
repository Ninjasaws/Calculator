package Model;

public class Hexadecimal extends Number<Hexadecimal> {

    public Hexadecimal(){super();}

    public Hexadecimal(String num){
        super(num); // Need to make sure it is actually a binary num!!
        if (!isType(num)) {
            super.setNumber("0"); // state error!
            System.out.println("ERROR: HEX IS NOW 0");
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
        for(int i = 0; i < num.length(); i++){
            if (!(num.charAt(i) == '0' ||
                    num.charAt(i) == '1'||
                    num.charAt(i) == '2'||
                    num.charAt(i) == '3'||
                    num.charAt(i) == '4'||
                    num.charAt(i) == '5'||
                    num.charAt(i) == '6'||
                    num.charAt(i) == '7'||
                    num.charAt(i) == '8'||
                    num.charAt(i) == '9'||
                    num.charAt(i) == 'A'||
                    num.charAt(i) == 'B'||
                    num.charAt(i) == 'C'||
                    num.charAt(i) == 'D'||
                    num.charAt(i) == 'E'||
                    num.charAt(i) == 'F'))
                return false;
        }

        return true;
    }

}
