package fit.d6.candy.command.nms.v1_18_2.item;

import fit.d6.candy.api.command.item.BlockInput;
import net.minecraft.core.BlockPos;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.block.data.CraftBlockData;

public class BlockInputV1_18_2 implements BlockInput {

    private final net.minecraft.commands.arguments.blocks.BlockInput nmsInput;

    public BlockInputV1_18_2(net.minecraft.commands.arguments.blocks.BlockInput nms) {
        this.nmsInput = nms;
    }

    @Override
    public Material getType() {
        return this.nmsInput.getState().getBukkitMaterial();
    }

    @Override
    public BlockData getBlockData() {
        return CraftBlockData.fromData(this.nmsInput.getState());
    }

    @Override
    public Block place(Location location, int flags) {
        BlockPos blockPos = new BlockPos(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        this.nmsInput.place(((CraftWorld) location.getWorld()).getHandle(), blockPos, flags);
        return location.getBlock();
    }

}
