<h2 align="center">Candy Command API</h2>


<div align="center">
<p align="center">An advanced command API for minecraft paper-based server</p>
English | <a href="./README_CN.md">简体中文</a>
</div>

---
<h2 align="center"><b>ATTENTION: ONLY WORKS FOR PAPER AND ITS FORKS (1.13 - 1.16.5 WORKS FOR SPIGOT)</b></h2>
<h3 align="center">ONLY LATEST VERSION ARE SUPPORTED BETWEEN 1.13 AND 1.16.5, AND TO USE CANDY COMMAND API IN 1.13.2,
1.14.4, 1.15.2, 1.16.5 YOU MUST INSTALL THE PLUGIN CandyCommandOldNmsAdapter WHICH IS IN
MODULE <b>`candy-command-oldnms-adapter`</b></h3>
<h3 align="center">IF YOU NEED OTHER VERSION SUPPORT AFTER 1.17+ PLEASE CREATE ISSUE.</h2>

<h3 align="center">Oops, I forget that version too low not support Java 17, so support for 1.13 - 1.16 need a better
solution</h3>

---

<h3 align="center">Usage</h3>

<h4>For maintainer</h4>
If you want to fork this project to maintain it or do other things, after you import the project,
you may find that some classes imported in class CandyCommandAPI under `candy-command-impl` module is missed.
Don't worry, it is not a problem, because we imported implementations for different version
like `candy-command-impl-1-20-4`,
and we need the re-obfuscated jar, so the original sources won't be imported.
You should run `gradle shadowJar` task before modify anything in `candy-command-impl` module.

<h4>For developer</h4>

**Preparation** \
Before you starting create a command, you should get the CommandService first.

```java
CommandService service = CommandService.getService(); // To get the service, you should make sure that the server has installed the plugin CandyCommandAPI
CommandManager commandManager = service.getCommandManager(); // Related to commands
ArgumentManager argumentManager = service.getArgumentManager(); // Related to arguments

// If you want to create command with annotation, this is what you need
AnnotationCommandManager annotationCommandManager = service.getAnnotationCommandManager();
```

For development usage, we actually have 3 ways (2 for all jvm language, 1 for kotlin).

**1. Brigadier-Like** \
Now you can create a new command with something like below.

```java
CommandBuilder baseCommand = commandManager.createCommand("test");
```

To add an executor with code below.

```java
// Execute this with "/test"
baseCommand.executes((context, argument) ->{ // the first parameter is a CommandContext object, the second parameter is a CommandArgumentHelper
CommandSender sender = context.getSender(); // You can get sender with this
            return 1; // This is required, any value lower or equal 0 means that the command execution is failed, or else successful
                    });
```

If you want to add a sub command to invoke the command like "/test subcmd", do below.

```java
CommandBuilder subCommand = commandManager.createCommand("subcmd");
subCommand.

executes((context, argument) ->{
        // do sth
        return 1;
        });
        baseCommand.

then(subCommand);
```

What if create a command that can accept arguments?

```java
CommandBuilder argumentCommand = commandManager.createCommand("argumentName", argumentManager.integer(1, 10)); // This means accept an integer in [1, 10]
argumentCommand.

executes((context, argument) ->{
int argumentValue = argument.getInteger("argumentName");
// do sth
            return 1;
                    });
                    baseCommand.

then(argumentCommand);
```

Now, we can register this command.

```java
commandManager.register(baseCommand); // If you don't specific the command prefix, it will be "candycmd"
// or
commandManager.

register("cmdprefix",baseCommand);
```

**2. Annotation**

```java
// TestCommand.java

import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.api.command.annotation.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

@Command(name = "test")
public class TestCommand {

    // Field annotated with @SubCommand will be registered as sub command like "/test sub"
    // But SubTestCommand class must be annotated with @Command and have the same name with @SubCommand annotation
    @SubCommand(name = "sub")
    public final SubTestCommand sub = new SubTestCommand();

    // To check the requirement, requires a CommandSender as parameter, and must return a boolean
    @Requirement
    public boolean check(CommandSender sender) {
        return true;
    }

    // Create an executor without extra arguments
    // You can use @Sender to specific where to deliver command sender
    // You can use @Alias to specific where to deliver alias
    // Invoke this with "/test"
    @Executor
    public void executeFirst(@Sender CommandSender sender, @Alias String alias) {
        sender.sendMessage("You just invoked a normal message with alias " + alias);
    }

    // Create an executor with extra arguments
    // @RequiresPlayer will force a player sender, so the delivered sender is a Player object
    // Add @SubCommand to a method to add an extra subcommand
    // Annotate parameter with @Argument to specific its name and type, the name is not need to be same with the parameter name
    // Invoke this with "/test second <name>"
    @Executor
    @RequiresPlayer
    @SubCommand(name = "second")
    public void executeSecond(@Sender CommandSender sender, @Alias String alias, @Argument(type = ArgumentTypes.STRING, name = "name") String name) {
        sender.sendMessage("Your name is " + name);
    }

    // Invoke this with "/test playertest <players>"
    @Executor
    @SubCommand(name = "playertest")
    public void playersTest(@Sender CommandSender sender, @Argument(type = ArgumentTypes.PLAYERS, name = "selector") Set<Player> players) {
        sender.sendMessage("You selected: " + players);
        for (Player player : players)
            player.sendMessage("You are selected by commander");
    }

}
// SubTestCommand.java

@Command(name = "sub")
public class SubTestCommand {

    @Executor
    public void executeFirst(@Sender CommandSender sender, @Alias String alias) {
        sender.sendMessage("You invoked sub command with alais " + alias);
    }

}

```

