package fit.d6.candy.command.nms.v1_16_5.item;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fit.d6.candy.api.command.item.ItemInput;
import net.minecraft.server.v1_16_R3.ArgumentPredicateItemStack;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_16_R3.util.CraftMagicNumbers;
import org.bukkit.inventory.ItemStack;

public class ItemInputV1_16_5 implements ItemInput {

    private final ArgumentPredicateItemStack nmsInput;

    public ItemInputV1_16_5(ArgumentPredicateItemStack nms) {
        this.nmsInput = nms;
    }

    @Override
    public boolean test(ItemStack itemStack) {
        return this.nmsInput.test(CraftItemStack.asNMSCopy(itemStack));
    }

    @Override
    public Material getType() {
        return CraftMagicNumbers.getMaterial(this.nmsInput.a());
    }

    @Override
    public ItemStack createItemStack(int amount, boolean checkOverstack) throws CommandSyntaxException {
        return CraftItemStack.asBukkitCopy(this.nmsInput.a(amount, checkOverstack));
    }

}
