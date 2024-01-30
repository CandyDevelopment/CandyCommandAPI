package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class StringArgumentTypeV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static StringArgumentTypeV1_16_5 STRING = new StringArgumentTypeV1_16_5(StringArgumentType.string());
    public final static StringArgumentTypeV1_16_5 WORD = new StringArgumentTypeV1_16_5(StringArgumentType.word());
    public final static StringArgumentTypeV1_16_5 GREEDY_STRING = new StringArgumentTypeV1_16_5(StringArgumentType.greedyString());

    private final StringArgumentType brigadier;

    private StringArgumentTypeV1_16_5(StringArgumentType stringArgumentType) {
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
