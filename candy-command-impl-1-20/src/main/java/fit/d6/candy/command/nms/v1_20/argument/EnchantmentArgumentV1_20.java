package fit.d6.candy.command.nms.v1_20.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_20.CommandManagerV1_20;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantmentArgumentV1_20 extends ArgumentTypeV1_20 {

    public final static EnchantmentArgumentV1_20 ENCHANTMENT = new EnchantmentArgumentV1_20();

    private final ResourceArgument<Enchantment> argument = ResourceArgument.resource(CommandManagerV1_20.COMMAND_REGISTRY_ACCESS, Registries.ENCHANTMENT);

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ENCHANTMENT;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
