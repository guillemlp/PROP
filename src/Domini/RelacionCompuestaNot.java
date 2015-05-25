package Domini;

public class RelacionCompuestaNot extends RelacionCompuesta {

    public RelacionCompuestaNot(Relacion a) {
        super(a);
    }

    //No tiene relacion B---> excepcion
    public void modRelacionB(Relacion b)throws Exception {
        throw new Exception("Relacion Not no contiene Relacion B");
    }
    public Relacion obtRelacionB() throws Exception {
        throw new Exception("Relacion Not no contiene Relacion B");
    }

    public boolean esOr() {
        return false;
    }
    public boolean esNot() {
        return true;
    }

    public String toString() {
        return " NOT ["+super.toString()+"]";
    }
}
