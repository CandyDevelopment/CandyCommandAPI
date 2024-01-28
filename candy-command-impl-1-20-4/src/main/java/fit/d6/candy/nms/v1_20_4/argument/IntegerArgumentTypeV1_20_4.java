package fit.d6.candy.nms.v1_20_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class IntegerArgumentTypeV1_20_4 extends ArgumentTypeV1_20_4 {

    private final IntegerArgumentType argumentType;

    public IntegerArgumentTypeV1_20_4(IntegerArgumentType argumentType) {
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
