package fit.d6.candy.command.nms.v1_20.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_20.CommandManagerV1_20;
import net.minecraft.commands.arguments.item.ItemArgument;

public class ItemArgumentTypeV1_20 extends ArgumentTypeV1_20 {

    public final static ItemArgumentTypeV1_20 ITEM = new ItemArgumentTypeV1_20();

    private final ItemArgument argument = ItemArgument.item(CommandManagerV1_20.COMMAND_REGISTRY_ACCESS);

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ITEM;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
