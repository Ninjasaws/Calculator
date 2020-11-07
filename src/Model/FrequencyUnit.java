package Model;

import java.util.HashMap;

public class FrequencyUnit extends Unit {//FrequencyUnit is per second vs per month.



    public static final HashMap <String, Double> getTime = new HashMap<>();

    public FrequencyUnit(){
        new FrequencyUnit(60,"seconds");
    }

    public FrequencyUnit(double num,String time){
        super(num,time.toUpperCase());

        getTime.put("YEAR", 3.15576e7);
        getTime.put("MONTH", 2629800.0);
        getTime.put("WEEK", 604800.0);
        getTime.put("DAY", 86400.0);
        getTime.put("HOUR", 3600.0);
        getTime.put("MINUTE", 60.0);
        getTime.put("SECOND", 1.0);
    }

    public void isFrequencyUnit() throws Exception {
        if(!getTime.containsKey(this.getType()))
            throw new Exception("Time parameter of FrequencyUnit is invalid, for supported unit types type \"help\". User Entered -> \"" + this.getType()  + "\" ");
    }

    @Override
    public void setType(String type) throws Exception {
        super.setType(type);
        this.isFrequencyUnit();
    }

    @Override
    public void setVal(double setTo) throws Exception {
        super.setVal(setTo);
        this.isFrequencyUnit();
    }

}




























