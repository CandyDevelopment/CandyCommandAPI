package fit.d6.candy.nms.v1_18_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.item.ItemPredicateArgument;

public class ItemPredicateArgumentTypeV1_18_2 extends ArgumentTypeV1_18_2 {

    public final static ItemPredicateArgumentTypeV1_18_2 ITEM_PREDICATE = new ItemPredicateArgumentTypeV1_18_2();

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
