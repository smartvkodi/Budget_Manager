package budget.ui;

import budget.BudgetApp;
import budget.strategies.OptionAbstractStrategy;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractOption {

    String name;
    Map<Integer, AbstractOption> options = new LinkedHashMap<>();
    OptionAbstractStrategy optionAbstractStrategy;

    public AbstractOption(String name) {
        this.name = name;
    }

    public String getOptionName() {
        return this.name;
    }

    public void put(int key, AbstractOption option) {
        options.putIfAbsent(key, option);
    }

    public void add(AbstractOption option) {
        options.putIfAbsent(options.size() + 1, option);
    }

    public void printOptions() {
        System.out.println("\n" + name);
        for (Map.Entry<Integer, AbstractOption> optionEntry : this.options.entrySet()) {
            System.out.printf("%d) %s\n", optionEntry.getKey(), optionEntry.getValue().name);
        }
    }

    public AbstractOption chooseOption() {

        AbstractOption optionResult = null;

        try {
            int key = Integer.parseInt(BudgetApp.getScanner().nextLine());
            if (options.containsKey(key))
                optionResult = options.get(key);
        } catch (NumberFormatException e) {
            // don't worry
        }

        if (optionResult != null && optionResult.optionAbstractStrategy != null) {
            optionResult.optionAbstractStrategy.computeStrategy(optionResult);
        }

        return optionResult;
    }

    public static AbstractOption chooseAndCompute(AbstractOption option) {
        AbstractOption optionResult;
        do {
            option.printOptions();
            optionResult = option.chooseOption();
        } while (optionResult == null);

        return optionResult;
    }

    public Map<Integer, AbstractOption> getOptions() {
        return options;
    }
}
