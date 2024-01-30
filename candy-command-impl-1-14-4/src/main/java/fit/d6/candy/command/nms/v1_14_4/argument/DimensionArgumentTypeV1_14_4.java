package fit.d6.candy.command.nms.v1_14_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_14_R1.ArgumentDimension;

public class DimensionArgumentTypeV1_14_4 extends ArgumentTypeV1_14_4 {

    public final static DimensionArgumentTypeV1_14_4 DIMENSION = new DimensionArgumentTypeV1_14_4();

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
