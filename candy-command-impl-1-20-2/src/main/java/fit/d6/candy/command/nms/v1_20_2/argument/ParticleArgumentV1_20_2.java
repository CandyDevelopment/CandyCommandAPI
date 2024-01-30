package fit.d6.candy.command.nms.v1_20_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_20_2.CommandManagerV1_20_2;
import net.minecraft.commands.arguments.ParticleArgument;

public class ParticleArgumentV1_20_2 extends ArgumentTypeV1_20_2 {

    public final static ParticleArgumentV1_20_2 PARTICLE = new ParticleArgumentV1_20_2();

    private final ParticleArgument argument = ParticleArgument.particle(CommandManagerV1_20_2.COMMAND_REGISTRY_ACCESS);

    @Override
    public ArgumentTypes getType() {

        return ArgumentTypes.PARTICLE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
