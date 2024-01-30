package fit.d6.candy.command.nms.v1_19_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.EntitySummonArgument;

public class SummonableEntityTypeArgumentV1_19_1 extends ArgumentTypeV1_19_1 {

    public final static SummonableEntityTypeArgumentV1_19_1 SUMMONABLE_ENTITY_TYPE = new SummonableEntityTypeArgumentV1_19_1();

    private final EntitySummonArgument argument = EntitySummonArgument.id();

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.SUMMONABLE_ENTITY_TYPE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
