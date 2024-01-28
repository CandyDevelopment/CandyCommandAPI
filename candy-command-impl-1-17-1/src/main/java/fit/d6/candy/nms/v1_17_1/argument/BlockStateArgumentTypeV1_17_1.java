package fit.d6.candy.nms.v1_17_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.blocks.BlockStateArgument;

public class BlockStateArgumentTypeV1_17_1 extends ArgumentTypeV1_17_1 {

    public final static BlockStateArgumentTypeV1_17_1 BLOCK_STATE = new BlockStateArgumentTypeV1_17_1();

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
