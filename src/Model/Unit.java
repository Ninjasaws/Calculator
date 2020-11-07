package Model;

import java.util.HashMap;

public class Unit {

    private double val;
    private String type;



    public Unit(){
        val = 0;
        type = "";
    }

    public Unit(double val, String define){
        this.val = val;
        type = define;
    }

    public double getVal(){
        return val;
    }

    public String getType(){
        return type;
    }

    public void setType(String type) throws Exception {
        this.type = type;
    }

    public void setVal(double setTo) throws Exception {
        val = setTo;
    }

    public String toString(){
        return val + " " + type;
    }

}

