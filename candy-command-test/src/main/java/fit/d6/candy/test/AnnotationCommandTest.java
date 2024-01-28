package fit.d6.candy.test;

import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.api.command.annotation.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

@Command(name = "annotest")
public class AnnotationCommandTest {

    @SubCommand(name = "sub")
    public final AnnotationSubCommandTest sub = new AnnotationSubCommandTest();

    @Requirement
    public boolean check(CommandSender sender) {
        return true;
    }

    @Executor
    public void executeFirst(@Sender CommandSender sender, @Alias String alias) {
        sender.sendMessage("You just invoked a normal message with alias " + alias);
    }

    @Executor
    @RequiresPlayer
    @SubCommand(name = "second")
    public void executeSecond(@Sender CommandSender sender, @Alias String alias, @Argument(type = ArgumentTypes.STRING, name = "name") String name) {
        sender.sendMessage("Your name is " + name);
    }

    @Executor
    @SubCommand(name = "playertest")
    public void playersTest(@Sender CommandSender sender, @Argument(type = ArgumentTypes.PLAYERS, name = "selector") Set<Player> players) {
        sender.sendMessage("You selected: " + players);
        for (Player player : players)
            player.sendMessage("You are selected by commander");
    }

}
