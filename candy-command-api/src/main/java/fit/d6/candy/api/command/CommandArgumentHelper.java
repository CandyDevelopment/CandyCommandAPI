package fit.d6.candy.api.command;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fit.d6.candy.api.command.item.BlockInput;
import fit.d6.candy.api.command.item.ItemInput;
import fit.d6.candy.api.command.item.ItemPredicate;
import net.kyori.adventure.text.Component;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.UUID;

public interface CommandArgumentHelper {

    @NotNull
    String getString(String name);

    boolean getBoolean(String name);

    int getInteger(String name);

    double getDouble(String name);

    long getLong(String name);

    float getFloat(String name);

    Entity getSingleEntity(String name) throws CommandSyntaxException;

    Set<Entity> getEntities(String name) throws CommandSyntaxException;

    Set<Entity> getOptionalEntities(String name) throws CommandSyntaxException;

    Player getSinglePlayer(String name) throws CommandSyntaxException;

    Set<Player> getPlayers(String name) throws CommandSyntaxException;

    Set<Player> getOptionalPlayers(String name) throws CommandSyntaxException;

    float getAngle(String name);

    Component getComponent(String name);

    World getWorld(String name) throws CommandSyntaxException;

    Component getMessage(String name) throws CommandSyntaxException;

    GameMode getGameMode(String name) throws CommandSyntaxException;

    UUID getUuid(String name);

    Vector getVector(String name);

    Particle getParticle(String name);

    BlockInput getBlock(String name);

    ItemInput getItem(String name);

    ItemPredicate getItemPredicate(String name) throws CommandSyntaxException;

    Enchantment getEnchantment(String name) throws CommandSyntaxException;

    EntityType getEntityType(String name) throws CommandSyntaxException;

    EntityType getSummonableEntityType(String name) throws CommandSyntaxException;

    PotionEffectType getPotionEffectType(String name) throws CommandSyntaxException;

}
