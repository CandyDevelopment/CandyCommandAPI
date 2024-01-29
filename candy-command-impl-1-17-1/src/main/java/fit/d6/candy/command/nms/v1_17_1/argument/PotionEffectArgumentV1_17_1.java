package fit.d6.candy.command.nms.v1_17_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.MobEffectArgument;

public class PotionEffectArgumentV1_17_1 extends ArgumentTypeV1_17_1 {

    public final static PotionEffectArgumentV1_17_1 MOB_EFFECT = new PotionEffectArgumentV1_17_1();

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
