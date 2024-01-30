package fit.d6.candy.command.nms.v1_19_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class BooleanArgumentTypeV1_19_1 extends ArgumentTypeV1_19_1 {

    public final static BooleanArgumentTypeV1_19_1 BOOL = new BooleanArgumentTypeV1_19_1();

    private final static BoolArgumentType ARGUMENT_TYPE = BoolArgumentType.bool();

    private BooleanArgumentTypeV1_19_1() {
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
