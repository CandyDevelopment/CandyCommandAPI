package fit.d6.candy.api.command;

@FunctionalInterface
public interface CommandSuggester {

    void suggests(CommandContext context, CommandArgumentHelper argument, CommandSuggestion suggestion);

}
