package fit.d6.candy.command.nms.v1_13_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_13_R2.ArgumentTile;

public class BlockStateArgumentTypeV1_13_2 extends ArgumentTypeV1_13_2 {

    public final static BlockStateArgumentTypeV1_13_2 BLOCK_STATE = new BlockStateArgumentTypeV1_13_2();

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
