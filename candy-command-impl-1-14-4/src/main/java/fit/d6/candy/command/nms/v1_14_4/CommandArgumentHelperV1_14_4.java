package fit.d6.candy.command.nms.v1_14_4;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.arguments.*;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fit.d6.candy.api.command.CommandArgumentHelper;
import fit.d6.candy.api.command.item.BlockInput;
import fit.d6.candy.api.command.item.ItemInput;
import fit.d6.candy.api.command.item.ItemPredicate;
import fit.d6.candy.command.nms.v1_14_4.item.BlockInputV1_14_4;
import fit.d6.candy.command.nms.v1_14_4.item.ItemInputV1_14_4;
import net.kyori.adventure.platform.bukkit.MinecraftComponentSerializer;
import net.kyori.adventure.text.Component;
import net.minecraft.server.v1_14_R1.*;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_14_R1.CraftParticle;
import org.bukkit.craftbukkit.v1_14_R1.enchantments.CraftEnchantment;
import org.bukkit.craftbukkit.v1_14_R1.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_14_R1.potion.CraftPotionEffectType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class CommandArgumentHelperV1_14_4 implements CommandArgumentHelper {

    private final CommandContext<CommandListenerWrapper> commandContext;

    public CommandArgumentHelperV1_14_4(CommandContext<CommandListenerWrapper> context) {
        this.commandContext = context;
    }

    @Override
    public @NotNull String getString(String name) {
        return StringArgumentType.getString(this.commandContext, name);
    }

    @Override
    public boolean getBoolean(String name) {
        return BoolArgumentType.getBool(this.commandContext, name);
    }

    @Override
    public int getInteger(String name) {
        return IntegerArgumentType.getInteger(this.commandContext, name);
    }

    @Override
    public double getDouble(String name) {
        return DoubleArgumentType.getDouble(this.commandContext, name);
    }

    @Override
    public long getLong(String name) {
        return LongArgumentType.getLong(this.commandContext, name);
    }

    @Override
    public float getFloat(String name) {
        return FloatArgumentType.getFloat(this.commandContext, name);
    }

    @Override
    public Entity getSingleEntity(String name) throws CommandSyntaxException {
        return ArgumentEntity.a(this.commandContext, name).getBukkitEntity();
    }

    @Override
    public Set<Entity> getEntities(String name) throws CommandSyntaxException {
        return ArgumentEntity.b(this.commandContext, name).stream().map(net.minecraft.server.v1_14_R1.Entity::getBukkitEntity).collect(Collectors.toSet());
    }

    @Override
    public Set<Entity> getOptionalEntities(String name) throws CommandSyntaxException {
        return ArgumentEntity.c(this.commandContext, name).stream().map(net.minecraft.server.v1_14_R1.Entity::getBukkitEntity).collect(Collectors.toSet());
    }

    @Override
    public Player getSinglePlayer(String name) throws CommandSyntaxException {
        return ArgumentEntity.e(this.commandContext, name).getBukkitEntity();
    }

    @Override
    public Set<Player> getPlayers(String name) throws CommandSyntaxException {
        return ArgumentEntity.f(this.commandContext, name).stream().map(EntityPlayer::getBukkitEntity).collect(Collectors.toSet());
    }

    @Override
    public Set<Player> getOptionalPlayers(String name) throws CommandSyntaxException {
        return ArgumentEntity.d(this.commandContext, name).stream().map(EntityPlayer::getBukkitEntity).collect(Collectors.toSet());
    }

    @Override
    public float getAngle(String name) throws CommandSyntaxException {
        throw new CommandSyntaxException(CommandManagerV1_14_4.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
    }

    @Override
    public Component getComponent(String name) {
        return MinecraftComponentSerializer.get().deserialize(ArgumentChatComponent.a(this.commandContext, name));
    }

    @Override
    public World getWorld(String name) throws CommandSyntaxException {
        return MinecraftServer.getServer().worldServer.get(ArgumentDimension.a(this.commandContext, name)).getWorld();
    }

    @Override
    public Component getMessage(String name) throws CommandSyntaxException {
        return MinecraftComponentSerializer.get().deserialize(ArgumentChat.a(this.commandContext, name));
    }

    @Override
    public GameMode getGameMode(String name) throws CommandSyntaxException {
        throw new CommandSyntaxException(CommandManagerV1_14_4.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
    }

    @Override
    public UUID getUuid(String name) throws CommandSyntaxException {
        throw new CommandSyntaxException(CommandManagerV1_14_4.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
    }

    @Override
    public Vector getVector(String name) throws CommandSyntaxException {
        Vec3D vec3 = ArgumentVec3.a(this.commandContext, name);
        return new Vector(vec3.x, vec3.y, vec3.z);
    }

    @Override
    public Particle getParticle(String name) {
        return CraftParticle.toBukkit(ArgumentParticle.a(this.commandContext, name));
    }

    @Override
    public BlockInput getBlock(String name) {
        return new BlockInputV1_14_4(ArgumentTile.a(this.commandContext, name));
    }

    @Override
    public ItemInput getItem(String name) {
        return new ItemInputV1_14_4(ArgumentItemStack.a(this.commandContext, name));
    }

    @Override
    public ItemPredicate getItemPredicate(String name) throws CommandSyntaxException {
        Predicate<ItemStack> predicate = ArgumentItemPredicate.a(this.commandContext, name);
        return (it) -> predicate.test(CraftItemStack.asNMSCopy(it));
    }

    @Override
    public Enchantment getEnchantment(String name) throws CommandSyntaxException {
        return new CraftEnchantment(ArgumentEnchantment.a(this.commandContext, name));
    }

    @Override
    public EntityType getEntityType(String name) throws CommandSyntaxException {
        throw new CommandSyntaxException(CommandManagerV1_14_4.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
    }

    @Override
    public EntityType getSummonableEntityType(String name) throws CommandSyntaxException {
        return EntityType.valueOf(ArgumentEntitySummon.a(this.commandContext, name).getKey());
    }

    @Override
    public PotionEffectType getPotionEffectType(String name) throws CommandSyntaxException {
        return CraftPotionEffectType.getById(IRegistry.MOB_EFFECT.a(ArgumentMobEffect.a(this.commandContext, name)));
    }

}
