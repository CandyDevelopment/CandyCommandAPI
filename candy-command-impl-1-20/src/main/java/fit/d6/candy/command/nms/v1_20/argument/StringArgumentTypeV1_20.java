package fit.d6.candy.command.nms.v1_20.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class StringArgumentTypeV1_20 extends ArgumentTypeV1_20 {

    public final static StringArgumentTypeV1_20 STRING = new StringArgumentTypeV1_20(StringArgumentType.string());
    public final static StringArgumentTypeV1_20 WORD = new StringArgumentTypeV1_20(StringArgumentType.word());
    public final static StringArgumentTypeV1_20 GREEDY_STRING = new StringArgumentTypeV1_20(StringArgumentType.greedyString());

    private final StringArgumentType brigadier;

    private StringArgumentTypeV1_20(StringArgumentType stringArgumentType) {
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
