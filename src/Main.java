import Account.Money.Expense;
import Account.Money.Revenue;
import Account.Money.TypeExpenses;
import Exceptions.ExpenseException;
import User.User;
import Account.Account;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws ExpenseException {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.print("\nIngrese el usuario: ");
        String username = scanner.nextLine();
        user.setName(username);
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine();
        user.setEmail(email);
        boolean auth = false;
        while(!auth){
            System.out.print("Ingrese la contraseña: ");
            String password = scanner.nextLine();
            auth = user.setPassword(password);
        }
        Account account = new Account(user);
        System.out.println(account.toString());
        boolean pivot = true;
        while(pivot){
            System.out.println("\nIngrese 1 para digitar un gasto.");
            System.out.println("Ingrese 2 para digitar un ingreso.");
            System.out.println("Ingrese 3 para ver todos los gastos.");
            System.out.println("Ingrese 4 para ver todos los ingresos.");
            int option = scanner.nextInt();
            if (option == 1){
                System.out.println("\nIngrese la cantidad del gasto: ");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Ingrese el tipo del gasto: ");
                String type = scanner.nextLine();
                System.out.println("Ingrese la descripción del tipo: ");
                String typeDescription = scanner.nextLine();
                TypeExpenses typeExpense = new TypeExpenses(type, typeDescription);
                System.out.println("Ingrese la descripción del gasto: ");
                String description = scanner.nextLine();
                account.addExpense(amount, typeExpense, description);
            }
            if (option == 2){
                System.out.println("\nIngrese la cantidad del ingreso: ");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Ingrese la descripción del ingreso: ");
                String description = scanner.nextLine();
                account.addRevenue(amount, description);
            }
            if (option == 3){
                System.out.println("\nExpenses: ");
                System.out.println(account.getExpenses());
            }
            if (option == 4){
                System.out.println("\nRevenues: ");
                System.out.println(account.getRevenues());
            }
            System.out.println("\nSi desea parar el programa ingrese 0, de otra forma ingrese 1: ");
            int condition = scanner.nextInt();
            pivot = condition == 0 ? false : true;
        }
    }
}