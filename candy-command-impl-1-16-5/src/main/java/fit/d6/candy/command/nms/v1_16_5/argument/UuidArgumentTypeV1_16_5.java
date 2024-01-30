package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_16_R3.ArgumentUUID;

import java.util.UUID;

public class UuidArgumentTypeV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static UuidArgumentTypeV1_16_5 UUID = new UuidArgumentTypeV1_16_5();

    private final static ArgumentUUID ARGUMENT_TYPE = ArgumentUUID.a();

    private UuidArgumentTypeV1_16_5() {
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
