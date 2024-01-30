package fit.d6.candy.command.nms.v1_14_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_14_R1.ArgumentEnchantment;

public class EnchantmentArgumentV1_14_4 extends ArgumentTypeV1_14_4 {

    public final static EnchantmentArgumentV1_14_4 ENCHANTMENT = new EnchantmentArgumentV1_14_4();

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
