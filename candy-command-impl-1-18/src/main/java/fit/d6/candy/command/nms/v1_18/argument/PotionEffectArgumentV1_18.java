package fit.d6.candy.command.nms.v1_18.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.MobEffectArgument;

public class PotionEffectArgumentV1_18 extends ArgumentTypeV1_18 {

    public final static PotionEffectArgumentV1_18 MOB_EFFECT = new PotionEffectArgumentV1_18();

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
