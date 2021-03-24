package budget.strategies;

import budget.ui.AbstractOption;
import budget.ui.Purchase;

public class ShowBalanceStrategy implements OptionAbstractStrategy {

    @Override
    public void computeStrategy(AbstractOption chosenOption) {
        System.out.printf("\nBalance: $%.2f\n", Purchase.getBalance());
    }
}