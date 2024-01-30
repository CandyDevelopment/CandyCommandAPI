package fit.d6.candy.command.nms.v1_13_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_13_R2.ArgumentItemPredicate;

public class ItemPredicateArgumentTypeV1_13_2 extends ArgumentTypeV1_13_2 {

    public final static ItemPredicateArgumentTypeV1_13_2 ITEM_PREDICATE = new ItemPredicateArgumentTypeV1_13_2();

    private final ArgumentItemPredicate argument = ArgumentItemPredicate.a();

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ITEM_PREDICATE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
