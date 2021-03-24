package budget.ui;

import budget.strategies.OptionAbstractStrategy;

public class Menu extends AbstractOption {

    public Menu(String name) {
        super(name);
    }

    public Menu(String name, OptionAbstractStrategy abstractStrategy) {
        super(name);
        this.optionAbstractStrategy = abstractStrategy;
    }
}
