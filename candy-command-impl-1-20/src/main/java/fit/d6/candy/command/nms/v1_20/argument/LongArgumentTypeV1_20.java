package fit.d6.candy.command.nms.v1_20.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.LongArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class LongArgumentTypeV1_20 extends ArgumentTypeV1_20 {

    private final LongArgumentType argumentType;

    public LongArgumentTypeV1_20(LongArgumentType argumentType) {
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
