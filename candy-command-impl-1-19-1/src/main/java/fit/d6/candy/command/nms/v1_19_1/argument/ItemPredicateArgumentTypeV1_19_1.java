package fit.d6.candy.command.nms.v1_19_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_19_1.CommandManagerV1_19_1;
import net.minecraft.commands.arguments.item.ItemPredicateArgument;

public class ItemPredicateArgumentTypeV1_19_1 extends ArgumentTypeV1_19_1 {

    public final static ItemPredicateArgumentTypeV1_19_1 ITEM_PREDICATE = new ItemPredicateArgumentTypeV1_19_1();

    private final ItemPredicateArgument argument = ItemPredicateArgument.itemPredicate(CommandManagerV1_19_1.COMMAND_REGISTRY_ACCESS);

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ITEM_PREDICATE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
