package budget.strategies;

import budget.ui.AbstractOption;

public class Exit implements OptionAbstractStrategy {
    @Override
    public void computeStrategy(AbstractOption chosenOption) {
        System.out.println("\nBye!");
    }
}