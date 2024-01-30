package fit.d6.candy.command.nms.v1_14_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_14_R1.ArgumentItemPredicate;

public class ItemPredicateArgumentTypeV1_14_4 extends ArgumentTypeV1_14_4 {

    public final static ItemPredicateArgumentTypeV1_14_4 ITEM_PREDICATE = new ItemPredicateArgumentTypeV1_14_4();

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
