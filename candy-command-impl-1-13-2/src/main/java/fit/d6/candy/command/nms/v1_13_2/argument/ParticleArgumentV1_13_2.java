package fit.d6.candy.command.nms.v1_13_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_13_R2.ArgumentParticle;

public class ParticleArgumentV1_13_2 extends ArgumentTypeV1_13_2 {

    public final static ParticleArgumentV1_13_2 PARTICLE = new ParticleArgumentV1_13_2();

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
