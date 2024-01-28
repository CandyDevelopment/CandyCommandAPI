package fit.d6.candy.nms.v1_18_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.MobEffectArgument;

public class PotionEffectArgumentV1_18_2 extends ArgumentTypeV1_18_2 {

    public final static PotionEffectArgumentV1_18_2 MOB_EFFECT = new PotionEffectArgumentV1_18_2();

    private final MobEffectArgument argument = MobEffectArgument.effect();

    @Override
    public ArgumentTypes getType() {

        return ArgumentTypes.POTION_EFFECT_TYPE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
