package fit.d6.candy.command.nms.v1_20_2;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import fit.d6.candy.api.command.*;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

import java.util.ArrayList;
import java.util.List;

public class LiteralCommandBuilderV1_20_2 extends CommandBuilderV1_20_2<LiteralArgumentBuilder<CommandSourceStack>> {

    private final LiteralArgumentBuilder<CommandSourceStack> brigadier;

    private final String name;
    private final List<CommandNode> children = new ArrayList<>();
    private CommandExecutor executor;
    private CommandExecutor playerExecutor;
    private Command redirection;
    private Requirement requirement;

    public LiteralCommandBuilderV1_20_2(String name) {
        this.brigadier = Commands.literal(name);
        this.name = name;
    }

    @Override
    public CommandBuilder then(CommandNode nextNode) {
        if (nextNode instanceof CommandV1_20_2) {
            this.brigadier.then(((CommandV1_20_2) nextNode).toBrigadier());
        } else if (nextNode instanceof CommandBuilderV1_20_2<?>) {
            this.brigadier.then(((CommandBuilderV1_20_2) nextNode).toBrigadier());
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
                CommandContext candyContext = new CommandContextV1_20_2(context);
                CommandArgumentHelper argumentHelper = new CommandArgumentHelperV1_20_2(context);
                if (this.playerExecutor != null && context.getSource().isPlayer()) {
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
        return this;
    }

    @Override
    public CommandBuilder redirects(Command redirection) {
        this.redirection = redirection;
        if (redirection != null) {
            this.brigadier.redirect(((CommandV1_20_2) redirection).toBrigadier());
        } else {
            this.brigadier.redirect(null);
        }
        return this;
    }

    @Override
    public LiteralArgumentBuilder<CommandSourceStack> toBrigadier() {
        return brigadier;
    }

}
