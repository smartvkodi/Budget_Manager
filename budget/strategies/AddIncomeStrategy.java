package budget.strategies;

import budget.BudgetApp;
import budget.ui.AbstractOption;
import budget.ui.Purchase;

public class AddIncomeStrategy implements OptionAbstractStrategy {
    @Override
    public void computeStrategy(AbstractOption chosenOption) {
        System.out.println("\nEnter income:");

        double income = Double.parseDouble(BudgetApp.getScanner().nextLine());
        Purchase.addIncome(income);
        System.out.println("Income was added!");
    }
}