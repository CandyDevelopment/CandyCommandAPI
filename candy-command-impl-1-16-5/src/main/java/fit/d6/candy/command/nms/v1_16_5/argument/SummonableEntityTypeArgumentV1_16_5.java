package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_16_R3.ArgumentEntitySummon;

public class SummonableEntityTypeArgumentV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static SummonableEntityTypeArgumentV1_16_5 SUMMONABLE_ENTITY_TYPE = new SummonableEntityTypeArgumentV1_16_5();

    private final ArgumentEntitySummon argument = ArgumentEntitySummon.a();

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.SUMMONABLE_ENTITY_TYPE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
