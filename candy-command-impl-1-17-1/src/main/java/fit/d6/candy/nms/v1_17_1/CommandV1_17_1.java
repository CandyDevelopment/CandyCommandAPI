package fit.d6.candy.nms.v1_17_1;

import com.mojang.brigadier.tree.CommandNode;
import fit.d6.candy.api.command.Command;
import net.minecraft.commands.CommandSourceStack;

public class CommandV1_17_1 implements Command {

    private final CommandNode<CommandSourceStack> commandNode;

    public CommandV1_17_1(CommandNode<CommandSourceStack> commandNode) {
        this.commandNode = commandNode;
    }

    public CommandNode<CommandSourceStack> toBrigadier() {
        return this.commandNode;
    }

    @Override
    public String getName() {
        return this.commandNode.getName();
    }

}
