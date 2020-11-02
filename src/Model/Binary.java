package Model;

public class Binary extends Number<Binary> {

    public Binary(){super();}

    public Binary(String num){
        super(num); // Need to make sure it is actually a binary num!!
        if (!isType(num)) {
            super.setNumber("0"); // state error!
            System.out.println("ERROR: Binary IS NOW 0");
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

    public boolean isType(String num){
        boolean isSafe = true;
        for(int i = 0; i < num.length(); i++)
            if(!(num.charAt(i) == '0' || num.charAt(i) == '1'))
                isSafe = false;
        return isSafe;
    }

    public Decimal toDecimal(){
        String temp = this.getNumber();

        long result = 0;
        for(int i = temp.length()-1; i >= 0; i--){
            if(temp.charAt(i)=='1'){
                result += Math.pow(2,temp.length() - i -1);
            }
        }

        return new Decimal(result+"");
    }

    public Hexadecimal toHexadecimal(){

        String Bin = this.getNumber(); // 01101011111101001000001

        long temp;

        StringBuilder Hex = new StringBuilder();

        while(!(Bin.length() < 4)){
            temp = Long.parseLong( new Binary(Bin.substring(Bin.length()-4)).toDecimal().getNumber()   ); // Takes last 4 length of string              (new Decimal(Bin.substring(Bin.length()-4))).getNumber();
            // converts to Dec but if Dec# is > 10 it changes to letter symbol
            if(temp > 9) Hex.insert(0, (char) ('7' + temp));
            else Hex.insert(0, temp);
            Bin = Bin.substring(0,Bin.length()-4);
        }

        if(Bin.length() > 0) return new Hexadecimal ((new Binary( Bin).toDecimal() ) + Hex.toString());
        return new Hexadecimal(Hex.toString());
    }

}
