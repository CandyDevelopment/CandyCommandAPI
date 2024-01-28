package fit.d6.candy.nms.v1_18_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.ParticleArgument;

public class ParticleArgumentV1_18_2 extends ArgumentTypeV1_18_2 {

    public final static ParticleArgumentV1_18_2 PARTICLE = new ParticleArgumentV1_18_2();

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
