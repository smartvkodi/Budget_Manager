package budget.strategies;

import budget.BudgetApp;
import budget.ui.AbstractOption;
import budget.ui.Purchase;
import budget.ui.SimpleMenu;

public class AddPurchaseStrategy implements OptionAbstractStrategy {

    @Override
    public void computeStrategy(AbstractOption chosenOption) {

        AbstractOption categories = BudgetApp.loadCategories();
        categories.add(new SimpleMenu("Back"));

        do {
            String categoryName = AbstractOption.chooseAndCompute(categories).getOptionName();

            if ("Back".equals(categoryName)) {
                break;
            } else {
                String purchaseName = "";
                while (purchaseName.isEmpty() || !purchaseName.matches(".*[a-zA-Z]+.*")) {
                    System.out.println("\nEnter purchase name:");
                    purchaseName = BudgetApp.getScanner().nextLine();
                }

                double purchasePrice = -1;
                while (purchasePrice < 0) {
                    System.out.println("Enter its price:");
                    String consoleInput = BudgetApp.getScanner().nextLine();
                    try {
                        purchasePrice = Double.parseDouble(consoleInput);
                    } catch (Exception e) {
                        System.out.println("Please, provide the purchase price!");
                    }
                }

                Purchase.addPurchase(new Purchase(categoryName, purchaseName, purchasePrice));
            }
        } while (true);
    }
}