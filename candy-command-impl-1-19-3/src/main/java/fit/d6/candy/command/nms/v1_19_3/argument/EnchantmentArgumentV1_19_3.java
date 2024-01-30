package fit.d6.candy.command.nms.v1_19_3.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_19_3.CommandManagerV1_19_3;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantmentArgumentV1_19_3 extends ArgumentTypeV1_19_3 {

    public final static EnchantmentArgumentV1_19_3 ENCHANTMENT = new EnchantmentArgumentV1_19_3();

    private final ResourceArgument<Enchantment> argument = ResourceArgument.resource(CommandManagerV1_19_3.COMMAND_REGISTRY_ACCESS, Registries.ENCHANTMENT);

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ENCHANTMENT;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
