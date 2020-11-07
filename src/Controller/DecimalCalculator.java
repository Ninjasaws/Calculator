package Controller;

import Model.Decimal;

public class DecimalCalculator extends Calculator<Decimal> {


    public DecimalCalculator(Decimal val) {
        super(val);
    }

    public Decimal Add(Decimal other) {
        return new Decimal((Integer.parseInt(this.getObj().getNumber()) + Integer.parseInt(other.getNumber()))+"");
    }

    public Decimal Subtract(Decimal other) {
        return new Decimal(Integer.parseInt(this.getObj().getNumber()) - Integer.parseInt(other.getNumber())+"");
    }

    public Decimal Multiply(Decimal other) {
        return new Decimal(Integer.parseInt(this.getObj().getNumber()) * Integer.parseInt(other.getNumber())+"");
    }

    public Decimal Divide(Decimal other) {
        return new Decimal(Integer.parseInt(this.getObj().getNumber()) / Integer.parseInt(other.getNumber())+"");
    }

    public Decimal Modulus(Decimal other) {
        return new Decimal(Integer.parseInt(this.getObj().getNumber()) % Integer.parseInt(other.getNumber())+"");
    }

}
