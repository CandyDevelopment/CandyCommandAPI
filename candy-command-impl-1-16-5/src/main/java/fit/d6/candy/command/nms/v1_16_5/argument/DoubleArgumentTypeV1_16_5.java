package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class DoubleArgumentTypeV1_16_5 extends ArgumentTypeV1_16_5 {

    private final DoubleArgumentType argumentType;

    public DoubleArgumentTypeV1_16_5(DoubleArgumentType argumentType) {
        this.argumentType = argumentType;
    }

    @Override
    public ArgumentType<Double> toBrigadier() {
        return this.argumentType;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.DOUBLE;
    }
}
