package fit.d6.candy.command.nms.v1_15_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_15_R1.ArgumentMobEffect;

public class PotionEffectArgumentV1_15_2 extends ArgumentTypeV1_15_2 {

    public final static PotionEffectArgumentV1_15_2 MOB_EFFECT = new PotionEffectArgumentV1_15_2();

    private final ArgumentMobEffect argument = ArgumentMobEffect.a();

    @Override
    public ArgumentTypes getType() {

        return ArgumentTypes.POTION_EFFECT_TYPE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
