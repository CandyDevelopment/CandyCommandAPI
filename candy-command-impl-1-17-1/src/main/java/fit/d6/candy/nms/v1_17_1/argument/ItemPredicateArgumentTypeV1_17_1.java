package fit.d6.candy.nms.v1_17_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.item.ItemPredicateArgument;

public class ItemPredicateArgumentTypeV1_17_1 extends ArgumentTypeV1_17_1 {

    public final static ItemPredicateArgumentTypeV1_17_1 ITEM_PREDICATE = new ItemPredicateArgumentTypeV1_17_1();

    private final ItemPredicateArgument argument = ItemPredicateArgument.itemPredicate();

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ITEM_PREDICATE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
