package fit.d6.candy.command.nms.v1_20_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_20_4.CommandManagerV1_20_4;
import net.minecraft.commands.arguments.item.ItemArgument;

public class ItemArgumentTypeV1_20_4 extends ArgumentTypeV1_20_4 {

    public final static ItemArgumentTypeV1_20_4 ITEM = new ItemArgumentTypeV1_20_4();

    private final ItemArgument argument = ItemArgument.item(CommandManagerV1_20_4.COMMAND_REGISTRY_ACCESS);

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ITEM;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
