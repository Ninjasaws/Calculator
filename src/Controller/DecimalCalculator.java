package Controller;

import Model.Decimal;

public class DecimalCalculator extends Calculator<Decimal> {


    public Decimal Add(Decimal other) {
        return new Decimal(Double.parseDouble(this.getObj().getNumber()) + Double.parseDouble(other.getNumber())+"");
    }

}
