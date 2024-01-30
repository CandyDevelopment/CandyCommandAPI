package fit.d6.candy.command.nms.v1_18.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.ItemEnchantmentArgument;

public class EnchantmentArgumentV1_18 extends ArgumentTypeV1_18 {

    public final static EnchantmentArgumentV1_18 ENCHANTMENT = new EnchantmentArgumentV1_18();

    private final ItemEnchantmentArgument argument = ItemEnchantmentArgument.enchantment();

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ENCHANTMENT;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
