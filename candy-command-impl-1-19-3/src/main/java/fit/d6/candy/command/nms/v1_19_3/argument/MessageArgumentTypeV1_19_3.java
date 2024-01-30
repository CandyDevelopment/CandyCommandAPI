package fit.d6.candy.command.nms.v1_19_3.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.MessageArgument;

public class MessageArgumentTypeV1_19_3 extends ArgumentTypeV1_19_3 {

    public final static MessageArgumentTypeV1_19_3 MESSAGE = new MessageArgumentTypeV1_19_3();

    private final MessageArgument argument = MessageArgument.message();

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.MESSAGE;
    }
}
