package Controller;


import Model.Number;

public abstract class Calculator<F extends Number<F>> implements Convertible {

    private F Obj;

    public Calculator(F Obj){
        this.Obj = Obj;
    }

    public F getObj(){
        return this.Obj;
    }

    public abstract F Add(F Obj);
    public abstract F Subtract(F Obj);
    public abstract F Divide(F Obj);
    public abstract F Multiply(F Obj);
}
