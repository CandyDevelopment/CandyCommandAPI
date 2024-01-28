package fit.d6.candy.api.command;

import org.bukkit.Bukkit;

public interface CommandService {

    AnnotationCommandManager getAnnotationCommandManager();

    CommandManager getCommandManager();

    ArgumentManager getArgumentManager();

    static CommandService getService() {
        return (CommandService) Bukkit.getPluginManager().getPlugin("CandyCommandAPI");
    }

}
