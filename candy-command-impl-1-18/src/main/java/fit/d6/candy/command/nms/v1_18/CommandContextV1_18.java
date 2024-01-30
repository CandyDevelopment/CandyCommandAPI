package fit.d6.candy.command.nms.v1_18;

import com.mojang.brigadier.context.ParsedCommandNode;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.CommandNode;
import fit.d6.candy.api.command.CommandArgumentHelper;
import fit.d6.candy.api.command.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandContextV1_18 implements CommandContext {

    private final com.mojang.brigadier.context.CommandContext<CommandSourceStack> brigadier;

    public CommandContextV1_18(com.mojang.brigadier.context.CommandContext<CommandSourceStack> brigadier) {
        this.brigadier = brigadier;
    }

    @Override
    public CommandArgumentHelper getArgument() {
        return new CommandArgumentHelperV1_18(this.brigadier);
    }

    @Override
    public CommandSender getSender() {
        return this.brigadier.getSource().getBukkitSender();
    }

    @Override
    public Player getPlayer() throws CommandSyntaxException {
        return this.brigadier.getSource().getPlayerOrException().getBukkitEntity();
    }

    @Override
    public String getAlias() {
        CommandNode<CommandSourceStack> root = this.brigadier.getRootNode();
        for (CommandNode<CommandSourceStack> commandNode : this.brigadier.getNodes().stream().map(ParsedCommandNode::getNode).toList()) {
            if (root.getChildren().contains(commandNode))
                return commandNode.getName();
        }
        return "wtf";
    }

    @Override
    public boolean isPlayer() {
        return this.brigadier.getSource().getBukkitSender() instanceof Player;
    }

    @Override
    public String getRawCommand() {
        return this.brigadier.getInput();
    }

    public com.mojang.brigadier.context.CommandContext<?> toBrigadier() {
        return this.brigadier;
    }

}
