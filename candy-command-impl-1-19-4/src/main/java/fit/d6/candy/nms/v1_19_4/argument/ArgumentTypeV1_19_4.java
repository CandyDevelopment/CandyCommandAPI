package fit.d6.candy.nms.v1_19_4.argument;

import fit.d6.candy.api.command.ArgumentType;

public abstract class ArgumentTypeV1_19_4 implements ArgumentType {

    public abstract com.mojang.brigadier.arguments.ArgumentType<?> toBrigadier();

}
