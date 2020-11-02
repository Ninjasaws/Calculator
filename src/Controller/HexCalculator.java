package Controller;

import Model.Hexadecimal;

public class HexCalculator extends Calculator<Hexadecimal> {
    public HexCalculator(Hexadecimal Obj) {
        super(Obj);
    }

    public Hexadecimal Add(Hexadecimal other){
        return new DecimalCalculator(this.getObj().toDecimal()).Add(other.toDecimal()).toHexadecimal();
    }

    public Hexadecimal Subtract(Hexadecimal other){
        return new DecimalCalculator(this.getObj().toDecimal()).Subtract(other.toDecimal()).toHexadecimal();
    }

    public Hexadecimal Multiply(Hexadecimal other){
        return new DecimalCalculator(this.getObj().toDecimal()).Multiply(other.toDecimal()).toHexadecimal();
    }

    public Hexadecimal Divide(Hexadecimal other){
        return new DecimalCalculator(this.getObj().toDecimal()).Divide(other.toDecimal()).toHexadecimal();
    }

    public Hexadecimal Modulus(Hexadecimal other){
        return new DecimalCalculator(this.getObj().toDecimal()).Modulus(other.toDecimal()).toHexadecimal();
    }

}
