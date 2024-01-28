package fit.d6.candy.api.command;

import net.kyori.adventure.text.Component;

public interface CommandSuggestion {

    String getInput();

    int getStart();

    String getRemaining();

    CommandSuggestion suggests(String value);

    CommandSuggestion suggests(String value, Component tooltip);

    CommandSuggestion suggests(int value);

    CommandSuggestion suggests(int value, Component tooltip);

}
