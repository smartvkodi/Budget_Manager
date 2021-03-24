package budget.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Purchase extends AbstractOption implements Comparable<Purchase> {

    String categoryName;
    double price;

    static List<Purchase> purchases = new ArrayList<>();
    private static double balance = 0;

    public Purchase(String categoryName, String name, double price) {
        super(name);
        this.categoryName = categoryName;
        this.price = price;
    }

    public static void addIncome(double income) {
        balance += income;
    }

    public double getPrice() {
        return price;
    }

    public static double getBalance() {
        return balance;
    }

    public static void addPurchase(Purchase purchase) {
        purchases.add(purchase);
        decreaseBalance(purchase.price);
    }

    private static void decreaseBalance(double price) {
        double newBalance = balance - price;
        balance = newBalance < 0 ? 0 : newBalance;
    }

    public static List<Purchase> getPurchases() {
        return purchases;
    }

    public static void setBalance(double income) {
        balance = income;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String toString() {
        return String.format("%s $%.2f", this.getOptionName(), this.price);
    }

    public static void printSortedListWithTotal(List<Purchase> purchases, boolean withTotal) {
        double total = 0;
        purchases.sort(Collections.reverseOrder());
        for (Purchase purchase : purchases) {
            total += purchase.getPrice();
            System.out.println(purchase);
        }
        if (withTotal) {
            System.out.printf("Total: $%.2f\n", total);
        }

    }

    public static List<Purchase> getCertainTypePurchasesList(String categoryName) {
        return purchases.stream()
                .filter(purchase -> purchase.getCategoryName().equals(categoryName))
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Purchase purchase) {

        double p1 = this.getPrice();
        double p2 = purchase.getPrice();

        if (p1 > p2) {
            return 1;
        } else if (p1 < p2) {
            return -1;
        } else {
            return this.getOptionName().compareTo(purchase.getOptionName());
        }
    }
}
