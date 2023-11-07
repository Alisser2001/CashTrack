import User.User;
import Account.Account;
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Luis");
        user.setEmail("Luis@gmail.com");
        boolean ok = user.setPassword("12345678A");
        Account account = new Account(user);
        System.out.println(account);
    }
}