package fit.d6.candy.command.nms.v1_19_3.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_19_3.CommandManagerV1_19_3;
import net.minecraft.commands.arguments.ParticleArgument;

public class ParticleArgumentV1_19_3 extends ArgumentTypeV1_19_3 {

    public final static ParticleArgumentV1_19_3 PARTICLE = new ParticleArgumentV1_19_3();

    private final ParticleArgument argument = ParticleArgument.particle(CommandManagerV1_19_3.COMMAND_REGISTRY_ACCESS);

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.PARTICLE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
