package fit.d6.candy.nms.v1_20_4;

import com.mojang.brigadier.builder.ArgumentBuilder;
import fit.d6.candy.api.command.CommandBuilder;
import net.minecraft.commands.CommandSourceStack;

public abstract class CommandBuilderV1_20_4<T extends ArgumentBuilder<CommandSourceStack, T>> implements CommandBuilder {

    public abstract T toBrigadier();

}
