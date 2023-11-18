import Account.Money.TypeExpenses;
import Account.Money.TypeRevenues;
import Exceptions.ExpenseException;
import User.User;
import Account.Account;
import java.util.List;
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
        boolean pivot = true;
        while(pivot){
            System.out.println(account.toString());
            System.out.println("\nIngrese 0 para detener la aplicación.");
            System.out.println("Ingrese 1 para digitar un gasto.");
            System.out.println("Ingrese 2 para digitar un ingreso.");
            System.out.println("Ingrese 3 para ver todos los gastos.");
            System.out.println("Ingrese 4 para ver todos los ingresos.");
            System.out.println("Ingrese 5 para ver los gastos por categoria.");
            System.out.println("Ingrese 6 para ver los ingresos por categoria.");
            int option = scanner.nextInt();
            if (option == 0){
                pivot = false;
            }
            if (option == 1){
                System.out.println("\nIngrese la cantidad del gasto: ");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Ingrese el tipo del gasto: ");
                String type = scanner.nextLine();
                System.out.println("Ingrese la descripción del tipo: ");
                String typeDescription = scanner.nextLine();
                TypeExpenses typeExpense = new TypeExpenses(type.toLowerCase(), typeDescription);
                System.out.println("Ingrese la descripción del gasto: ");
                String description = scanner.nextLine();
                try{
                    account.addTransaction(amount, typeExpense, null, description);
                } catch (ExpenseException e) {
                    System.out.println("\nError al agregar gasto: " + e.getMessage());
                }
            }
            if (option == 2){
                System.out.println("\nIngrese la cantidad del ingreso: ");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Ingrese el tipo del ingreso: ");
                String type = scanner.nextLine();
                System.out.println("Ingrese la descripción del tipo: ");
                String typeDescription = scanner.nextLine();
                TypeRevenues typeRevenue = new TypeRevenues(type.toLowerCase(), typeDescription);
                System.out.println("Ingrese la descripción del ingreso: ");
                String description = scanner.nextLine();
                account.addTransaction(amount, null, typeRevenue, description);
            }
            if (option == 3){
                System.out.println("\nExpenses: \n");
                List<String> result = account.getExpenses().stream()
                        .map(expense -> "\nExpenseId: " + expense.getExpenseId() + "\nAmount: " + expense.getMoney() + "\nType: " + expense.getType().getType() + "\nDescription: " + expense.getDescription() + "\nDateTime: " + expense.getDateTime())
                        .toList();
                System.out.println(result);
            }
            if (option == 4){
                System.out.println("\nRevenues: \n");
                List<String> result = account.getRevenues().stream()
                        .map(revenue -> "\nRevenueId: " + revenue.getRevenueId() + "\nAmount: " + revenue.getMoney() + "\nType: " + revenue.getType().getType() + "\nDescription: " + revenue.getDescription() + "\nDateTime: " + revenue.getDateTime())
                        .toList();
                System.out.println(result);
            }
            if (option == 5){
                System.out.println("\nTipos de Gastos: \n");
                List<String> categories = account.getTypesExpenses().stream()
                                .map(type -> "\nType: " + type.getType() + "\nDescription: " + type.getDescription())
                                        .toList();
                System.out.println(categories);
                scanner.nextLine();
                System.out.println("\nIngrese el nombre de la categoria que desea revisar: \n");
                String category = scanner.nextLine();
                List<String> result = account.getExpenses().stream()
                        .filter(expense -> expense.getType().getType().equals(category.toLowerCase()))
                        .map(expense -> "\nExpenseId: " + expense.getExpenseId() + "\nAmount: " + expense.getMoney() + "\nDescription: " + expense.getDescription() + "\nDateTime: " + expense.getDateTime())
                        .toList();
                System.out.println("\nCategory " + category + ": \n" + result);
            }
            if (option == 6){
                System.out.println("\nTipos de Ingresos: \n");
                List<String> categories = account.getTypesRevenues().stream()
                        .map(type -> "\nType: " + type.getType() + "\nDescription: " + type.getDescription())
                        .toList();
                System.out.println(categories);
                scanner.nextLine();
                System.out.println("\nIngrese el nombre de la categoria que desea revisar: \n");
                String category = scanner.nextLine();
                List<String> result = account.getRevenues().stream()
                        .filter(revenue -> revenue.getType().getType().equals(category.toLowerCase()))
                        .map(revenue -> "\nRevenueId: " + revenue.getRevenueId() + "\nAmount: " + revenue.getMoney() + "\nDescription: " + revenue.getDescription() + "\nDateTime: " + revenue.getDateTime())
                        .toList();
                System.out.println("\nCategory " + category + ": \n" + result);
            }
        }
    }
}