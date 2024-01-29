package fit.d6.candy.command.nms.v1_18_2;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.exceptions.CommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.tree.CommandNode;
import fit.d6.candy.api.command.ArgumentType;
import fit.d6.candy.api.command.Command;
import fit.d6.candy.api.command.CommandBuilder;
import fit.d6.candy.api.command.CommandManager;
import fit.d6.candy.command.nms.v1_18_2.argument.ArgumentTypeV1_18_2;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.craftbukkit.v1_18_R2.command.VanillaCommandWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerLoadEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManagerV1_18_2 implements CommandManager {

    public final static CommandExceptionType CANDY_COMMAND_EXCEPTION = new SimpleCommandExceptionType(new LiteralMessage("Candy Command API Error"));

    private static final Map<String, List<Command>> REGISTERED = new HashMap<>();

    @Override
    public CommandBuilder createCommand(String name) {
        return new LiteralCommandBuilderV1_18_2(name.toLowerCase());
    }

    @Override
    public CommandBuilder createCommand(String name, ArgumentType argumentType) {
        return new ArgumentBuilderV1_18_2(name.toLowerCase(), (ArgumentTypeV1_18_2) argumentType);
    }

    @Override
    public Command register(CommandBuilder builder) {
        return this.register("candycmd", builder);
    }

    @Override
    public Command register(String prefix, CommandBuilder builder) {
        prefix = prefix.toLowerCase();
        if (!REGISTERED.containsKey(prefix))
            REGISTERED.put(prefix, new ArrayList<>());
        CommandNode<CommandSourceStack> commandNode = ((CommandBuilderV1_18_2<?>) builder).toBrigadier().build();
        if (builder instanceof LiteralCommandBuilderV1_18_2) {
            VanillaCommandWrapper wrappedCommand = new VanillaCommandWrapper(null, commandNode);
            Bukkit.getCommandMap().register(prefix, wrappedCommand);
        }
        Command command = new CommandV1_18_2(commandNode);
        REGISTERED.get(prefix).add(command);
        return command;
    }

    @EventHandler
    public void onLoad(ServerLoadEvent event) {
        Commands bukkitCommands = MinecraftServer.getServer().getCommands(); // Name this with bukkit because actually bukkit created a new one replace the vanilla one
        CommandMap commandMap = Bukkit.getCommandMap();

        Map<String, org.bukkit.command.Command> knownCommands = commandMap.getKnownCommands();

        for (String prefix : REGISTERED.keySet()) {
            for (Command command : REGISTERED.get(prefix)) {
                CommandNode<CommandSourceStack> commandNode = ((CommandV1_18_2) command).toBrigadier();

                org.bukkit.command.Command vanillaWrapper = knownCommands.get(command.getName());
                org.bukkit.command.Command prefixVanillaWrapper = knownCommands.get(prefix + ":" + command.getName());

                VanillaCommandWrapper commandWrapper = new VanillaCommandWrapper(bukkitCommands, commandNode);

                if (vanillaWrapper != null) {
                    knownCommands.put(command.getName(), commandWrapper);
                }

                if (prefixVanillaWrapper != null) {
                    knownCommands.put(prefix + ":" + command.getName(), commandWrapper);
                }
            }
        }
    }

}
