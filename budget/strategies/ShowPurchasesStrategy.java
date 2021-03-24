package budget.strategies;

import budget.BudgetApp;
import budget.ui.AbstractOption;
import budget.ui.Purchase;
import budget.ui.SimpleMenu;

import java.util.List;

public class ShowPurchasesStrategy implements OptionAbstractStrategy {

    @Override
    public void computeStrategy(AbstractOption chosenOption) {

        AbstractOption categories = BudgetApp.loadCategories();
        categories.add(new SimpleMenu("All"));
        categories.add(new SimpleMenu("Back"));

        String categoryName;
        do {
            List<Purchase> purchases;
            categoryName = AbstractOption.chooseAndCompute(categories).getOptionName();

            if ("Back".equals(categoryName)) {
                break;
            } else if (!"All".equals(categoryName)) {
                purchases = Purchase.getCertainTypePurchasesList(categoryName);
            } else {
                purchases = Purchase.getPurchases();
            }

            System.out.println("\n" + categoryName + ":");
            if (purchases.size() == 0) {
                System.out.println("\nThe purchase list is empty!");
            } else {
                Purchase.printSortedListWithTotal(purchases, true);
            }
        } while (true);
    }
}
