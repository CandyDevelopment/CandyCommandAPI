package fit.d6.candy.command.nms.v1_20;

import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import fit.d6.candy.api.command.CommandSuggestion;
import io.papermc.paper.adventure.PaperAdventure;
import net.kyori.adventure.text.Component;

public class CommandSuggestionV1_20 implements CommandSuggestion {

    private final SuggestionsBuilder suggestionsBuilder;

    public CommandSuggestionV1_20(SuggestionsBuilder suggestionsBuilder) {
        this.suggestionsBuilder = suggestionsBuilder;
    }

    @Override
    public String getInput() {
        return this.suggestionsBuilder.getInput();
    }

    @Override
    public int getStart() {
        return this.suggestionsBuilder.getStart();
    }

    @Override
    public String getRemaining() {
        return this.suggestionsBuilder.getRemaining();
    }

    @Override
    public CommandSuggestion suggests(String value) {
        this.suggestionsBuilder.suggest(value);
        return this;
    }

    @Override
    public CommandSuggestion suggests(String value, Component tooltip) {
        this.suggestionsBuilder.suggest(value, PaperAdventure.asVanilla(tooltip));
        return this;
    }

    @Override
    public CommandSuggestion suggests(int value) {
        this.suggestionsBuilder.suggest(value);
        return this;
    }

    @Override
    public CommandSuggestion suggests(int value, Component tooltip) {
        this.suggestionsBuilder.suggest(value, PaperAdventure.asVanilla(tooltip));
        return this;
    }

}
