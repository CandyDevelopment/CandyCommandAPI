package fit.d6.candy.command.nms.v1_19_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.LongArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class LongArgumentTypeV1_19_1 extends ArgumentTypeV1_19_1 {

    private final LongArgumentType argumentType;

    public LongArgumentTypeV1_19_1(LongArgumentType argumentType) {
        this.argumentType = argumentType;
    }

    @Override
    public ArgumentType<Long> toBrigadier() {
        return this.argumentType;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.LONG;
    }
}
