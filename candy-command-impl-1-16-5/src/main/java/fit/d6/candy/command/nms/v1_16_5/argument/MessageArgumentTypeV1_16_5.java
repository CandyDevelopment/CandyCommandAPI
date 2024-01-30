package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_16_R3.ArgumentChat;

public class MessageArgumentTypeV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static MessageArgumentTypeV1_16_5 MESSAGE = new MessageArgumentTypeV1_16_5();

    private final ArgumentChat argument = ArgumentChat.a();

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.MESSAGE;
    }
}
