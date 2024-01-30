package fit.d6.candy.command.nms.v1_19_1.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.ItemEnchantmentArgument;

public class EnchantmentArgumentV1_19_1 extends ArgumentTypeV1_19_1 {

    public final static EnchantmentArgumentV1_19_1 ENCHANTMENT = new EnchantmentArgumentV1_19_1();

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
