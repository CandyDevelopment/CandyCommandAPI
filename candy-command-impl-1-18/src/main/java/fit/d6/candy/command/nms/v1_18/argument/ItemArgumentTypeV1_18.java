package fit.d6.candy.command.nms.v1_18.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.item.ItemArgument;

public class ItemArgumentTypeV1_18 extends ArgumentTypeV1_18 {

    public final static ItemArgumentTypeV1_18 ITEM = new ItemArgumentTypeV1_18();

    private final ItemArgument argument = ItemArgument.item();

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ITEM;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
