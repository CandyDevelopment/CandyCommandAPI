package fit.d6.candy.api.command.item;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public interface ItemInput {

    Material getType();

    ItemStack createItemStack(int amount, boolean checkOverstack) throws CommandSyntaxException;

}
