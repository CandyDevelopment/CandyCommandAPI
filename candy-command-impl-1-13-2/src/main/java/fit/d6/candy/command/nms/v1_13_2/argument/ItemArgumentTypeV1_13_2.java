package fit.d6.candy.command.nms.v1_13_2.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_13_R2.ArgumentItemStack;

public class ItemArgumentTypeV1_13_2 extends ArgumentTypeV1_13_2 {

    public final static ItemArgumentTypeV1_13_2 ITEM = new ItemArgumentTypeV1_13_2();

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
