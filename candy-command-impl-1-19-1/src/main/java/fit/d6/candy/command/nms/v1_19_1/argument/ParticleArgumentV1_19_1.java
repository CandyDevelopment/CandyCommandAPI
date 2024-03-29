package fit.d6.candy.command.nms.v1_19_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.ParticleArgument;

public class ParticleArgumentV1_19_1 extends ArgumentTypeV1_19_1 {

    public final static ParticleArgumentV1_19_1 PARTICLE = new ParticleArgumentV1_19_1();

    private final ParticleArgument argument = ParticleArgument.particle();

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.PARTICLE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
