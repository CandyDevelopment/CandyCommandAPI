package fit.d6.candy.nms.v1_18_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.LongArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class LongArgumentTypeV1_18_2 extends ArgumentTypeV1_18_2 {

    private final LongArgumentType argumentType;

    public LongArgumentTypeV1_18_2(LongArgumentType argumentType) {
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
