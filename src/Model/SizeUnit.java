package Model;

import java.util.HashMap;

public class SizeUnit extends Unit {//  SizeUnit is basically Byte vs KiloBytes.

    private static final HashMap<String, Integer> getIndex = new HashMap<>();
    private static final HashMap<Integer,String> getUnit = new HashMap<>();


        public SizeUnit() throws Exception {
            new SizeUnit(1,"b");
        }

        public SizeUnit(double numVal,String unitType) throws Exception {

            super(numVal,unitType);

            getIndex.put("b", 0);
            getIndex.put("B", 1);
            getIndex.put("kb", 2);
            getIndex.put("KB", 3);
            getIndex.put("mb", 4);
            getIndex.put("MB", 5);
            getIndex.put("gb", 6);
            getIndex.put("GB", 7);
            getIndex.put("tb", 8);
            getIndex.put("TB", 9);

            getUnit.put(0, "b");
            getUnit.put(1, "B");
            getUnit.put(2, "kb");
            getUnit.put(3, "KB");
            getUnit.put(4, "mb");
            getUnit.put(5, "MB");
            getUnit.put(6, "gb");
            getUnit.put(7, "GB");
            getUnit.put(8, "tb");
            getUnit.put(9, "TB");

            this.isSizeUnit();
        }

        public SizeUnit convertTo(String unit) throws Exception {

            new SizeUnit(1,unit).isSizeUnit(); // checks to see if input is valid

            double rawData = this.getVal();
            double index = getIndex.get(this.getType());
            double i = getIndex.get(unit);

            if (index % 2 == 0) {
                if ((i + index) % 2 == 0) {

                    if (i >= index)
                        return new SizeUnit( (rawData * Math.pow(0.001, (i - index) / 2)),unit);

                    else if (i < index)
                        return new SizeUnit((rawData / Math.pow(0.001, (index - i) / 2)),unit);

                } else if (Math.abs(i - index) % 2 == 1) {

                    if (i >= index)
                        return new SizeUnit( (rawData * Math.pow(0.001, (i - index - 1) / 2) * 0.125),unit);

                    else if (i < index)
                        return new SizeUnit( (rawData / Math.pow(0.001, (index - i + 1) / 2) * 0.125),unit);
                }
            } else if (index % 2 == 1) {
                if ((i + index) % 2 == 0) {

                    if (i >= index)
                        return new SizeUnit((rawData * Math.pow(0.001, (i - index) / 2)),unit);

                    else if (i < index)
                        return new SizeUnit((rawData / Math.pow(0.001, (index - i) / 2)),unit);

                } else if ((i + index) % 2 == 1) {

                    if (i >= index) {
                        return new SizeUnit( (rawData * Math.pow(0.001, (i - index - 1) / 2) * 0.008), unit);
                    }
                    else if (i < index) {
                        return new SizeUnit(((1.0 * rawData / Math.pow(0.001, ((index - i + 1) / 2))) * 0.008),unit);
                    }
                }
            } else {
                System.out.println("Error: i = " + i + " index = " + index + " data = " + this.getVal());
            }
            return new SizeUnit(6969,"b");
            }

        public void printAll() throws Exception {
            System.out.println(this.getVal() + this.getType() + " is equivalent to the following:");
            for(int i = 0; i < 10;i++){
                double sizez = convertTo(getUnit.get(i)).getVal();
                if(!getUnit.get(i).equals(this.getType())) {
                    if(sizez > 100000) System.out.print(sizez);
                    else System.out.printf("%.2f",sizez);
                    System.out.println(" ("+ getUnit.get(i) +") ");
                }
            }
        }

        private void isSizeUnit() throws Exception {
            if (this.getVal() <= 0)
                throw new Exception("numVal parameter of SizeUnit must be a number greater than 0. User Entered -> \"" + this.getVal()  + "\" " + this.getType());
            else if(!(getIndex.containsKey(this.getType())))
                throw new Exception("unitType parameter of SizeUnit is invalid, for supported unit types type \"help\". User Entered -> \"" + this.getType()  + "\" ");
        }

    @Override
    public void setType(String type) throws Exception {
            super.setType(type);
            this.isSizeUnit();
    }

    @Override
    public void setVal(double setTo) throws Exception {
        super.setVal(setTo);
        this.isSizeUnit();
    }
}
