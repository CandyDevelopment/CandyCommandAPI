package fit.d6.candy.api.command.item;

import org.bukkit.inventory.ItemStack;

public interface ItemPredicate {

    boolean check(ItemStack itemStack);

}
