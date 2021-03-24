package budget.strategies;

import budget.BudgetApp;
import budget.ui.Purchase;
import budget.ui.AbstractOption;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortByType implements OptionAbstractStrategy {

    @Override
    public void computeStrategy(AbstractOption chosenOption) {

        List<String> categories = BudgetApp.loadCategories().getOptions().values()
                .stream().map(AbstractOption::getOptionName).collect(Collectors.toList());

        System.out.println();
        List<Purchase> list = new ArrayList<>();
        for (String categoryName : categories) {
            double total = Purchase.getCertainTypePurchasesList(categoryName).stream()
                    .map(Purchase::getPrice)
                    .reduce(0d, Double::sum);

            Purchase purchase =
                    new Purchase(null, String.format("%s -", categoryName), total);
            list.add(purchase);
        }
        Purchase.printSortedListWithTotal(list, false);
    }
}