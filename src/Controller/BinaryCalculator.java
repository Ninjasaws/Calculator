package Controller;

import Model.Binary;
import Model.Decimal;
import Model.Hexadecimal;

public class BinaryCalculator extends Calculator<Binary> {

    public BinaryCalculator(Binary val) {
        super(val);
    }

    public Binary Add(Binary other){
        return new DecimalCalculator(this.getObj().toDecimal()).Add(other.toDecimal()).toBinary();
    }

    public Binary Subtract(Binary other){
        return new DecimalCalculator(this.getObj().toDecimal()).Subtract(other.toDecimal()).toBinary();
    }

    public Binary Multiply(Binary other){
        return new DecimalCalculator(this.getObj().toDecimal()).Multiply(other.toDecimal()).toBinary();
    }

    public Binary Divide(Binary other){
        return new DecimalCalculator(this.getObj().toDecimal()).Divide(other.toDecimal()).toBinary();
    }

    public Binary Modulus(Binary other){
        return new DecimalCalculator(this.getObj().toDecimal()).Modulus(other.toDecimal()).toBinary();
    }

}
