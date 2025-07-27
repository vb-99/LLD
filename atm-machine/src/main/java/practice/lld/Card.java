package practice.lld;

public class Card {
    private final String cardNumber;
    private final String pin;
    private final Account account;

    public Card(String cardNumebr, String pin, Account account) {
        this.cardNumber = cardNumebr;
        this.pin = pin;
        this.account = account;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public String getPin() {
        return pin;
    }
    public Account getAccount() {
        return account;
    }
    public boolean validatePin(String pin) {
        return (pin.equals(this.pin));
    }



}
