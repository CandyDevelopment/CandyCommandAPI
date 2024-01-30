package fit.d6.candy.command.nms.v1_15_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_15_R1.ArgumentItemPredicate;

public class ItemPredicateArgumentTypeV1_15_2 extends ArgumentTypeV1_15_2 {

    public final static ItemPredicateArgumentTypeV1_15_2 ITEM_PREDICATE = new ItemPredicateArgumentTypeV1_15_2();

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
