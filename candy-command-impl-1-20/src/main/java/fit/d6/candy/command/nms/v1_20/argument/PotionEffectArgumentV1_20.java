package fit.d6.candy.command.nms.v1_20.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_20.CommandManagerV1_20;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;

public class PotionEffectArgumentV1_20 extends ArgumentTypeV1_20 {

    public final static PotionEffectArgumentV1_20 MOB_EFFECT = new PotionEffectArgumentV1_20();

    private final ResourceArgument<MobEffect> argument = ResourceArgument.resource(CommandManagerV1_20.COMMAND_REGISTRY_ACCESS, Registries.MOB_EFFECT);

    @Override
    public ArgumentTypes getType() {

        return ArgumentTypes.POTION_EFFECT_TYPE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
