package fit.d6.candy.command.nms.v1_18.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class StringArgumentTypeV1_18 extends ArgumentTypeV1_18 {

    public final static StringArgumentTypeV1_18 STRING = new StringArgumentTypeV1_18(StringArgumentType.string());
    public final static StringArgumentTypeV1_18 WORD = new StringArgumentTypeV1_18(StringArgumentType.word());
    public final static StringArgumentTypeV1_18 GREEDY_STRING = new StringArgumentTypeV1_18(StringArgumentType.greedyString());

    private final StringArgumentType brigadier;

    private StringArgumentTypeV1_18(StringArgumentType stringArgumentType) {
        this.brigadier = stringArgumentType;
    }

    @Override
    public ArgumentType<String> toBrigadier() {
        return brigadier;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.STRING;
    }
}
