package fit.d6.candy.command.nms.v1_20_2.argument;

import fit.d6.candy.api.command.ArgumentType;

public abstract class ArgumentTypeV1_20_2 implements ArgumentType {

    public abstract com.mojang.brigadier.arguments.ArgumentType<?> toBrigadier();

}
