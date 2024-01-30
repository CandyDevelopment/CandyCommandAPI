package fit.d6.candy.command.nms.v1_19_3.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class FloatArgumentTypeV1_19_3 extends ArgumentTypeV1_19_3 {

    private final FloatArgumentType argumentType;

    public FloatArgumentTypeV1_19_3(FloatArgumentType argumentType) {
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
