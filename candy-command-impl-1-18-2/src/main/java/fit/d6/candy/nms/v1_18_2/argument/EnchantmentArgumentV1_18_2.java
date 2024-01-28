package fit.d6.candy.nms.v1_18_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.ItemEnchantmentArgument;

public class EnchantmentArgumentV1_18_2 extends ArgumentTypeV1_18_2 {

    public final static EnchantmentArgumentV1_18_2 ENCHANTMENT = new EnchantmentArgumentV1_18_2();

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
