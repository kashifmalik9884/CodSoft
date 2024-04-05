import java.util.HashMap;
import java.util.Scanner;

class ATM {
    public double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    Scanner sc = new Scanner(System.in);

    
    public void transaction(){
        System.out.print("Enter Your Account Balance = ");
        double bal = sc.nextDouble();
        setBalance(bal);
        System.out.println("<------Enter Your Transaction Type------>");
        System.out.print("1. Withdraw Balance\n2. Deposit Balance\n3. Check Balance\n4. Exit\n = ");
        int transactionType = sc.nextInt();
        if (transactionType == 1) {
            withdraw();
        } else if (transactionType == 2) {
            deposit();
        } else if (transactionType == 3) {
            checkBalance();
        } else if (transactionType == 4) {
            System.out.println("Thank You For Your Time...");
            return;
        } else {
            System.out.println("Invalid Input!!!");
        }
    }
    public void deposit() {
        System.out.print("Enter Your Amount For Deposit = ");
        double depositMoney = sc.nextDouble();
        balance += depositMoney;
        System.out.println("Transaction Successful...");
        System.out.println("Avaiable Balance = " + balance);

    }

    public void withdraw() {
        System.out.print("Enter The Amount For Withdrawl = ");
        double withdrawMoney = sc.nextDouble();
        if (withdrawMoney <= balance) {
            balance -= withdrawMoney;
            System.out.println("Transaction Successful...");
            System.out.println("Avaiable Balance = " + balance);
        }
        else{
            System.out.println("Transaction Failed!!!");
            System.out.println("Insufficient Balance!!!");
        }

    }

    public void checkBalance() {
        System.out.println("Available Balance = " +getBalance());
    }
}

public class Task3_Atm_Interface {

    public static void cardCheck(long newCard, HashMap<Long, Integer> cardList, int pin) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        if (cardList.containsKey(newCard)) {
            return;
        } else {
            System.out.println("Card Not Exist!!");
            System.out.print("You Want To Store This Card = ");
            String choice = sc.next();
            if (choice.equals("yes")) {
                cardList.put(newCard, pin);
                System.out.println("Card Added Successfully...");
                atm.transaction();
            }
            else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        HashMap<Long, Integer> cardList = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();
        System.out.print("Enter Your Card Number = ");
        long newCard = sc.nextLong();
        System.out.print("Enter Your Pin = ");
        int pin = sc.nextInt();
        
        cardCheck(newCard, cardList, pin);
    }
}