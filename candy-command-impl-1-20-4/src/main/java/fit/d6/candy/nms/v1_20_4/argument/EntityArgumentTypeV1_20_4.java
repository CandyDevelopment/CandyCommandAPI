package fit.d6.candy.nms.v1_20_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.EntityArgument;

public class EntityArgumentTypeV1_20_4 extends ArgumentTypeV1_20_4 {

    public final static EntityArgumentTypeV1_20_4 SINGLE_ENTITY = new EntityArgumentTypeV1_20_4(EntityArgument.entity(), ArgumentTypes.SINGLE_ENTITY);
    public final static EntityArgumentTypeV1_20_4 ENTITIES = new EntityArgumentTypeV1_20_4(EntityArgument.entities(), ArgumentTypes.ENTITIES);
    public final static EntityArgumentTypeV1_20_4 SINGLE_PLAYER = new EntityArgumentTypeV1_20_4(EntityArgument.player(), ArgumentTypes.SINGLE_PLAYER);
    public final static EntityArgumentTypeV1_20_4 PLAYERS = new EntityArgumentTypeV1_20_4(EntityArgument.players(), ArgumentTypes.PLAYERS);

    private final EntityArgument argument;
    private final ArgumentTypes types;

    public EntityArgumentTypeV1_20_4(EntityArgument argument, ArgumentTypes types) {
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
