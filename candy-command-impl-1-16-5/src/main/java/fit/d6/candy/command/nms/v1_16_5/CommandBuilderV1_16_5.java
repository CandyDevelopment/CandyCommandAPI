package fit.d6.candy.command.nms.v1_16_5;

import com.mojang.brigadier.builder.ArgumentBuilder;
import fit.d6.candy.api.command.CommandBuilder;
import net.minecraft.server.v1_16_R3.CommandListenerWrapper;

public abstract class CommandBuilderV1_16_5<T extends ArgumentBuilder<CommandListenerWrapper, T>> implements CommandBuilder {

    public abstract T toBrigadier();

}
