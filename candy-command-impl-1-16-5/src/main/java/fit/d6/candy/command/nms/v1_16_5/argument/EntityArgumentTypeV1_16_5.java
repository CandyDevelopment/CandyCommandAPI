package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_16_R3.ArgumentEntity;

public class EntityArgumentTypeV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static EntityArgumentTypeV1_16_5 SINGLE_ENTITY = new EntityArgumentTypeV1_16_5(ArgumentEntity.a(), ArgumentTypes.SINGLE_ENTITY);
    public final static EntityArgumentTypeV1_16_5 ENTITIES = new EntityArgumentTypeV1_16_5(ArgumentEntity.multipleEntities(), ArgumentTypes.ENTITIES);
    public final static EntityArgumentTypeV1_16_5 SINGLE_PLAYER = new EntityArgumentTypeV1_16_5(ArgumentEntity.c(), ArgumentTypes.SINGLE_PLAYER);
    public final static EntityArgumentTypeV1_16_5 PLAYERS = new EntityArgumentTypeV1_16_5(ArgumentEntity.d(), ArgumentTypes.PLAYERS);

    private final ArgumentEntity argument;
    private final ArgumentTypes types;

    public EntityArgumentTypeV1_16_5(ArgumentEntity argument, ArgumentTypes types) {
        this.argument = argument;
        this.types = types;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return this.argument;
    }

    @Override
    public ArgumentTypes getType() {
        return types;
    }
}
