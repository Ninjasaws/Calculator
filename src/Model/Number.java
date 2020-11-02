package Model;

public abstract class Number <F extends Number<?>>   {
    private String value;

    // Constructors
    public Number(){ value = "0"; }
    public Number(String toUnit){
        value = toUnit;
    }


    //Getters
    public String getNumber(){
        return value;
    }

    //Setters
    public void setNumber(String setTo){
        value = setTo;
    }

    //Methods
    public String toString(){
        return value;
    }

    public boolean equals(Number other){
        return value.equals(other.value);
    }

    public int compare(Number other){
        return -99;
    }

}
