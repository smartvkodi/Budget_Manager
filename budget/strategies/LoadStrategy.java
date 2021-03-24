package budget.strategies;

import budget.BudgetApp;
import budget.ui.AbstractOption;
import budget.ui.Purchase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadStrategy implements OptionAbstractStrategy {

    @Override
    public void computeStrategy(AbstractOption chosenOption) {

        try (Scanner scanner = new Scanner(new File(BudgetApp.getPersistenceFileName()))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(";");
                if (tokens.length == 1) {
                    Purchase.setBalance(Double.parseDouble(tokens[0]));
                } else {
                    Purchase.addPurchase(new Purchase(tokens[0], tokens[1], Double.parseDouble(tokens[2])));
                }
            }
            System.out.println("\nPurchases were loaded!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}