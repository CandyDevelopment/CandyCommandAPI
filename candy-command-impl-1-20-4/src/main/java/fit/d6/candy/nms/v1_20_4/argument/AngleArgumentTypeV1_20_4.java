package fit.d6.candy.nms.v1_20_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.AngleArgument;

public class AngleArgumentTypeV1_20_4 extends ArgumentTypeV1_20_4 {

    public final static AngleArgumentTypeV1_20_4 ANGLE = new AngleArgumentTypeV1_20_4();

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
