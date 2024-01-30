package fit.d6.candy.command.nms.v1_19_3.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class IntegerArgumentTypeV1_19_3 extends ArgumentTypeV1_19_3 {

    private final IntegerArgumentType argumentType;

    public IntegerArgumentTypeV1_19_3(IntegerArgumentType argumentType) {
        this.argumentType = argumentType;
    }

    @Override
    public ArgumentType<Integer> toBrigadier() {
        return this.argumentType;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.INTEGER;
    }
}
