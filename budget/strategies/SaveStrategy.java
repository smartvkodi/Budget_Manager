package budget.strategies;

import budget.BudgetApp;
import budget.ui.AbstractOption;
import budget.ui.Purchase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveStrategy implements OptionAbstractStrategy {

    @Override
    public void computeStrategy(AbstractOption chosenOption) {

        try ( BufferedWriter bufferedWriter =
                      new BufferedWriter(new FileWriter(BudgetApp.getPersistenceFileName()))){
            bufferedWriter.write("");

            for (Purchase purchase :  Purchase.getPurchases()) {
                bufferedWriter.append(purchase.getCategoryName()).append(';')
                        .append(purchase.getOptionName()).append(';')
                        .append(String.valueOf(purchase.getPrice()))
                        .append("\n");
            }

            bufferedWriter.append(String.valueOf(Purchase.getBalance()));
            bufferedWriter.write("\n");
            System.out.println("\nPurchases were saved!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}