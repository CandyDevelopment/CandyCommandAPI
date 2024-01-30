package fit.d6.candy.command.nms.v1_13_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class StringArgumentTypeV1_13_2 extends ArgumentTypeV1_13_2 {

    public final static StringArgumentTypeV1_13_2 STRING = new StringArgumentTypeV1_13_2(StringArgumentType.string());
    public final static StringArgumentTypeV1_13_2 WORD = new StringArgumentTypeV1_13_2(StringArgumentType.word());
    public final static StringArgumentTypeV1_13_2 GREEDY_STRING = new StringArgumentTypeV1_13_2(StringArgumentType.greedyString());

    private final StringArgumentType brigadier;

    private StringArgumentTypeV1_13_2(StringArgumentType stringArgumentType) {
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
