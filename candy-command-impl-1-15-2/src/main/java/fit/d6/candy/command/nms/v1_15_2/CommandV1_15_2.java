package fit.d6.candy.command.nms.v1_15_2;

import com.mojang.brigadier.tree.CommandNode;
import fit.d6.candy.api.command.Command;
import net.minecraft.server.v1_15_R1.CommandListenerWrapper;

public class CommandV1_15_2 implements Command {

    private final CommandNode<CommandListenerWrapper> commandNode;

    public CommandV1_15_2(CommandNode<CommandListenerWrapper> commandNode) {
        this.commandNode = commandNode;
    }

    public CommandNode<CommandListenerWrapper> toBrigadier() {
        return this.commandNode;
    }

    @Override
    public String getName() {
        return this.commandNode.getName();
    }

}
