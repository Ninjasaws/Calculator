package Model;

import java.util.HashMap;

public class RateUnit extends Unit{// And RateUnit is bits/s vs Mbits/s?

    public static final HashMap<String,String> wordMap = new HashMap<>();

    public RateUnit() throws Exception {
        new RateUnit(1,"b");
    }

    public RateUnit(double numVal,String unitType) throws Exception {
        super(numVal,unitType);

        wordMap.put("BITS", "b");
        wordMap.put("KILOBITS", "kb");
        wordMap.put("MEGABITS", "mb");
        wordMap.put("GIGABITS", "gb");
        wordMap.put("TERABITS", "tb");
        wordMap.put("BYTES", "B");
        wordMap.put("KILOBYTES", "KB");
        wordMap.put("MEGABYTES", "MB");
        wordMap.put("GIGABYTES", "GB");
        wordMap.put("TERABYTES", "TB");
        wordMap.put("BIT/S", "b");
        wordMap.put("KBIT/S", "kb");
        wordMap.put("MBIT/S", "mb");
        wordMap.put("GBIT/S", "gb");
        wordMap.put("TBIT/S", "tb");
        wordMap.put("Bit/s", "b");
        wordMap.put("Kbit/s", "kb");
        wordMap.put("Mbit/s", "mb");
        wordMap.put("Gbit/s", "gb");
        wordMap.put("Tbit/s", "tb");


        if(wordMap.containsKey(this.getType()))
            this.setType(wordMap.get(this.getType()));

        this.isRateUnit();

    }

    public void isRateUnit() throws Exception {
        if (this.getVal() <= 0)
            throw new Exception("numVal parameter of SizeUnit must be a long greater than 0. User Entered -> \"" + this.getVal()  + "\" ");
        if(!wordMap.containsValue(this.getType()))
            throw new Exception("unitType parameter of RateUnit is invalid, for supported unit types type \"help\". User Entered -> \"" + this.getType()  + "\" ");
    }

    @Override
    public void setType(String type) throws Exception {
        super.setType(type);
        this.isRateUnit();
    }

    @Override
    public void setVal(double setTo) throws Exception {
        super.setVal(setTo);
        this.isRateUnit();
    }


}
