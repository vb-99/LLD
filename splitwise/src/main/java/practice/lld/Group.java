package practice.lld;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    private String id;
    private String name;
    private String description;
    private List<User> users;
    private List<Expense> expenses;

    public Group(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public List<User> getUsers() {
        return users;
    }
    public List<Expense> getExpenses() {
        return expenses;
    }
    public void addUser(User user) {
        users.add(user);
    }
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
    public void removeUser(User user) {
        users.remove(user);
    }
    public void removeExpense(Expense expense) {
        expenses.remove(expense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id.equals(group.id);
    }
    public boolean isUserInGroup(User user) {
        return users.contains(user);
    }


}
