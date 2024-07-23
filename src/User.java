import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<BankAccount> accounts;

    public User (String username, String password) {
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }
    public String getPassword(){
        return password;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(BankAccount account){
        accounts.add(account);
    }
}
