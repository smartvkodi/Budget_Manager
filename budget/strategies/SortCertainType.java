package budget.strategies;

import budget.BudgetApp;
import budget.ui.AbstractOption;
import budget.ui.Purchase;

import java.util.List;

public class SortCertainType implements OptionAbstractStrategy {

    @Override
    public void computeStrategy(AbstractOption chosenOption) {

        AbstractOption categories = BudgetApp.loadCategories();
        String categoryName = AbstractOption.chooseAndCompute(categories).getOptionName();

        List<Purchase> list = Purchase.getCertainTypePurchasesList(categoryName);

        System.out.println();
        if (list.size() == 0) {
            System.out.println("The purchase list is empty!");
        } else {
            System.out.println(categoryName + ":");
            Purchase.printSortedListWithTotal(list, false);
        }
    }
}