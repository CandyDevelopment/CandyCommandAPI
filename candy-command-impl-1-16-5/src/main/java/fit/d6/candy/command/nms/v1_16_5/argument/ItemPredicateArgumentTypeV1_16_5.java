package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_16_R3.ArgumentItemPredicate;

public class ItemPredicateArgumentTypeV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static ItemPredicateArgumentTypeV1_16_5 ITEM_PREDICATE = new ItemPredicateArgumentTypeV1_16_5();

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
