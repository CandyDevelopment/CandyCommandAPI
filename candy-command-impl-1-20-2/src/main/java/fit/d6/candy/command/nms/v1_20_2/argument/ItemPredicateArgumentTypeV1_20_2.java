package fit.d6.candy.command.nms.v1_20_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_20_2.CommandManagerV1_20_2;
import net.minecraft.commands.arguments.item.ItemPredicateArgument;

public class ItemPredicateArgumentTypeV1_20_2 extends ArgumentTypeV1_20_2 {

    public final static ItemPredicateArgumentTypeV1_20_2 ITEM_PREDICATE = new ItemPredicateArgumentTypeV1_20_2();

    private final ItemPredicateArgument argument = ItemPredicateArgument.itemPredicate(CommandManagerV1_20_2.COMMAND_REGISTRY_ACCESS);

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ITEM_PREDICATE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
