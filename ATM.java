import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class ATM {
  // HashMap to store the users and their balance
  private static HashMap<String, Double> users = new HashMap<>();
  
  // HashMap to store the transaction history for each user
  private static HashMap<String, ArrayList<String>> transactions = new HashMap<>();

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean quit = false;
    String username = "";

    while (!quit) {
      System.out.println("1. Register");
      System.out.println("2. Login");
      System.out.println("3. Quit");
      System.out.print("Enter your choice: ");
      int choice = input.nextInt();
      input.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Enter a username: ");
          String newUsername = input.nextLine();
          System.out.print("Enter a starting balance: ");
          double startingBalance = input.nextDouble();
          users.put(newUsername, startingBalance);
          transactions.put(newUsername, new ArrayList<>());
          System.out.println("Registration successful!");
          break;
        case 2:
          System.out.print("Enter your username: ");
          username = input.nextLine();
          if (users.containsKey(username)) {
            System.out.println("Login successful!");
            boolean loggedIn = true;
            while (loggedIn) {
              System.out.println("1. View transaction history");
              System.out.println("2. Withdraw money");
              System.out.println("3. Deposit money");
              System.out.println("4. Transfer money");
              System.out.println("5. Quit");
              System.out.print("Enter your choice: ");
              int option = input.nextInt();
              input.nextLine();

              switch (option) {
                case 1:
                  System.out.println("Transaction history: ");
                  ArrayList<String> history = transactions.get(username);
                  for (String transaction : history) {
                    System.out.println(transaction);
                  }
                  break;
                case 2:
                  System.out.print("Enter amount to withdraw: ");
                  double amount = input.nextDouble();
                  double balance = users.get(username);
                  if (balance >= amount) {
                    users.put(username, balance - amount);
                    transactions.get(username).add("Withdrawal: " + amount);
                    System.out.println("Withdrawal successful!");
                  } else {
                    System.out.println("Insufficient balance!");
                  }
                  break;
                case 3:
                  System.out.print("Enter amount to deposit: ");
                  amount = input.nextDouble();
                  balance = users.get(username);
                  users.put(username, balance + amount);
                  transactions.get(username).add("Deposit: " + amount);
                  System.out.println("Deposit successful!");
                  break;
                case 4:
                  System.out.print("Enter recipient username: ");
                  String recipient = input.nextLine();
                  if (users.containsKey(recipient)) {
                    System.out.print("Enter amount to transfer: ");
                    amount = input.nextDouble();
                    balance = users.get(username);
                    if (balance >= amount) {
                      double recipientBalance = users.get(recipient);
                      users.put(username, balance - amount);
                      users.put(recipient, recipientBalance + amount);
                      transactions.get(username).add("Transfer to " + recipient + ": " + amount);
                      transactions.get(recipient).add("Received from " + username + ": " + amount);
                      System.out.println("Transfer successful!");
                    } else {
                      System.out.println("Insufficient balance!");
                    }
                  } else {
                    System.out.println("Recipient not found!");
                  }
                  break;
                case 5:
                  loggedIn = false;
                  break;
              }
            }
          } else {
            System.out.println("User not found!");
          }
          break;
        case 3:
          quit = true;
          break;
      }
    }
  }
}




