package fit.d6.candy.command.nms.v1_20.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.MessageArgument;

public class MessageArgumentTypeV1_20 extends ArgumentTypeV1_20 {

    public final static MessageArgumentTypeV1_20 MESSAGE = new MessageArgumentTypeV1_20();

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
