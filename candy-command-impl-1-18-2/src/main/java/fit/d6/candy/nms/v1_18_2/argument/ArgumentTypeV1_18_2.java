package fit.d6.candy.nms.v1_18_2.argument;

import fit.d6.candy.api.command.ArgumentType;

public abstract class ArgumentTypeV1_18_2 implements ArgumentType {

    public abstract com.mojang.brigadier.arguments.ArgumentType<?> toBrigadier();

}
