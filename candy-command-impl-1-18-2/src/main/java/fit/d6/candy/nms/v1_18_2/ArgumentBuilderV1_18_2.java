package fit.d6.candy.nms.v1_18_2;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import fit.d6.candy.api.command.*;
import fit.d6.candy.nms.v1_18_2.argument.ArgumentTypeV1_18_2;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ArgumentBuilderV1_18_2 extends CommandBuilderV1_18_2<RequiredArgumentBuilder<CommandSourceStack, Object>> {

    private RequiredArgumentBuilder<CommandSourceStack, ?> brigadier;

    private final String name;
    private final ArgumentTypeV1_18_2 argumentType;
    private final List<CommandNode> children = new ArrayList<>();
    private CommandExecutor executor;
    private CommandExecutor playerExecutor;
    private CommandSuggester suggester;
    private Command redirection;
    private Requirement requirement;

    public ArgumentBuilderV1_18_2(String name, ArgumentTypeV1_18_2 argumentType) {
        this.brigadier = Commands.argument(name, argumentType.toBrigadier());

        this.name = name;
        this.argumentType = argumentType;
    }

    @Override
    public CommandBuilder then(CommandNode nextNode) {
        if (nextNode instanceof CommandV1_18_2) {
            this.brigadier.then(((CommandV1_18_2) nextNode).toBrigadier());
        } else if (nextNode instanceof CommandBuilderV1_18_2<?>) {
            this.brigadier.then(((CommandBuilderV1_18_2) nextNode).toBrigadier());
        } else {
            return this;
        }
        this.children.add(nextNode);
        return this;
    }

    @Override
    public CommandBuilder requires(Requirement requirement) {
        this.requirement = requirement;
        if (requirement == null) {
            this.brigadier.requires(ArgumentBuilder.defaultRequirement());
        } else {
            this.brigadier.requires(source -> this.requirement.check(source.getBukkitSender()));
        }
        return this;
    }

    @Override
    public CommandBuilder executes(CommandExecutor executor) {
        this.executor = executor;
        this.checkExecutor();
        return this;
    }

    @Override
    public CommandBuilder executesPlayer(CommandExecutor executor) {
        this.playerExecutor = executor;
        this.checkExecutor();
        return this;
    }

    private void checkExecutor() {
        if (this.executor == null && this.playerExecutor == null) {
            this.brigadier.executes(null);
        } else {
            this.brigadier.executes(context -> {
                CommandContext candyContext = new CommandContextV1_18_2(context);
                CommandArgumentHelper argumentHelper = new CommandArgumentHelperV1_18_2(context);
                if (this.playerExecutor != null && context.getSource().getBukkitSender() instanceof Player) {
                    return this.playerExecutor.executes(candyContext, argumentHelper);
                } else if (this.executor != null) {
                    return this.executor.executes(candyContext, argumentHelper);
                } else {
                    throw CommandSourceStack.ERROR_NOT_PLAYER.create();
                }
            });
        }
    }

    @Override
    public CommandBuilder suggests(CommandSuggester suggester) {
        this.suggester = suggester;
        if (suggester == null) {
            this.brigadier.suggests(null);
        } else {
            this.brigadier.suggests((commandContext, suggestionsBuilder) -> {
                CommandContext context = new CommandContextV1_18_2(commandContext);
                CommandArgumentHelper argument = new CommandArgumentHelperV1_18_2(commandContext);
                CommandSuggestion suggestion = new CommandSuggestionV1_18_2(suggestionsBuilder);

                this.suggester.suggests(context, argument, suggestion);

                return suggestionsBuilder.buildFuture();
            });
        }
        return this;
    }

    @Override
    public CommandBuilder redirects(Command redirection) {
        this.redirection = redirection;
        if (redirection != null) {
            this.brigadier.redirect(((CommandV1_18_2) redirection).toBrigadier());
        } else {
            this.brigadier.redirect(null);
        }
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public RequiredArgumentBuilder<CommandSourceStack, Object> toBrigadier() {
        return (RequiredArgumentBuilder<CommandSourceStack, Object>) this.brigadier;
    }

}
