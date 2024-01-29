package fit.d6.candy.command.nms.v1_19_4;

import com.mojang.brigadier.builder.ArgumentBuilder;
import fit.d6.candy.api.command.CommandBuilder;
import net.minecraft.commands.CommandSourceStack;

public abstract class CommandBuilderV1_19_4<T extends ArgumentBuilder<CommandSourceStack, T>> implements CommandBuilder {

    public abstract T toBrigadier();

}
