package Controller;


import Model.Number;
import Controller.Convertable;

public abstract class Calculator<F extends Number<F>>  implements Convertable {

    private F Obj;

    public Calculator(){
        this.Obj = Obj;
    }

    public F getObj(){
        return this.Obj;
    }

    public void Add(){}
    public void Subtract(){}
    public void Divide(){}
    public void Multiply(){}
}
