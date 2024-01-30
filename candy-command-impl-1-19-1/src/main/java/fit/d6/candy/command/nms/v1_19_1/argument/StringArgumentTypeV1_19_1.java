package fit.d6.candy.command.nms.v1_19_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;

public class StringArgumentTypeV1_19_1 extends ArgumentTypeV1_19_1 {

    public final static StringArgumentTypeV1_19_1 STRING = new StringArgumentTypeV1_19_1(StringArgumentType.string());
    public final static StringArgumentTypeV1_19_1 WORD = new StringArgumentTypeV1_19_1(StringArgumentType.word());
    public final static StringArgumentTypeV1_19_1 GREEDY_STRING = new StringArgumentTypeV1_19_1(StringArgumentType.greedyString());

    private final StringArgumentType brigadier;

    private StringArgumentTypeV1_19_1(StringArgumentType stringArgumentType) {
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
