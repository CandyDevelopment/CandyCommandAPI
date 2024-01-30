package fit.d6.candy.command.nms.v1_20_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class BooleanArgumentTypeV1_20_2 extends ArgumentTypeV1_20_2 {

    public final static BooleanArgumentTypeV1_20_2 BOOL = new BooleanArgumentTypeV1_20_2();

    private final static BoolArgumentType ARGUMENT_TYPE = BoolArgumentType.bool();

    private BooleanArgumentTypeV1_20_2() {
    }

    @Override
    public ArgumentType<Boolean> toBrigadier() {
        return ARGUMENT_TYPE;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.BOOLEAN;
    }
}
