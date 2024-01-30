package fit.d6.candy.command.nms.v1_18;

import com.mojang.brigadier.builder.ArgumentBuilder;
import fit.d6.candy.api.command.CommandBuilder;
import net.minecraft.commands.CommandSourceStack;

public abstract class CommandBuilderV1_18<T extends ArgumentBuilder<CommandSourceStack, T>> implements CommandBuilder {

    public abstract T toBrigadier();

}
