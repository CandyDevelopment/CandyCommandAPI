package fit.d6.candy.nms.v1_18_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.EntitySummonArgument;

public class SummonableEntityTypeArgumentV1_18_2 extends ArgumentTypeV1_18_2 {

    public final static SummonableEntityTypeArgumentV1_18_2 SUMMONABLE_ENTITY_TYPE = new SummonableEntityTypeArgumentV1_18_2();

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
