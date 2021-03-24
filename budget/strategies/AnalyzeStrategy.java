package budget.strategies;

import budget.BudgetApp;
import budget.ui.AbstractOption;
import budget.ui.SimpleMenu;

public class AnalyzeStrategy implements OptionAbstractStrategy {
    @Override
    public void computeStrategy(AbstractOption chosenOption) {

        AbstractOption analyses = BudgetApp.loadDefaultAnalyses();
        analyses.add(new SimpleMenu("Back"));

        do {
            if ("Back".equals(AbstractOption.chooseAndCompute(analyses).getOptionName())) {
                break;
            }
        } while (true);
    }
}