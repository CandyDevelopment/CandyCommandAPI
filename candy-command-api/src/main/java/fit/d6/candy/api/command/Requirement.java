package fit.d6.candy.api.command;

import org.bukkit.command.CommandSender;

@FunctionalInterface
public interface Requirement {

    boolean check(CommandSender sender);

}
