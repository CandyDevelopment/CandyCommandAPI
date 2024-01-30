package fit.d6.candy.command.nms.v1_14_4;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.exceptions.CommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.tree.CommandNode;
import fit.d6.candy.api.command.ArgumentType;
import fit.d6.candy.api.command.Command;
import fit.d6.candy.api.command.CommandBuilder;
import fit.d6.candy.api.command.CommandManager;
import fit.d6.candy.command.nms.v1_14_4.argument.ArgumentTypeV1_14_4;
import net.minecraft.server.v1_14_R1.CommandDispatcher;
import net.minecraft.server.v1_14_R1.CommandListenerWrapper;
import net.minecraft.server.v1_14_R1.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.craftbukkit.v1_14_R1.CraftServer;
import org.bukkit.craftbukkit.v1_14_R1.command.CraftCommandMap;
import org.bukkit.craftbukkit.v1_14_R1.command.VanillaCommandWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerLoadEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManagerV1_14_4 implements CommandManager {

    public final static CommandExceptionType CANDY_COMMAND_EXCEPTION = new SimpleCommandExceptionType(new LiteralMessage("Candy Command API Error"));

    private static final Map<String, List<Command>> REGISTERED = new HashMap<>();

    @Override
    public CommandBuilder createCommand(String name) {
        return new LiteralCommandBuilderV1_14_4(name.toLowerCase());
    }

    @Override
    public CommandBuilder createCommand(String name, ArgumentType argumentType) {
        return new ArgumentBuilderV1_14_4(name.toLowerCase(), (ArgumentTypeV1_14_4) argumentType);
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
        CommandNode<CommandListenerWrapper> commandNode = ((CommandBuilderV1_14_4<?>) builder).toBrigadier().build();
        if (builder instanceof LiteralCommandBuilderV1_14_4) {
            VanillaCommandWrapper wrappedCommand = new VanillaCommandWrapper(null, commandNode);
            ((CraftServer) Bukkit.getServer()).getCommandMap().register(prefix, wrappedCommand);
        }
        Command command = new CommandV1_14_4(commandNode);
        REGISTERED.get(prefix).add(command);
        return command;
    }

    @EventHandler
    public void onLoad(ServerLoadEvent event) {
        CommandDispatcher bukkitCommands = MinecraftServer.getServer().getCommandDispatcher(); // Name this with bukkit because actually bukkit created a new one replace the vanilla one
        CommandMap commandMap = ((CraftServer) Bukkit.getServer()).getCommandMap();

        Map<String, org.bukkit.command.Command> knownCommands = ((CraftCommandMap) commandMap).getKnownCommands();

        for (String prefix : REGISTERED.keySet()) {
            for (Command command : REGISTERED.get(prefix)) {
                CommandNode<CommandListenerWrapper> commandNode = ((CommandV1_14_4) command).toBrigadier();

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
