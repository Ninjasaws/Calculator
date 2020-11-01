package Model;

public abstract class Number {
    private String value;

    public Number(){
        value = "0";
    }

    public Number(String toUnit){
        value = toUnit;
    }

    public String toString(){
        return value;
    }

    public String getNumber(){
        return value;
    }

    public void setNumber(String setTo){
        value = setTo;
    }

    public boolean equals(Number other){
        return value.equals(other.value);
    }

    public boolean isType(){
        return false;
    }
}
