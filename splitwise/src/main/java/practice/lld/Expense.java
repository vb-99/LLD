package practice.lld;

import java.util.List;
import java.util.Map;

public class Expense {
    private String id;
    private String description;
    private double amount;
    private User payer;
   private Map<User,Double> shares;
   private List<User> participants;

   public Expense(String id, String description, double amount, User payer,Map<User,Double> shares, List<User> participants,Group group) {
       this.id = id;
        this.description = description;
        this.amount = amount;
        this.payer = payer;
        this.shares = shares;
        this.participants = participants;
   }
    public Expense(String id, String description, double amount, User payer,Map<User,Double> shares,List<User> participants) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.payer = payer;
        this.shares = shares;
        this.participants = participants;
    }
   public String getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public double getAmount() {
       return amount;
    }
    public User getPayer() {
       return payer;
    }
    public Map<User,Double> getShares() {
       return shares;
    }

    public List<User> getParticipants() {
        return participants;
    }

}
