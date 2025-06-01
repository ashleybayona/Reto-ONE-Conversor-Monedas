import api.ApiClient;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ApiClient api = new ApiClient();
        int opcion = 0;
        double amount = 0.0, conversion  = 0.0;
        String base ="", target ="";

        do {
            System.out.println("\n\n*************************************************");
            System.out.println("\t Bienvenido al Conversor de Monedas");
            System.out.println("*************************************************");
            System.out.println("1. Dolar -> Sol peruano");
            System.out.println("2. Sol peruano -> Dolar");
            System.out.println("3. Euro -> Sol peruano");
            System.out.println("4. Sol peruano -> Euro");
            System.out.println("5. Yen japones -> Sol peruano");
            System.out.println("6. Sol peruano -> Yen japones");
            System.out.println("7. Salir");
            System.out.print("Elija una opcion: ");
            opcion = sc.nextInt();
            System.out.println("*************************************************");

            if(opcion != 7) {
                System.out.print("Ingrese el valor que desea convertir: ");
                amount = sc.nextDouble();
                System.out.println("*************************************************");
            }

            switch (opcion) {
                case 1:
                    base = "USD";
                    target = "PEN";
                    conversion = api.convertir(base, target, amount);
                    break;
                case 2:
                    base = "PEN";
                    target = "USD";
                    conversion = api.convertir(base, target, amount);
                    break;
                case 3:
                    base = "EUR";
                    target = "PEN";
                    conversion = api.convertir(base, target, amount);
                    break;
                case 4:
                    base = "PEN";
                    target = "EUR";
                    conversion = api.convertir(base, target, amount);
                    break;
                case 5:
                    base = "JPY";
                    target = "PEN";
                    conversion = api.convertir(base, target, amount);
                    break;
                case 6:
                    base = "PEN";
                    target = "JPY";
                    conversion = api.convertir(base, target, amount);
                    break;
                case 7:
                    System.out.println("Cerrando sistema...");
                    System.out.println("*************************************************\n\n");
                    break;
                default:
                    break;
            }

            if (opcion != 7) {
                System.out.println(amount + " " + base + " -> " + conversion + " " + target);
                System.out.println("*************************************************");
            }

        } while (opcion != 7);
    }
}
