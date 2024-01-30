package fit.d6.candy.command.nms.v1_14_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_14_R1.ArgumentEntitySummon;

public class SummonableEntityTypeArgumentV1_14_4 extends ArgumentTypeV1_14_4 {

    public final static SummonableEntityTypeArgumentV1_14_4 SUMMONABLE_ENTITY_TYPE = new SummonableEntityTypeArgumentV1_14_4();

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
