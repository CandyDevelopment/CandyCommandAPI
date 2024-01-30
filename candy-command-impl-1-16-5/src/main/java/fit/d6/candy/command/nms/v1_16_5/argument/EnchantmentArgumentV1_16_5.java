package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_16_R3.ArgumentEnchantment;

public class EnchantmentArgumentV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static EnchantmentArgumentV1_16_5 ENCHANTMENT = new EnchantmentArgumentV1_16_5();

    private final ArgumentEnchantment argument = ArgumentEnchantment.a();

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ENCHANTMENT;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

}
