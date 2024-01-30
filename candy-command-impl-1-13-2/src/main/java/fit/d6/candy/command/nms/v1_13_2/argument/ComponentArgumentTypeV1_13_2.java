package fit.d6.candy.command.nms.v1_13_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_13_R2.ArgumentChatComponent;

public class ComponentArgumentTypeV1_13_2 extends ArgumentTypeV1_13_2 {

    public final static ComponentArgumentTypeV1_13_2 COMPONENT = new ComponentArgumentTypeV1_13_2();

    private final ArgumentChatComponent argument = ArgumentChatComponent.a();

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.COMPONENT;
    }
}
