package fit.d6.candy.command.nms.v1_14_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_14_R1.ArgumentVec3;

public class VectorArgumentTypeV1_14_4 extends ArgumentTypeV1_14_4 {

    public final static VectorArgumentTypeV1_14_4 CENTER = new VectorArgumentTypeV1_14_4(true);
    public final static VectorArgumentTypeV1_14_4 NO_CENTER = new VectorArgumentTypeV1_14_4(false);

    private final ArgumentVec3 argument;

    public VectorArgumentTypeV1_14_4(boolean b) {
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
