package fit.d6.candy.command.nms.v1_13_2;

import com.mojang.brigadier.builder.ArgumentBuilder;
import fit.d6.candy.api.command.CommandBuilder;
import net.minecraft.server.v1_13_R2.CommandListenerWrapper;

public abstract class CommandBuilderV1_13_2<T extends ArgumentBuilder<CommandListenerWrapper, T>> implements CommandBuilder {

    public abstract T toBrigadier();

}
