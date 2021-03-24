package budget;

import budget.strategies.*;
import budget.ui.AbstractOption;
import budget.ui.Menu;
import budget.ui.SimpleMenu;

import java.util.Scanner;

public class BudgetApp {

    private static final String PURCHASES_FILE = "purchases.txt";
    private static Scanner SCANNER;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            SCANNER = scanner;

            AbstractOption menu = loadDefaultMenu();
            menu.put(0, new Menu("Exit", new Exit()));

            boolean running;
            do {
                running = !"Exit".equals(AbstractOption.chooseAndCompute(menu).getOptionName());
            } while (running);
        }
    }

    public static Scanner getScanner() {
        return SCANNER;
    }

    public static AbstractOption loadCategories() {
        AbstractOption categories = new SimpleMenu("Choose the type of purchases");
        categories.put(1, new SimpleMenu("Food"));
        categories.put(2, new SimpleMenu("Clothes"));
        categories.put(3, new SimpleMenu("Entertainment"));
        categories.put(4, new SimpleMenu("Other"));

        return categories;
    }

    public static AbstractOption loadDefaultMenu() {
        AbstractOption menu = new Menu("Choose your action:");
        menu.put(1, new Menu("Add income", new AddIncomeStrategy()));
        menu.put(2, new Menu("Add purchase", new AddPurchaseStrategy()));
        menu.put(3, new Menu("Show list of purchases", new ShowPurchasesStrategy()));
        menu.put(4, new Menu("Balance", new ShowBalanceStrategy()));
        menu.put(5, new Menu("Save", new SaveStrategy()));
        menu.put(6, new Menu("Load", new LoadStrategy()));
        menu.put(7, new Menu("Analyze (Sort)", new AnalyzeStrategy()));

        return menu;
    }

    public static AbstractOption loadDefaultAnalyses() {
        AbstractOption analyses = new Menu("How do you want to sort?");
        analyses.put(1, new Menu("Sort all purchases", new SortAll()));
        analyses.put(2, new Menu("Sort by type", new SortByType()));
        analyses.put(3, new Menu("Sort certain type", new SortCertainType()));

        return analyses;
    }

    public static String getPersistenceFileName() {
        return PURCHASES_FILE;
    }
}