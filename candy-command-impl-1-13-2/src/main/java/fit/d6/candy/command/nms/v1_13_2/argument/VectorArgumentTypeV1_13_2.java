package fit.d6.candy.command.nms.v1_13_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_13_R2.ArgumentVec3;

public class VectorArgumentTypeV1_13_2 extends ArgumentTypeV1_13_2 {

    public final static VectorArgumentTypeV1_13_2 CENTER = new VectorArgumentTypeV1_13_2(true);
    public final static VectorArgumentTypeV1_13_2 NO_CENTER = new VectorArgumentTypeV1_13_2(false);

    private final ArgumentVec3 argument;

    public VectorArgumentTypeV1_13_2(boolean b) {
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
