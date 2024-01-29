package fit.d6.candy.command.nms.v1_19_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_19_4.CommandManagerV1_19_4;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;

public class SummonableEntityTypeArgumentV1_19_4 extends ArgumentTypeV1_19_4 {

    public final static SummonableEntityTypeArgumentV1_19_4 SUMMONABLE_ENTITY_TYPE = new SummonableEntityTypeArgumentV1_19_4();

    private final ResourceArgument<EntityType<?>> argument = ResourceArgument.resource(CommandManagerV1_19_4.COMMAND_REGISTRY_ACCESS, Registries.ENTITY_TYPE);

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.SUMMONABLE_ENTITY_TYPE;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
