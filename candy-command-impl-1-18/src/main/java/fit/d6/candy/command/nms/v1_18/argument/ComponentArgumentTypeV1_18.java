package fit.d6.candy.command.nms.v1_18.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.ComponentArgument;

public class ComponentArgumentTypeV1_18 extends ArgumentTypeV1_18 {

    public final static ComponentArgumentTypeV1_18 COMPONENT = new ComponentArgumentTypeV1_18();

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
