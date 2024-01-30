package fit.d6.candy.command.nms.v1_15_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_15_R1.ArgumentTile;

public class BlockStateArgumentTypeV1_15_2 extends ArgumentTypeV1_15_2 {

    public final static BlockStateArgumentTypeV1_15_2 BLOCK_STATE = new BlockStateArgumentTypeV1_15_2();

    private final ArgumentTile argument = ArgumentTile.a();

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.BLOCK;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
