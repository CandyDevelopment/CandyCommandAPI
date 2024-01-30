package fit.d6.candy.command.nms.v1_19_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.coordinates.Vec3Argument;

public class VectorArgumentTypeV1_19_1 extends ArgumentTypeV1_19_1 {

    public final static VectorArgumentTypeV1_19_1 CENTER = new VectorArgumentTypeV1_19_1(true);
    public final static VectorArgumentTypeV1_19_1 NO_CENTER = new VectorArgumentTypeV1_19_1(false);

    private final Vec3Argument argument;

    public VectorArgumentTypeV1_19_1(boolean b) {
        this.argument = Vec3Argument.vec3(b);
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
