package fit.d6.candy.command.nms.v1_19_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.UuidArgument;

import java.util.UUID;

public class UuidArgumentTypeV1_19_1 extends ArgumentTypeV1_19_1 {

    public final static UuidArgumentTypeV1_19_1 UUID = new UuidArgumentTypeV1_19_1();

    private final static UuidArgument ARGUMENT_TYPE = UuidArgument.uuid();

    private UuidArgumentTypeV1_19_1() {
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
