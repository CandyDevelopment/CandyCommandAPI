package fit.d6.candy.command.nms.v1_18.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.AngleArgument;

public class AngleArgumentTypeV1_18 extends ArgumentTypeV1_18 {

    public final static AngleArgumentTypeV1_18 ANGLE = new AngleArgumentTypeV1_18();

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
