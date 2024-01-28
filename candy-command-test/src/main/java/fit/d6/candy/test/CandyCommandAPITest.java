package fit.d6.candy.test;

import fit.d6.candy.api.command.CommandService;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CandyCommandAPITest extends JavaPlugin {

    @Override
    public void onEnable() {
        CommandService service = CommandService.getService();

        service.getAnnotationCommandManager().register(new AnnotationCommandTest());

        service.getCommandManager().register(
                "candyprefix",
                service.getCommandManager().createCommand("candytest")
                        .executes((context, argument) -> {
                            context.getSender().sendMessage("You invoked a message!");
                            return 1;
                        })
                        .then(service.getCommandManager().createCommand("argument")
                                .then(service.getCommandManager().createCommand("player")
                                        .then(service.getCommandManager().createCommand("players", service.getArgumentManager().players())
                                                .executes((context, argument) -> {
                                                    for (Player player : argument.getPlayers("players")) {
                                                        player.sendMessage(Component.text("You are selected!"));
                                                    }
                                                    return 1;
                                                })))
                                .then(service.getCommandManager().createCommand("particle")
                                        .then(service.getCommandManager().createCommand("particletype", service.getArgumentManager().particle())
                                                .executesPlayer((context, argument) -> {
                                                    Player player = context.getPlayer();

                                                    player.getWorld().spawnParticle(argument.getParticle("particletype"), player.getLocation(), 10);

                                                    return 1;
                                                })))
                                .then(service.getCommandManager().createCommand("string")
                                        .then(service.getCommandManager().createCommand("name", service.getArgumentManager().stringArg())
                                                .suggests((context, argument, suggestion) -> {
                                                    suggestion.suggests("DeeChael", Component.text("Main maintainer of Candy Command API"))
                                                            .suggests("Nostal Yuu", Component.text("Main maintainer's friend"));
                                                })
                                                .executes((context, argument) -> {
                                                    context.getSender().sendMessage("You type the name with " + argument.getString("name"));
                                                    return 1;
                                                })))
                                .then(service.getCommandManager().createCommand("integer")
                                        .then(service.getCommandManager().createCommand("age", service.getArgumentManager().integerArg(2, 7))
                                                .executes((context, argument) -> {
                                                    context.getSender().sendMessage("You type the age with " + argument.getInteger("age"));
                                                    return 1;
                                                })))
                                .then(service.getCommandManager().createCommand("bool")
                                        .then(service.getCommandManager().createCommand("enable", service.getArgumentManager().integerArg(2, 7))
                                                .executes((context, argument) -> {
                                                    context.getSender().sendMessage("Your status is " + argument.getBoolean("enable"));
                                                    return 1;
                                                }))))
                        .then(service.getCommandManager().createCommand("literal")
                                .executes((context, argument) -> {
                                    context.getSender().sendMessage("You are in a sub command");
                                    return 1;
                                }))
        );
    }

}
