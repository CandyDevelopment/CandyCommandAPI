package fit.d6.candy.command.nms.v1_14_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_14_R1.ArgumentParticle;

public class ParticleArgumentV1_14_4 extends ArgumentTypeV1_14_4 {

    public final static ParticleArgumentV1_14_4 PARTICLE = new ParticleArgumentV1_14_4();

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
