package fit.d6.candy.command.nms.v1_15_2.argument;

import fit.d6.candy.api.command.ArgumentType;

public abstract class ArgumentTypeV1_15_2 implements ArgumentType {

    public abstract com.mojang.brigadier.arguments.ArgumentType<?> toBrigadier();

}
