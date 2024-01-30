<h2 align="center">Candy Command API</h2>


<div align="center">
<p align="center">一个卓越的为基于 Paper 制作服务端的命令库</p>
<a href="./README_CN.md">English</a> | 简体中文
</div>

---
<h2 align="center"><b>注意: 只支持 Paper 及基于 Paper 的服务端 (1.13 - 1.16.5 支持 Spigot)</b></h2>
<h3 align="center">在 1.13 之间 1.16.5 的版本仅支持最后的大版本, 并且如果想在 1.13.2, 1.14.4, 1.15.2, 1.16.5 使用
CandyCommandAPI, 你必须安装源码位于 <b>`candy-command-oldnms-adapter`</b> 模块下的 CandyCommandOldNmsAdapter 插件</h3>
<h3 align="center">如果你需要 1.17+ 其他版本的支持, 请创建 Issue.</h2>

<h3 align="center">我忘掉了太低的版本不支持 Java 17, 所以 1.13 - 1.16 的支持需要一个更好的解决方案</h3>

---

<h3 align="center">使用</h3>

<h4>对于维护者</h4>
如果你想制作本项目的分支进行维护, 在你导入本项目后, 你会发现在 `candy-command-impl` 模块下的 CandyCommandAPI 中导入的一些类缺失了.
别担心, 那不是什么大问题, 因为我们导入了不同版本的实现, 比如 `candy-command-impl-1-20-4`, 并且我们需要的是重新混淆后的
Jar, 所以原始的源码不会被导入.
在修改 `candy-command-impl` 模块前, 你需要先运行 `gradle shadowJar` 任务.
<h4>对于开发者</h4>

**准备** \
在你创建一个命令之前, 你需要先获取一个 CommandService 对象.

```java
CommandService service = CommandService.getService(); // 确保你的服务器安装了 CandyCommandAPI 插件来获取 CommandService
CommandManager commandManager = service.getCommandManager(); // 与命令相关
ArgumentManager argumentManager = service.getArgumentManager(); // 与参数相关

// 如果你想用注解方式注册命令, 这是你需要获取的
AnnotationCommandManager annotationCommandManager = service.getAnnotationCommandManager();
```

为了开发使用, 我们有三种方法注册命令 (所有 JVM 语言可以使用的有 2 种, 仅 Kotlin 支持的有 1 种)

**1. Brigadier-Like** \
你可以用下方的代码创建一个命令.

```java
CommandBuilder baseCommand = commandManager.createCommand("test");
```

为该命令添加执行器.

```java
// 使用 "/test" 来执行此命令
baseCommand.executes((context, argument) ->{ // 第一个参数是一个 CommandContext 对象, 第二个参数是一个 CommandArgumentHelper 对象.
CommandSender sender = context.getSender(); // 你可以使用此方法获取命令的执行者
            return 1; // 这是必须执行的操作, 任何小于等于 0 的值意味着该命令执行失败了, 否则为执行成功 
                    });
```

如果你像添加一个子命令来执行类似 "/test subcmd" 的命令, 请这样写.

```java
CommandBuilder subCommand = commandManager.createCommand("subcmd");
subCommand.

executes((context, argument) ->{
        // 进行操作
        return 1;
        });
        baseCommand.

then(subCommand);
```

如何创建一个带参数的命令?

```java
CommandBuilder argumentCommand = commandManager.createCommand("argumentName", argumentManager.integer(1, 10)); // 这意味着可以接受一个在 [1, 10] 区间内的数字
argumentCommand.

executes((context, argument) ->{
int argumentValue = argument.getInteger("argumentName");
// 进行操作
            return 1;
                    });
                    baseCommand.

then(argumentCommand);
```

现在, 让我们注册这个命令.

```java
commandManager.register(baseCommand); // 如果你不特定一个前缀, 会使用默认前缀 "candycmd"
// 或者
commandManager.

register("cmdprefix",baseCommand);
```

**2. 注解**

