import java.util.*;
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
public class BankTransactionSystem{
    static double balance=1000.0;
    static void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        } else if (amount > balance){
            throw new InsufficientBalanceException("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful, new balance: " + balance);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double amount=sc.nextDouble();
        try {
            withdraw(amount);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch(InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
