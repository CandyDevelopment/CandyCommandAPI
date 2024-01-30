package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_16_R3.ArgumentTile;

public class BlockStateArgumentTypeV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static BlockStateArgumentTypeV1_16_5 BLOCK_STATE = new BlockStateArgumentTypeV1_16_5();

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
