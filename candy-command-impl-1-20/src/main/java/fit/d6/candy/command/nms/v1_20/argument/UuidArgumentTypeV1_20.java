package fit.d6.candy.command.nms.v1_20.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.UuidArgument;

import java.util.UUID;

public class UuidArgumentTypeV1_20 extends ArgumentTypeV1_20 {

    public final static UuidArgumentTypeV1_20 UUID = new UuidArgumentTypeV1_20();

    private final static UuidArgument ARGUMENT_TYPE = UuidArgument.uuid();

    private UuidArgumentTypeV1_20() {
    }

    @Override
    public ArgumentType<UUID> toBrigadier() {
        return ARGUMENT_TYPE;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.UUID;
    }
}
