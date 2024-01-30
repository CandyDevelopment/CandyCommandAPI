package fit.d6.candy.command.nms.v1_14_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_14_R1.ArgumentMobEffect;

public class PotionEffectArgumentV1_14_4 extends ArgumentTypeV1_14_4 {

    public final static PotionEffectArgumentV1_14_4 MOB_EFFECT = new PotionEffectArgumentV1_14_4();

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
