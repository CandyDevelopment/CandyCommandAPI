package fit.d6.candy.command.nms.v1_18.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.item.ItemPredicateArgument;

public class ItemPredicateArgumentTypeV1_18 extends ArgumentTypeV1_18 {

    public final static ItemPredicateArgumentTypeV1_18 ITEM_PREDICATE = new ItemPredicateArgumentTypeV1_18();

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
