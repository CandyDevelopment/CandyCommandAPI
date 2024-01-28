package fit.d6.candy.nms.v1_17_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.item.ItemArgument;

public class ItemArgumentTypeV1_17_1 extends ArgumentTypeV1_17_1 {

    public final static ItemArgumentTypeV1_17_1 ITEM = new ItemArgumentTypeV1_17_1();

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
