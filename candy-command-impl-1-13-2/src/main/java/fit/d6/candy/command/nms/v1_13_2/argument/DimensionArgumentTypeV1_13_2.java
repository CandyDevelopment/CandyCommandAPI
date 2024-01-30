package fit.d6.candy.command.nms.v1_13_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_13_R2.ArgumentDimension;

public class DimensionArgumentTypeV1_13_2 extends ArgumentTypeV1_13_2 {

    public final static DimensionArgumentTypeV1_13_2 DIMENSION = new DimensionArgumentTypeV1_13_2();

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
