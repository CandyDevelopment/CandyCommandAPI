package fit.d6.candy.command.nms.v1_20.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.ComponentArgument;

public class ComponentArgumentTypeV1_20 extends ArgumentTypeV1_20 {

    public final static ComponentArgumentTypeV1_20 COMPONENT = new ComponentArgumentTypeV1_20();

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
