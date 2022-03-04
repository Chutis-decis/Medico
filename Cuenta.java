public class Cuenta {

    private String titular;
    private double ingresar;

    public Cuenta(String titular) {
        this.titular = titular;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getIngresar() {
        return ingresar;
    }

    public void setIngresar(double ingresar) {
        this.ingresar = ingresar;
    }

    public static double Ingresar (double cantidad){
        if (cantidad <= 0){
            System.out.println("Ingresa una cantidad Positiva");
        }
        else{

        }
        return  cantidad;
    }
    public static double Retirar (double cantidad){
        return cantidad;
    }

    @Override
    public String toString(){
        return "Titular " + titular + " Ingreso " + ingresar;
    }
}
