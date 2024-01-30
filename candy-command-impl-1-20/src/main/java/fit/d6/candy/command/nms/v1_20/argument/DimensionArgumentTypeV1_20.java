package fit.d6.candy.command.nms.v1_20.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.DimensionArgument;

public class DimensionArgumentTypeV1_20 extends ArgumentTypeV1_20 {

    public final static DimensionArgumentTypeV1_20 DIMENSION = new DimensionArgumentTypeV1_20();

    private final DimensionArgument argument = DimensionArgument.dimension();

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.WORLD;
    }
}
