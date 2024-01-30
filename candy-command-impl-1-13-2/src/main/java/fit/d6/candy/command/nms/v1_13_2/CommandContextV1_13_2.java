package fit.d6.candy.command.nms.v1_13_2;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.CommandNode;
import fit.d6.candy.api.command.CommandArgumentHelper;
import fit.d6.candy.api.command.CommandContext;
import net.minecraft.server.v1_13_R2.CommandListenerWrapper;
import net.minecraft.server.v1_13_R2.MinecraftServer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandContextV1_13_2 implements CommandContext {

    private final com.mojang.brigadier.context.CommandContext<CommandListenerWrapper> brigadier;

    public CommandContextV1_13_2(com.mojang.brigadier.context.CommandContext<CommandListenerWrapper> brigadier) {
        this.brigadier = brigadier;
    }

    @Override
    public CommandArgumentHelper getArgument() {
        return new CommandArgumentHelperV1_13_2(this.brigadier);
    }

    @Override
    public CommandSender getSender() {
        return this.brigadier.getSource().getBukkitSender();
    }

    @Override
    public Player getPlayer() throws CommandSyntaxException {
        return this.brigadier.getSource().h().getBukkitEntity();
    }

    @Override
    public String getAlias() {
        CommandNode<CommandListenerWrapper> root =  MinecraftServer.getServer().vanillaCommandDispatcher.a().getRoot();
        for (CommandNode<CommandListenerWrapper> commandNode : this.brigadier.getNodes().keySet()) {
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
