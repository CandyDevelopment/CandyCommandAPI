package fit.d6.candy.command.nms.v1_14_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_14_R1.ArgumentItemStack;

public class ItemArgumentTypeV1_14_4 extends ArgumentTypeV1_14_4 {

    public final static ItemArgumentTypeV1_14_4 ITEM = new ItemArgumentTypeV1_14_4();

    private final ArgumentItemStack argument = ArgumentItemStack.a();

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.ITEM;
    }

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }
}
