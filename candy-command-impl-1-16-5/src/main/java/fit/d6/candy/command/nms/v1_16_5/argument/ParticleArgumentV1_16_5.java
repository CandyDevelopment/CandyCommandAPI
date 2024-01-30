package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_16_R3.ArgumentParticle;

public class ParticleArgumentV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static ParticleArgumentV1_16_5 PARTICLE = new ParticleArgumentV1_16_5();

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
