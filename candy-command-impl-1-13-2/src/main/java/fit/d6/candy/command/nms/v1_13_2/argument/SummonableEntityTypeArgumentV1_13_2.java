package fit.d6.candy.command.nms.v1_13_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_13_R2.ArgumentEntitySummon;

public class SummonableEntityTypeArgumentV1_13_2 extends ArgumentTypeV1_13_2 {

    public final static SummonableEntityTypeArgumentV1_13_2 SUMMONABLE_ENTITY_TYPE = new SummonableEntityTypeArgumentV1_13_2();

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
