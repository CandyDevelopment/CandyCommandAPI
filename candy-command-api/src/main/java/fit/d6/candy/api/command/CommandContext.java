package fit.d6.candy.api.command;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface CommandContext {

    CommandArgumentHelper getArgument();

    CommandSender getSender();

    Player getPlayer() throws CommandSyntaxException;

    String getAlias();

    boolean isPlayer();

    String getRawCommand();

}
