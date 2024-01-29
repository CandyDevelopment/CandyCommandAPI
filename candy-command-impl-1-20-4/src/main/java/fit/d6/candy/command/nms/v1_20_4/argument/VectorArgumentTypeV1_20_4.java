package fit.d6.candy.command.nms.v1_20_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.coordinates.Vec3Argument;

public class VectorArgumentTypeV1_20_4 extends ArgumentTypeV1_20_4 {

    public final static VectorArgumentTypeV1_20_4 CENTER = new VectorArgumentTypeV1_20_4(true);
    public final static VectorArgumentTypeV1_20_4 NO_CENTER = new VectorArgumentTypeV1_20_4(false);

    private final Vec3Argument argument;

    public VectorArgumentTypeV1_20_4(boolean b) {
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
