package fit.d6.candy.nms.v1_18_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.MessageArgument;

public class MessageArgumentTypeV1_18_2 extends ArgumentTypeV1_18_2 {

    public final static MessageArgumentTypeV1_18_2 MESSAGE = new MessageArgumentTypeV1_18_2();

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
