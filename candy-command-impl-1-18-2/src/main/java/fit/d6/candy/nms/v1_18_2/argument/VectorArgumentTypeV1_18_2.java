package fit.d6.candy.nms.v1_18_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.coordinates.Vec3Argument;

public class VectorArgumentTypeV1_18_2 extends ArgumentTypeV1_18_2 {

    public final static VectorArgumentTypeV1_18_2 CENTER = new VectorArgumentTypeV1_18_2(true);
    public final static VectorArgumentTypeV1_18_2 NO_CENTER = new VectorArgumentTypeV1_18_2(false);

    private final Vec3Argument argument;

    public VectorArgumentTypeV1_18_2(boolean b) {
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
