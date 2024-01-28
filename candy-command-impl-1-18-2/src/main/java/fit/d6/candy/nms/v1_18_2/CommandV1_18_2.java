package fit.d6.candy.nms.v1_18_2;

import com.mojang.brigadier.tree.CommandNode;
import fit.d6.candy.api.command.Command;
import net.minecraft.commands.CommandSourceStack;

public class CommandV1_18_2 implements Command {

    private final CommandNode<CommandSourceStack> commandNode;

    public CommandV1_18_2(CommandNode<CommandSourceStack> commandNode) {
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