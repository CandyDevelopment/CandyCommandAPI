package fit.d6.candy.api.command;

public interface CommandBuilder extends CommandNode {

    CommandBuilder then(CommandNode nextNode);

    CommandBuilder requires(Requirement requirement);

    CommandBuilder executes(CommandExecutor executor);

    CommandBuilder executesPlayer(CommandExecutor executor);

    CommandBuilder suggests(CommandSuggester suggester);

    CommandBuilder redirects(Command redirection);

}
