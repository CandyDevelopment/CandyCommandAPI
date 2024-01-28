package fit.d6.candy.nms.v1_19_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class BooleanArgumentTypeV1_19_4 extends fit.d6.candy.nms.v1_19_4.argument.ArgumentTypeV1_19_4 {

    public final static BooleanArgumentTypeV1_19_4 BOOL = new BooleanArgumentTypeV1_19_4();

    private final static BoolArgumentType ARGUMENT_TYPE = BoolArgumentType.bool();

    private BooleanArgumentTypeV1_19_4() {
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
