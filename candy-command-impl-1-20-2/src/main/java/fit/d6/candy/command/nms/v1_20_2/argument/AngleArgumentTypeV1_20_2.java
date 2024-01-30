package fit.d6.candy.command.nms.v1_20_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.AngleArgument;

public class AngleArgumentTypeV1_20_2 extends ArgumentTypeV1_20_2 {

    public final static AngleArgumentTypeV1_20_2 ANGLE = new AngleArgumentTypeV1_20_2();

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
