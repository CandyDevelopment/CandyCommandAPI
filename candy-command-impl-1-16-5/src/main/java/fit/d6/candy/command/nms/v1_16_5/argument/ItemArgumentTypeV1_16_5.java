package fit.d6.candy.command.nms.v1_16_5.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.server.v1_16_R3.ArgumentItemStack;

public class ItemArgumentTypeV1_16_5 extends ArgumentTypeV1_16_5 {

    public final static ItemArgumentTypeV1_16_5 ITEM = new ItemArgumentTypeV1_16_5();

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
