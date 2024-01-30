package fit.d6.candy.command.nms.v1_19_1.item;

import fit.d6.candy.api.command.item.BlockInput;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R1.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_19_R1.util.CraftVector;

public class BlockInputV1_19_1 implements BlockInput {

    private final net.minecraft.commands.arguments.blocks.BlockInput nmsInput;

    public BlockInputV1_19_1(net.minecraft.commands.arguments.blocks.BlockInput nms) {
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
        this.nmsInput.place(((CraftWorld) location.getWorld()).getHandle(), CraftVector.toBlockPos(location.toVector()), flags);
        return location.getBlock();
    }

}
