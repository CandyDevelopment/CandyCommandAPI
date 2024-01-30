package fit.d6.candy.command.nms.v1_19_3.item;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fit.d6.candy.api.command.item.ItemInput;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_19_R2.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_19_R2.util.CraftMagicNumbers;
import org.bukkit.inventory.ItemStack;

public class ItemInputV1_19_3 implements ItemInput {

    private final net.minecraft.commands.arguments.item.ItemInput nmsInput;

    public ItemInputV1_19_3(net.minecraft.commands.arguments.item.ItemInput nms) {
        this.nmsInput = nms;
    }

    @Override
    public boolean test(ItemStack itemStack) {
        return this.nmsInput.test(CraftItemStack.asNMSCopy(itemStack));
    }

    @Override
    public Material getType() {
        return CraftMagicNumbers.getMaterial(this.nmsInput.getItem());
    }

    @Override
    public ItemStack createItemStack(int amount, boolean checkOverstack) throws CommandSyntaxException {
        return CraftItemStack.asBukkitCopy(this.nmsInput.createItemStack(amount, checkOverstack));
    }

}
