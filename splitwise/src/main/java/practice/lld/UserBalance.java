package practice.lld;

public class UserBalance {
    private User user;
    private double balance;

    public UserBalance(User user, double balance) {
        this.user = user;
        this.balance = balance;
    }
    public User getUser() {
        return user;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
