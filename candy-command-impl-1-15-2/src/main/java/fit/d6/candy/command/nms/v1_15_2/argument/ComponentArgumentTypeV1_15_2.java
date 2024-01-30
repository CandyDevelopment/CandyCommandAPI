package fit.d6.candy.command.nms.v1_15_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_15_R1.ArgumentChatComponent;

public class ComponentArgumentTypeV1_15_2 extends ArgumentTypeV1_15_2 {

    public final static ComponentArgumentTypeV1_15_2 COMPONENT = new ComponentArgumentTypeV1_15_2();

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
