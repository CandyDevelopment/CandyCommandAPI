package fit.d6.candy.nms.v1_20_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class StringArgumentTypeV1_20_4 extends ArgumentTypeV1_20_4 {

    public final static StringArgumentTypeV1_20_4 STRING = new StringArgumentTypeV1_20_4(StringArgumentType.string());
    public final static StringArgumentTypeV1_20_4 WORD = new StringArgumentTypeV1_20_4(StringArgumentType.word());
    public final static StringArgumentTypeV1_20_4 GREEDY_STRING = new StringArgumentTypeV1_20_4(StringArgumentType.greedyString());

    private final StringArgumentType brigadier;

    private StringArgumentTypeV1_20_4(StringArgumentType stringArgumentType) {
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
