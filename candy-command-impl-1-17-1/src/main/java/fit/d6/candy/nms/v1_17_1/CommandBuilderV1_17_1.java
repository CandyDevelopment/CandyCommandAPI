package fit.d6.candy.nms.v1_17_1;

import com.mojang.brigadier.builder.ArgumentBuilder;
import fit.d6.candy.api.command.CommandBuilder;
import net.minecraft.commands.CommandSourceStack;

public abstract class CommandBuilderV1_17_1<T extends ArgumentBuilder<CommandSourceStack, T>> implements CommandBuilder {

    public abstract T toBrigadier();

}
