package fit.d6.candy.command.nms.v1_20_4.item;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fit.d6.candy.api.command.item.ItemInput;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_20_R3.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_20_R3.util.CraftMagicNumbers;
import org.bukkit.inventory.ItemStack;

public class ItemInputV1_20_4 implements ItemInput {

    private final net.minecraft.commands.arguments.item.ItemInput nmsInput;

    public ItemInputV1_20_4(net.minecraft.commands.arguments.item.ItemInput nms) {
        this.nmsInput = nms;
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
