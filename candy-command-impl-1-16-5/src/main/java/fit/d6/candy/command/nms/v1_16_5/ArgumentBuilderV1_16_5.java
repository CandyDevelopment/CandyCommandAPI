package fit.d6.candy.command.nms.v1_16_5;

import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import fit.d6.candy.api.command.*;
import fit.d6.candy.command.nms.v1_16_5.argument.ArgumentTypeV1_16_5;
import net.minecraft.server.v1_16_R3.CommandDispatcher;
import net.minecraft.server.v1_16_R3.CommandListenerWrapper;
import net.minecraft.server.v1_16_R3.CompletionProviders;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ArgumentBuilderV1_16_5 extends CommandBuilderV1_16_5<RequiredArgumentBuilder<CommandListenerWrapper, Object>> {

    private final RequiredArgumentBuilder<CommandListenerWrapper, ?> brigadier;

    private final String name;
    private final ArgumentTypeV1_16_5 argumentType;
    private final List<CommandNode> children = new ArrayList<>();
    private CommandExecutor executor;
    private CommandExecutor playerExecutor;
    private CommandSuggester suggester;
    private Command redirection;
    private Requirement requirement;

    public ArgumentBuilderV1_16_5(String name, ArgumentTypeV1_16_5 argumentType) {
        this.brigadier = CommandDispatcher.a(name, argumentType.toBrigadier());

        this.name = name;
        this.argumentType = argumentType;

        if (this.argumentType.getType() == ArgumentTypes.SUMMONABLE_ENTITY_TYPE)
            this.brigadier.suggests(CompletionProviders.e);
    }

    @Override
    public CommandBuilder then(CommandNode nextNode) {
        if (nextNode instanceof CommandV1_16_5) {
            this.brigadier.then(((CommandV1_16_5) nextNode).toBrigadier());
        } else if (nextNode instanceof CommandBuilderV1_16_5<?>) {
            this.brigadier.then(((CommandBuilderV1_16_5) nextNode).toBrigadier());
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
            this.brigadier.requires((s) -> true);
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
                CommandContext candyContext = new CommandContextV1_16_5(context);
                CommandArgumentHelper argumentHelper = new CommandArgumentHelperV1_16_5(context);
                if (this.playerExecutor != null && context.getSource().getBukkitSender() instanceof Player) {
                    return this.playerExecutor.executes(candyContext, argumentHelper);
                } else if (this.executor != null) {
                    return this.executor.executes(candyContext, argumentHelper);
                } else {
                    throw CommandListenerWrapper.a.create();
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
                CommandContext context = new CommandContextV1_16_5(commandContext);
                CommandArgumentHelper argument = new CommandArgumentHelperV1_16_5(commandContext);
                CommandSuggestion suggestion = new CommandSuggestionV1_16_5(suggestionsBuilder);

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
            this.brigadier.redirect(((CommandV1_16_5) redirection).toBrigadier());
        } else {
            this.brigadier.redirect(null);
        }
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public RequiredArgumentBuilder<CommandListenerWrapper, Object> toBrigadier() {
        return (RequiredArgumentBuilder<CommandListenerWrapper, Object>) this.brigadier;
    }

}
