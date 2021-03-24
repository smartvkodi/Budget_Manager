package budget.strategies;

import budget.ui.AbstractOption;
import budget.ui.Purchase;

import java.util.List;
import java.util.stream.Collectors;

public class SortAll implements OptionAbstractStrategy {
    @Override
    public void computeStrategy(AbstractOption chosenOption) {
        List<Purchase> list = Purchase.getPurchases()
                .stream().sorted()
                .collect(Collectors.toList());

        System.out.println();
        if (list.size() == 0) {
            System.out.println("The purchase list is empty!");
        } else {
            Purchase.printSortedListWithTotal(Purchase.getPurchases(), false);
        }
    }
}