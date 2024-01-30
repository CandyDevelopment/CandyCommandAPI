package fit.d6.candy.command.nms.v1_20.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_20.CommandManagerV1_20;
import net.minecraft.commands.arguments.blocks.BlockStateArgument;

public class BlockStateArgumentTypeV1_20 extends ArgumentTypeV1_20 {

    public final static BlockStateArgumentTypeV1_20 BLOCK_STATE = new BlockStateArgumentTypeV1_20();

    private final BlockStateArgument argument = BlockStateArgument.block(CommandManagerV1_20.COMMAND_REGISTRY_ACCESS);

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.BLOCK;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
