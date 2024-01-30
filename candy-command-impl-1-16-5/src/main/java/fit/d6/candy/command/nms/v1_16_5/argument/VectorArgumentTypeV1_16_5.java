package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_16_R3.ArgumentVec3;

public class VectorArgumentTypeV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static VectorArgumentTypeV1_16_5 CENTER = new VectorArgumentTypeV1_16_5(true);
    public final static VectorArgumentTypeV1_16_5 NO_CENTER = new VectorArgumentTypeV1_16_5(false);

    private final ArgumentVec3 argument;

    public VectorArgumentTypeV1_16_5(boolean b) {
        this.argument = ArgumentVec3.a(b);
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.VECTOR;
    }
}
