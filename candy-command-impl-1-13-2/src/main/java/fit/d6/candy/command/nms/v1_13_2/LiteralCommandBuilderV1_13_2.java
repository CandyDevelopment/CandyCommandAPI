package fit.d6.candy.command.nms.v1_13_2;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import fit.d6.candy.api.command.*;
import net.minecraft.server.v1_13_R2.CommandDispatcher;
import net.minecraft.server.v1_13_R2.CommandListenerWrapper;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LiteralCommandBuilderV1_13_2 extends CommandBuilderV1_13_2<LiteralArgumentBuilder<CommandListenerWrapper>> {

    private final LiteralArgumentBuilder<CommandListenerWrapper> brigadier;

    private final String name;
    private final List<CommandNode> children = new ArrayList<>();
    private CommandExecutor executor;
    private CommandExecutor playerExecutor;
    private Command redirection;
    private Requirement requirement;

    public LiteralCommandBuilderV1_13_2(String name) {
        this.brigadier = CommandDispatcher.a(name);
        this.name = name;
    }

    @Override
    public CommandBuilder then(CommandNode nextNode) {
        if (nextNode instanceof CommandV1_13_2) {
            this.brigadier.then(((CommandV1_13_2) nextNode).toBrigadier());
        } else if (nextNode instanceof CommandBuilderV1_13_2<?>) {
            this.brigadier.then(((CommandBuilderV1_13_2) nextNode).toBrigadier());
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
                CommandContext candyContext = new CommandContextV1_13_2(context);
                CommandArgumentHelper argumentHelper = new CommandArgumentHelperV1_13_2(context);
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
        return this;
    }

    @Override
    public CommandBuilder redirects(Command redirection) {
        this.redirection = redirection;
        if (redirection != null) {
            this.brigadier.redirect(((CommandV1_13_2) redirection).toBrigadier());
        } else {
            this.brigadier.redirect(null);
        }
        return this;
    }

    @Override
    public LiteralArgumentBuilder<CommandListenerWrapper> toBrigadier() {
        return brigadier;
    }

}
