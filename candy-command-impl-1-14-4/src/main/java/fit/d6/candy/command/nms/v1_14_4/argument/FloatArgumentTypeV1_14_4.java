package fit.d6.candy.command.nms.v1_14_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class FloatArgumentTypeV1_14_4 extends ArgumentTypeV1_14_4 {

    private final FloatArgumentType argumentType;

    public FloatArgumentTypeV1_14_4(FloatArgumentType argumentType) {
        this.argumentType = argumentType;
    }

    @Override
    public ArgumentType<Float> toBrigadier() {
        return this.argumentType;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.FLOAT;
    }
}
