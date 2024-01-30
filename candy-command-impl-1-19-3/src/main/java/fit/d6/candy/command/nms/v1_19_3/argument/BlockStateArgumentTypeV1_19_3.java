package fit.d6.candy.command.nms.v1_19_3.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_19_3.CommandManagerV1_19_3;
import net.minecraft.commands.arguments.blocks.BlockStateArgument;

public class BlockStateArgumentTypeV1_19_3 extends ArgumentTypeV1_19_3 {

    public final static BlockStateArgumentTypeV1_19_3 BLOCK_STATE = new BlockStateArgumentTypeV1_19_3();

    private final BlockStateArgument argument = BlockStateArgument.block(CommandManagerV1_19_3.COMMAND_REGISTRY_ACCESS);

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.BLOCK;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
