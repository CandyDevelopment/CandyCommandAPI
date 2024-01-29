package fit.d6.candy.command;

import fit.d6.candy.api.command.AnnotationCommandManager;
import fit.d6.candy.api.command.ArgumentManager;
import fit.d6.candy.api.command.CommandManager;
import fit.d6.candy.api.command.CommandService;
import fit.d6.candy.command.nms.v1_17_1.ArgumentManagerV1_17_1;
import fit.d6.candy.command.nms.v1_17_1.CommandManagerV1_17_1;
import fit.d6.candy.command.nms.v1_18_2.ArgumentManagerV1_18_2;
import fit.d6.candy.command.nms.v1_18_2.CommandManagerV1_18_2;
import fit.d6.candy.command.nms.v1_19_4.ArgumentManagerV1_19_4;
import fit.d6.candy.command.nms.v1_19_4.CommandManagerV1_19_4;
import fit.d6.candy.command.nms.v1_20_4.ArgumentManagerV1_20_4;
import fit.d6.candy.command.nms.v1_20_4.CommandManagerV1_20_4;
import fit.d6.candy.command.util.Ref;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CandyCommandAPI extends JavaPlugin implements CommandService {

    private AnnotationCommandManager annotationCommandManager = new AnnotationCommandManagerImpl();
    private CommandManager commandManager;
    private ArgumentManager argumentManager;

    @Override
    public void onLoad() {
        if (Ref.getObcVersion().equalsIgnoreCase("1_20_R3")) {
            commandManager = new CommandManagerV1_20_4();
            argumentManager = new ArgumentManagerV1_20_4();
        } else if (Ref.getObcVersion().equalsIgnoreCase("1_19_R3")) {
            commandManager = new CommandManagerV1_19_4();
            argumentManager = new ArgumentManagerV1_19_4();
        } else if (Ref.getObcVersion().equalsIgnoreCase("1_18_R2")) {
            commandManager = new CommandManagerV1_18_2();
            argumentManager = new ArgumentManagerV1_18_2();
        } else if (Ref.getObcVersion().equalsIgnoreCase("1_17_R1")) {
            commandManager = new CommandManagerV1_17_1();
            argumentManager = new ArgumentManagerV1_17_1();
        }
    }

    @Override
    public void onEnable() {
        if (Ref.isOldNms()) {
            getSLF4JLogger().error("Server version is too old! Not supported!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        if (commandManager == null || argumentManager == null) {
            getSLF4JLogger().error("Unsupported server!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        Bukkit.getPluginManager().registerEvents(this.commandManager, this);
    }

    @Override
    public AnnotationCommandManager getAnnotationCommandManager() {
        return this.annotationCommandManager;
    }

    @Override
    public CommandManager getCommandManager() {
        return this.commandManager;
    }

    @Override
    public ArgumentManager getArgumentManager() {
        return this.argumentManager;
    }

}
