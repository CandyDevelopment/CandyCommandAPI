package fit.d6.candy.command.nms.v1_15_2.item;

import fit.d6.candy.api.command.item.BlockInput;
import net.minecraft.server.v1_15_R1.ArgumentTileLocation;
import net.minecraft.server.v1_15_R1.BlockPosition;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_15_R1.util.CraftMagicNumbers;

public class BlockInputV1_15_2 implements BlockInput {

    private final ArgumentTileLocation nmsInput;

    public BlockInputV1_15_2(ArgumentTileLocation nms) {
        this.nmsInput = nms;
    }

    @Override
    public Material getType() {
        return CraftMagicNumbers.getMaterial(this.nmsInput.a()).getItemType();
    }

    @Override
    public BlockData getBlockData() {
        return CraftBlockData.fromData(this.nmsInput.a());
    }

    @Override
    public Block place(Location location, int flags) {
        BlockPosition blockPos = new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        this.nmsInput.a(((CraftWorld) location.getWorld()).getHandle(), blockPos, flags);
        return location.getBlock();
    }

}
