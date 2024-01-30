package fit.d6.candy.command.nms.v1_14_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_14_R1.ArgumentTile;

public class BlockStateArgumentTypeV1_14_4 extends ArgumentTypeV1_14_4 {

    public final static BlockStateArgumentTypeV1_14_4 BLOCK_STATE = new BlockStateArgumentTypeV1_14_4();

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