```java
// TestCommand.java

import fit.d6.candy.api.command.ArgumentTypes;
import fit.d6.candy.api.command.annotation.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

@Command(name = "test")
public class TestCommand {

    // 被 @SubCommand 注解的字段会被注册为类似 "/test sub" 的子命令
    // 但是 SubTestCommand 必须被 @Command 所注解, 并且其 name 的值必须与 @SubCommand 注解的 name 的值相同
    @SubCommand(name = "sub")
    public final SubTestCommand sub = new SubTestCommand();

    // 以检测是否符合执行需求, 要求一个 CommandSender 作为参数, 必须返回一个布尔值
    @Requirement
    public boolean check(CommandSender sender) {
        return true;
    }

    // 创建一个不带任何额外参数的执行器
    // 你可以将一个参数用 @Sender 注解表明此处需要传入一个 CommandSender对象
    // 你可以将一个参数用 @Alias 注解表明此处需要传入一个别名, 此别名为执行该命令使用的别名
    // 通过 "/test" 执行该命令
    @Executor
    public void executeFirst(@Sender CommandSender sender, @Alias String alias) {
        sender.sendMessage("You just invoked a normal message with alias " + alias);
    }

    // 创建一个有额外参数的执行器
    // @RequiresPlayer 可以强制调用者为一名玩家, 所以传入的命令发送者是一个玩家对象
    // 添加 @SubCommand 注解来添加一个额外的子命令
    // 使用 @Argument 注解参数来指定参数的名称和类型, 参数的名称不一定需要和此方法参数的名称相同
    // 使用 "/test second <name>" 执行该命令
    @Executor
    @RequiresPlayer
    @SubCommand(name = "second")
    public void executeSecond(@Sender CommandSender sender, @Alias String alias, @Argument(type = ArgumentTypes.STRING, name = "name") String name) {
        sender.sendMessage("Your name is " + name);
    }

    // 使用 "/test playertest <players>" 执行该命令
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

这有一点与 Brigadier-like 命令不同的地方, 你需要使用 AnnotationCommandManager 来注册命令.

```java
annotationCommandManager.register(new TestCommand());
```

**3. Kotlin DSL**

```kotlin
val command = Command("example") {
    Literal("subcommand") {
        Executor { context, argument ->  // "/example subcommand"
            // 执行操作
            return@Executor 1
        }
    }
    Literal("argument") {
        Literal("string") {
            Argument<String>("name", stringArg()) { nameArg -> // 这是一个只能在 Executor 函数和 Suggester 函数中执行的拓展函数
                Suggester { context, argument, suggestion ->
                    suggestion.suggests(
                        "DeeChael", // 建议的内容
                        Component.text("Main maintainer of Candy Command API") // 建议的提示
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

<h3 align="center">技术细节</h3>
通常来说, 使用 brigadier 注册命令只会有一个 "minecraft" 命令前缀, 因为如果你直接将命令注册进入 CommandDispatcher,
Bukkit会自动添加 "minecraft" 前缀因为 brigadier 命令是在 bukkit 命令之前注册的.

为了解决这个问题, 我先创建了一个 VanillaCommandWrapper 对象并通过 Bukkit 的 CommandMap 进行注册.

```java
// 代码来自 'candy-command-impl-1-20-4' 模块中的 CommandManagerV1_20_4
@Override
public Command register(String prefix, CommandBuilder builder) {
    prefix = prefix.toLowerCase(); // 实际上所有注册的命令都会被 Bukkit 转小写, 所以我将前缀小写来保证不会遗漏
    if (!REGISTERED.containsKey(prefix)) // REGISTERED 是一个 Map<String, List<Command>> 查找表
        REGISTERED.put(prefix, new ArrayList<>()); // 确保这个前缀对应一个 List
    CommandNode<CommandSourceStack> commandNode = ((CommandBuilderV1_20_4<?>) builder).toBrigadier().build(); // 将这个 brigadier 命令构造器转为一个命令节点
    if (builder instanceof LiteralCommandBuilderV1_20_4) { // 只有文本命令可以被注册
        VanillaCommandWrapper wrappedCommand = new VanillaCommandWrapper(null, commandNode); // 这里是要点, CommandDispatcher 参数传入了一个空值
        Bukkit.getCommandMap().register(prefix, wrappedCommand); // 将命令注册进 CommandMap
    }
    Command command = new CommandV1_20_4(commandNode); // 构造后的命令
    REGISTERED.get(prefix).add(command); // 添加到查找表中, 等待被替换
    return command;
}
```

等到服务器加载完毕后, 用一个含有真的 CommandDispatcher 的 VanillaCommandWrapper 来替换它.

```java
// 代码来自 'candy-command-impl-1-20-4' 模块中的 CommandManagerV1_20_4
@EventHandler
public void onLoad(ServerLoadEvent event) { // 你也可以用调度器来执行, 但我更喜欢事件
    // 此命名包含 bukkit 因为实际上 bukkit 会构造一个新的 CommandDispacher 替换掉原版的, 这也是为什么直接注册进 CommandDispacher 的命令会有 "minecraft" 前缀
    // 这个 CommandDispatcher 会在 brigadier 命令注册之后, 服务器加载完成之前被替换掉, 所以我只能在服务器加载完成后替换命令
    Commands bukkitCommands = MinecraftServer.getServer().getCommands();
    CommandMap commandMap = Bukkit.getCommandMap(); // 获取 bukkit 命令对照表以替换命令

    // 获取存储的已知命令 (执行 getKnownCommands 不会返回复制后的内容)
    Map<String, org.bukkit.command.Command> knownCommands = commandMap.getKnownCommands();

    for (String prefix : REGISTERED.keySet()) {
        for (Command command : REGISTERED.get(prefix)) {
            // 以一个名为 "test", 前缀为 "prefix" 的命令为例

            // 获取构造好的 brigadier 命令节点
            CommandNode<CommandSourceStack> commandNode = ((CommandV1_20_4) command).toBrigadier();

            // 获取命令 "test"
            org.bukkit.command.Command vanillaWrapper = knownCommands.get(command.getName());
            // 获取命令 "prefix:test"
            org.bukkit.command.Command prefixVanillaWrapper = knownCommands.get(prefix + ":" + command.getName());

            // 更新一个带有真的 CommandDispatcher 的包装命令
            VanillaCommandWrapper commandWrapper = new VanillaCommandWrapper(bukkitCommands, commandNode);

            if (vanillaWrapper != null) { // 如果命令存在
                knownCommands.put(command.getName(), commandWrapper); // 替换
            }

            if (prefixVanillaWrapper != null) { // 如果命令存在
                knownCommands.put(prefix + ":" + command.getName(), commandWrapper); // 替换
            }
        }
    }
}
```