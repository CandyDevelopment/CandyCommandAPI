package fit.d6.candy.command.nms.v1_13_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_13_R2.ArgumentEnchantment;

public class EnchantmentArgumentV1_13_2 extends ArgumentTypeV1_13_2 {

    public final static EnchantmentArgumentV1_13_2 ENCHANTMENT = new EnchantmentArgumentV1_13_2();

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
