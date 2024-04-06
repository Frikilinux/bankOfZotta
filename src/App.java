import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Client account
        String userName = "Ricardo Fort";
        String accountType = "Corriente";
        double balance = 1599.99;

        System.out.println("====================================\n");
        System.out.println("Usuario: " + userName);
        System.out.println("Tipo de cuenta: " + accountType);
        System.out.println("Saldo: $ " + balance);
        System.out.println("\n====================================\n");

        String menu = """
                ====      BANK of ZOTTA      ====
                === Escribe la opción deseada ===

                1 - Consultar saldo
                2 - Retiro
                3 - Depósito
                9 - Salir
                    """;

        int option = 0;
        Scanner input = new Scanner(System.in);

        String balanceUpdated = "\n=== Saldo actual: $ %.2f ===\n";

        while (option != 9) {
            System.out.println(menu);
            System.out.print("> ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println(String.format(balanceUpdated, balance));
                    break;
                case 2:
                    System.out.print("Monto a retirar: $ ");
                    double withdraw = input.nextDouble();

                    if (balance < withdraw) {
                        System.out.println("\n*** Fondos insuficientes ***");
                        System.out.println(String.format(balanceUpdated, balance));

                    } else {
                        balance -= withdraw;
                        System.out.println(String.format(balanceUpdated, balance));
                    }
                    break;

                case 3:
                    System.out.print("Monto a deṕósitar: $ ");
                    double deposit = input.nextDouble();
                    balance += deposit;
                    System.out.println(String.format(balanceUpdated, balance));
                    break;

                case 9:
                    System.out.println("\nGracias por operar en BoZ, hasta pronto.\n");
                    break;

                default:
                    System.out.println("Opción no disponible");
                    break;
            }
        }

        input.close();
    }
}
