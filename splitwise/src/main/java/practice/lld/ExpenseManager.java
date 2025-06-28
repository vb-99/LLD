package practice.lld;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager implements ExpenseObserver {
    private List<ExpenseObserver> observers;
    private List<Expense> expenses;

    public ExpenseManager() {
        observers = new ArrayList<>();
        expenses = new ArrayList<>();
    }

    public void addObserver(ExpenseObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(ExpenseObserver observer) {
        observers.remove(observer);
    }
    public void notifyExpenseAdded(Expense expense) {
        for (ExpenseObserver observer : observers) {
            observer.onExpenseAdded(expense);
        }
    }
    public void notifyExpenseUpdated(Expense expense) {
        for (ExpenseObserver observer : observers) {
            observer.onExpenseUpdated(expense);
        }
    }
    public void addExpense(Expense expense) {
        expenses.add(expense);
        notifyExpenseAdded(expense);
    }
    public void updateExpense(Expense expense) {
       for(int i=0;i<expenses.size();i++){
           if(expenses.get(i).getId() == expense.getId()){
               expenses.set(i,expense);
               notifyExpenseUpdated(expense);
           }
       }
    }
    public List<Expense> getExpenses() {
        return new ArrayList<>(expenses);
    }

    @Override
    public void onExpenseAdded(Expense expense) {
        System.out.println("Expense added: " + expense);
    }

    @Override
    public void onExpenseUpdated(Expense expense) {
        System.out.println("Expense updated: " + expense);

    }
}
