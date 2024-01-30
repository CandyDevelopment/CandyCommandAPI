package fit.d6.candy.command.nms.v1_14_4;

import com.mojang.brigadier.builder.ArgumentBuilder;
import fit.d6.candy.api.command.CommandBuilder;
import net.minecraft.server.v1_14_R1.CommandListenerWrapper;

public abstract class CommandBuilderV1_14_4<T extends ArgumentBuilder<CommandListenerWrapper, T>> implements CommandBuilder {

    public abstract T toBrigadier();

}
