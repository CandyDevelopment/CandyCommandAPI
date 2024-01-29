package fit.d6.candy.command.nms.v1_20_4.item;

import fit.d6.candy.api.command.item.BlockInput;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R3.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_20_R3.util.CraftLocation;

public class BlockInputV1_20_4 implements BlockInput {

    private final net.minecraft.commands.arguments.blocks.BlockInput nmsInput;

    public BlockInputV1_20_4(net.minecraft.commands.arguments.blocks.BlockInput nms) {
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
        this.nmsInput.place(((CraftWorld) location.getWorld()).getHandle(), CraftLocation.toBlockPosition(location), flags);
        return location.getBlock();
    }

}
