package fit.d6.candy.api.command;

import org.bukkit.event.Listener;

public interface CommandManager extends Listener {

    CommandBuilder createCommand(String name);

    CommandBuilder createCommand(String name, ArgumentType argumentType);

    /**
     * Only literal command will be registered, argument command will only be built
     *
     * @param builder command builder
     * @return built command
     */
    Command register(CommandBuilder builder);

    /**
     * Only literal command will be registered, argument command will only be built
     *
     * @param prefix  command prefix
     * @param builder command builder
     * @return built command
     */
    Command register(String prefix, CommandBuilder builder);

}
