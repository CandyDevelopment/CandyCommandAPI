package fit.d6.candy.command.nms.v1_20.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_20.CommandManagerV1_20;
import net.minecraft.commands.arguments.ParticleArgument;

public class ParticleArgumentV1_20 extends ArgumentTypeV1_20 {

    public final static ParticleArgumentV1_20 PARTICLE = new ParticleArgumentV1_20();

    private final ParticleArgument argument = ParticleArgument.particle(CommandManagerV1_20.COMMAND_REGISTRY_ACCESS);

    @Override
    public ArgumentTypes getType() {

        return ArgumentTypes.PARTICLE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
