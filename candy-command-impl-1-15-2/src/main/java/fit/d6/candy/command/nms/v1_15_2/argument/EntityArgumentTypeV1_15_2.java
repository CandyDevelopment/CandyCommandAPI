package fit.d6.candy.command.nms.v1_15_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_15_R1.ArgumentEntity;

public class EntityArgumentTypeV1_15_2 extends ArgumentTypeV1_15_2 {

    public final static EntityArgumentTypeV1_15_2 SINGLE_ENTITY = new EntityArgumentTypeV1_15_2(ArgumentEntity.a(), ArgumentTypes.SINGLE_ENTITY);
    public final static EntityArgumentTypeV1_15_2 ENTITIES = new EntityArgumentTypeV1_15_2(ArgumentEntity.multipleEntities(), ArgumentTypes.ENTITIES);
    public final static EntityArgumentTypeV1_15_2 SINGLE_PLAYER = new EntityArgumentTypeV1_15_2(ArgumentEntity.c(), ArgumentTypes.SINGLE_PLAYER);
    public final static EntityArgumentTypeV1_15_2 PLAYERS = new EntityArgumentTypeV1_15_2(ArgumentEntity.d(), ArgumentTypes.PLAYERS);

    private final ArgumentEntity argument;
    private final ArgumentTypes types;

    public EntityArgumentTypeV1_15_2(ArgumentEntity argument, ArgumentTypes types) {
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
