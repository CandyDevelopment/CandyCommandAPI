package fit.d6.candy.command.nms.v1_19_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_19_1.CommandManagerV1_19_1;
import net.minecraft.commands.arguments.item.ItemArgument;

public class ItemArgumentTypeV1_19_1 extends ArgumentTypeV1_19_1 {

    public final static ItemArgumentTypeV1_19_1 ITEM = new ItemArgumentTypeV1_19_1();

    private final ItemArgument argument = ItemArgument.item(CommandManagerV1_19_1.COMMAND_REGISTRY_ACCESS);

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ITEM;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
