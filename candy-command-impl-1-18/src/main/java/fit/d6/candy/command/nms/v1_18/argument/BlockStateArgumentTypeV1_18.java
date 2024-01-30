package fit.d6.candy.command.nms.v1_18.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.blocks.BlockStateArgument;

public class BlockStateArgumentTypeV1_18 extends ArgumentTypeV1_18 {

    public final static BlockStateArgumentTypeV1_18 BLOCK_STATE = new BlockStateArgumentTypeV1_18();

    private final BlockStateArgument argument = BlockStateArgument.block();

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.BLOCK;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
