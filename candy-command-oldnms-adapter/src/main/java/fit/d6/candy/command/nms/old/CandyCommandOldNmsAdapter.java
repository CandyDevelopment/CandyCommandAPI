package fit.d6.candy.command.nms.old;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.java.JavaPlugin;

public final class CandyCommandOldNmsAdapter extends JavaPlugin {

    private BukkitAudiences audiences;

    @Override
    public void onEnable() {
        this.audiences = BukkitAudiences.create(this);
    }

    @Override
    public void onDisable() {
        if (this.audiences != null) {
            this.audiences.close();
            this.audiences = null;
        }
    }

    public static CandyCommandOldNmsAdapter getInstance() {
        return JavaPlugin.getPlugin(CandyCommandOldNmsAdapter.class);
    }

    public static BukkitAudiences getBukkitAudiences() {
        return getInstance().audiences;
    }

}
