package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_16_R3.ArgumentDimension;

public class DimensionArgumentTypeV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static DimensionArgumentTypeV1_16_5 DIMENSION = new DimensionArgumentTypeV1_16_5();

    private final ArgumentDimension argument = ArgumentDimension.a();

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.WORLD;
    }
}
