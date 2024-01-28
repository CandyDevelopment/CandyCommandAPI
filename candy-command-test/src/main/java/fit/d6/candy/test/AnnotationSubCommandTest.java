package fit.d6.candy.test;

import fit.d6.candy.api.command.annotation.Alias;
import fit.d6.candy.api.command.annotation.Command;
import fit.d6.candy.api.command.annotation.Executor;
import fit.d6.candy.api.command.annotation.Sender;
import org.bukkit.command.CommandSender;

@Command(name = "sub")
public class AnnotationSubCommandTest {

    @Executor
    public void executeFirst(@Sender CommandSender sender, @Alias String alias) {
        sender.sendMessage("You invoked sub command with alais " + alias);
    }

}
