import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingresa el nombre del Titular: ");
        String titu = sc.nextLine();
        System.out.println("Saldo inicial: ");
        double ingresar  = sc.nextDouble();
        Cuenta cuenta = new Cuenta(titu);

        cuenta.setIngresar(ingresar);
        cuenta.setTitular(titu);


        System.out.println("Su saldo actual es de: " + cuenta.getIngresar());
        System.out.println("El titula es: " + cuenta.getTitular());
    }
}
