package fit.d6.candy.command.nms.v1_20_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.command.nms.v1_20_2.CommandManagerV1_20_2;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantmentArgumentV1_20_2 extends ArgumentTypeV1_20_2 {

    public final static EnchantmentArgumentV1_20_2 ENCHANTMENT = new EnchantmentArgumentV1_20_2();

    private final ResourceArgument<Enchantment> argument = ResourceArgument.resource(CommandManagerV1_20_2.COMMAND_REGISTRY_ACCESS, Registries.ENCHANTMENT);

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ENCHANTMENT;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
