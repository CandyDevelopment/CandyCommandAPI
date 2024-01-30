package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_16_R3.ArgumentMobEffect;

public class PotionEffectArgumentV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static PotionEffectArgumentV1_16_5 MOB_EFFECT = new PotionEffectArgumentV1_16_5();

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
