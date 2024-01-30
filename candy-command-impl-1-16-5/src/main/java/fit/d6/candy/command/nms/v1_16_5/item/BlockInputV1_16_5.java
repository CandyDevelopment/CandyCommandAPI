package fit.d6.candy.command.nms.v1_16_5.item;

import fit.d6.candy.api.command.item.BlockInput;
import net.minecraft.server.v1_16_R3.ArgumentTileLocation;
import net.minecraft.server.v1_16_R3.BlockPosition;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_16_R3.util.CraftMagicNumbers;

public class BlockInputV1_16_5 implements BlockInput {

    private final ArgumentTileLocation nmsInput;

    public BlockInputV1_16_5(ArgumentTileLocation nms) {
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
