package fit.d6.candy.command.nms.v1_19_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.AngleArgument;

public class AngleArgumentTypeV1_19_1 extends ArgumentTypeV1_19_1 {

    public final static AngleArgumentTypeV1_19_1 ANGLE = new AngleArgumentTypeV1_19_1();

    private final AngleArgument argument = AngleArgument.angle();

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ANGLE;
    }

}