There is a little different with Brigadier-like command, you should register command with AnnotationCommandManager.

```java
annotationCommandManager.register(new TestCommand());
```

**3. Kotlin DSL**

```kotlin
val command = Command("example") {
    Literal("subcommand") {
        Executor { context, argument ->  // "/example subcommand"
            // do sth
            return@Executor 1
        }
    }
    Literal("argument") {
        Literal("string") {
            Argument<String>(
                "name",
                stringArg()
            ) { nameArg -> // This is an extension function only can be used in Executor function and Suggester function
                Suggester { context, argument, suggestion ->
                    suggestion.suggests(
                        "DeeChael", // suggestion content
                        Component.text("Main maintainer of Candy Command API") // suggestion tooltip
                    )
                    suggestion.suggests(
                        "\"Nostal Yuu\"",
                        Component.text("Friend of the main maintainer DeeChael")
                    )
                }
                Executor { context, argument ->  // "/example argument string <name>"
                    context.sender.sendMessage("You typed name is ${nameArg()}")
                    return@Executor 1
                }
            }
        }
        Literal("players") {
            Argument<Set<Player>>("players", playersArg()) { playersArg ->
                Executor { context, argument -> // "/example argument players <players>"
                    val players = playersArg()
                    context.sender.sendMessage("You selected: $players")
                    for (player in players) {
                        player.sendMessage("You are selected by a command sender")
                    }
                    return@Executor 1
                }
            }
        }
    }
}

commandManager.register("cmdprefix", command)
```

---

<h3 align="center">Technique Details</h3>
Usually, registering commands with brigadier will only have a prefix "minecraft", because if you directly register your
command into the CommandDispatcher, bukkit will automatically add a "minecraft" prefix to it because brigadier commands
registration is before bukkit commands registration.

To solve this, I create a VanillaCommandWrapper object and register it with Bukkit CommandMap first.

```java
// Code from CommandManagerV1_20_4 in module 'candy-command-impl-1-20-4'
@Override
public Command register(String prefix, CommandBuilder builder) {
    prefix = prefix.toLowerCase(); // Actually all the commands registered in bukkit is lowercased, to make sure that command can be replaced correctly, I lowercased it
    if (!REGISTERED.containsKey(prefix)) // REGISTERED map is Map<String, List<Command>>
        REGISTERED.put(prefix, new ArrayList<>()); // make sure that the prefix has a List
    CommandNode<CommandSourceStack> commandNode = ((CommandBuilderV1_20_4<?>) builder).toBrigadier().build(); // Convert the brigadier argument builder to brigadier command node
    if (builder instanceof LiteralCommandBuilderV1_20_4) { // Only literal command can be registered
        VanillaCommandWrapper wrappedCommand = new VanillaCommandWrapper(null, commandNode); // Here is the point, CommandDispatcher parameter deliver a null value
        Bukkit.getCommandMap().register(prefix, wrappedCommand); // Register the command into CommandMap
    }
    Command command = new CommandV1_20_4(commandNode); // Built command
    REGISTERED.get(prefix).add(command); // Add to the map, waiting for replacement
    return command;
}
```

Then after the server is loaded, replace it with an updated VanillaCommandWrapper which has a real CommandDispatcher.

```java
// Code from CommandManagerV1_20_4 in module 'candy-command-impl-1-20-4'
@EventHandler
public void onLoad(ServerLoadEvent event) { // You can also do this will scheduler, but I prefer event
    // Name this with bukkit because actually bukkit created a new one replace the vanilla one, that's the reason why commands registered into CommandDispatcher will have a prefix "minecraft"
    // And this CommandDispatcher will be replaced after brigadier commands registered, before server is loaded, so I can only replace commands after server loaded
    Commands bukkitCommands = MinecraftServer.getServer().getCommands();
    CommandMap commandMap = Bukkit.getCommandMap(); // Get bukkit command map to replace the command

    // Get the stored known commands (They didn't copy it when executing getKnownCommands method)
    Map<String, org.bukkit.command.Command> knownCommands = commandMap.getKnownCommands();

    for (String prefix : REGISTERED.keySet()) {
        for (Command command : REGISTERED.get(prefix)) {
            // Example with a command named "test" and prefix "prefix"

            // Get the built brigadier command node
            CommandNode<CommandSourceStack> commandNode = ((CommandV1_20_4) command).toBrigadier();

            // Get command with "test"
            org.bukkit.command.Command vanillaWrapper = knownCommands.get(command.getName());
            // Get command with "prefix:test"
            org.bukkit.command.Command prefixVanillaWrapper = knownCommands.get(prefix + ":" + command.getName());

            // Update the command wrapper with a real CommandDispatcher
            VanillaCommandWrapper commandWrapper = new VanillaCommandWrapper(bukkitCommands, commandNode);

            if (vanillaWrapper != null) { // If the command exists
                knownCommands.put(command.getName(), commandWrapper); // Replace it
            }

            if (prefixVanillaWrapper != null) { // If the command exists
                knownCommands.put(prefix + ":" + command.getName(), commandWrapper); // Replace it
            }
        }
    }
}
```