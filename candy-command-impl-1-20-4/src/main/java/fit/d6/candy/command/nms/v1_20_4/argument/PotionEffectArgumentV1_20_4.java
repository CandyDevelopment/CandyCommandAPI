package fit.d6.candy.command.nms.v1_20_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_20_4.CommandManagerV1_20_4;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;

public class PotionEffectArgumentV1_20_4 extends ArgumentTypeV1_20_4 {

    public final static PotionEffectArgumentV1_20_4 MOB_EFFECT = new PotionEffectArgumentV1_20_4();

    private final ResourceArgument<MobEffect> argument = ResourceArgument.resource(CommandManagerV1_20_4.COMMAND_REGISTRY_ACCESS, Registries.MOB_EFFECT);

    @Override
    public ArgumentTypes getType() {

        return ArgumentTypes.POTION_EFFECT_TYPE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
