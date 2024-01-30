package fit.d6.candy.command.nms.v1_15_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_15_R1.ArgumentParticle;

public class ParticleArgumentV1_15_2 extends ArgumentTypeV1_15_2 {

    public final static ParticleArgumentV1_15_2 PARTICLE = new ParticleArgumentV1_15_2();

    private final ArgumentParticle argument = ArgumentParticle.a();

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.PARTICLE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
