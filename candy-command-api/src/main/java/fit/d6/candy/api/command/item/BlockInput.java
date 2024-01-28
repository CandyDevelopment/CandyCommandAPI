package fit.d6.candy.api.command.item;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

public interface BlockInput {

    Material getType();

    BlockData getBlockData();

    /**
     * Place the block into the world
     *
     * @param location where to place
     * @param flags    default is 2, its function is unknown
     * @return placed block
     */
    Block place(Location location, int flags);

}
