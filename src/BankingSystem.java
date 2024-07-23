import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingSystem {
    private List<User> users;
    private Scanner scanner;

    public BankingSystem() {
        users = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        users.add(new User(username, password));
        System.out.println("Registration successful.");
    }

    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = authenticate(username, password);
        if (user != null) {
            System.out.println("Login successful.");
            manageAccounts(user);
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private void manageAccounts(User user) {
        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount(user);
                    break;
                case 2:
                    depositMoney(user);
                    break;
                case 3:
                    withdrawMoney(user);
                    break;
                case 4:
                    checkBalance(user);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createAccount(User user) {
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        String accountNumber = "ACC" + (user.getAccounts().size() + 1);
        BankAccount account = new BankAccount(accountNumber, initialBalance);
        user.addAccount(account);

        System.out.println("Account created successfully. Account Number: " + accountNumber);
    }

    private void depositMoney(User user) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        BankAccount account = findAccount(user, accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void withdrawMoney(User user) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        BankAccount account = findAccount(user, accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void checkBalance(User user) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = findAccount(user, accountNumber);
        if (account != null) {
            System.out.println("Account Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private BankAccount findAccount(User user, String accountNumber) {
        for (BankAccount account : user.getAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

}