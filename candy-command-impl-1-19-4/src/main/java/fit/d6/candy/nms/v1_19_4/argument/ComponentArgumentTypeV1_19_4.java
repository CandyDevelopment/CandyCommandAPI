package fit.d6.candy.nms.v1_19_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.ComponentArgument;

public class ComponentArgumentTypeV1_19_4 extends fit.d6.candy.nms.v1_19_4.argument.ArgumentTypeV1_19_4 {

    public final static ComponentArgumentTypeV1_19_4 COMPONENT = new ComponentArgumentTypeV1_19_4();

    private final ComponentArgument argument = ComponentArgument.textComponent();

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.COMPONENT;
    }
}
