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

}
