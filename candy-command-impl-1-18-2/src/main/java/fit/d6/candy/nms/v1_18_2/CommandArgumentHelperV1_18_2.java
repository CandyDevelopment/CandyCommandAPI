package fit.d6.candy.nms.v1_18_2;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.arguments.*;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fit.d6.candy.api.command.CommandArgumentHelper;
import fit.d6.candy.api.command.item.BlockInput;
import fit.d6.candy.api.command.item.ItemInput;
import fit.d6.candy.api.command.item.ItemPredicate;
import fit.d6.candy.nms.v1_18_2.item.BlockInputV1_18_2;
import fit.d6.candy.nms.v1_18_2.item.ItemInputV1_18_2;
import io.papermc.paper.adventure.PaperAdventure;
import net.kyori.adventure.text.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.*;
import net.minecraft.commands.arguments.blocks.BlockStateArgument;
import net.minecraft.commands.arguments.coordinates.Vec3Argument;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.arguments.item.ItemPredicateArgument;
import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftParticle;
import org.bukkit.craftbukkit.v1_18_R2.enchantments.CraftEnchantment;
import org.bukkit.craftbukkit.v1_18_R2.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_18_R2.potion.CraftPotionEffectType;
import org.bukkit.craftbukkit.v1_18_R2.util.CraftNamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CommandArgumentHelperV1_18_2 implements CommandArgumentHelper {

    private final CommandContext<CommandSourceStack> commandContext;

    public CommandArgumentHelperV1_18_2(CommandContext<CommandSourceStack> context) {
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
        return EntityArgument.getEntity(this.commandContext, name).getBukkitEntity();
    }

    @Override
    public Set<Entity> getEntities(String name) throws CommandSyntaxException {
        return EntityArgument.getEntities(this.commandContext, name).stream().map(net.minecraft.world.entity.Entity::getBukkitEntity).collect(Collectors.toSet());
    }

    @Override
    public Set<Entity> getOptionalEntities(String name) throws CommandSyntaxException {
        return EntityArgument.getOptionalEntities(this.commandContext, name).stream().map(net.minecraft.world.entity.Entity::getBukkitEntity).collect(Collectors.toSet());
    }

    @Override
    public Player getSinglePlayer(String name) throws CommandSyntaxException {
        return EntityArgument.getPlayer(this.commandContext, name).getBukkitEntity();
    }

    @Override
    public Set<Player> getPlayers(String name) throws CommandSyntaxException {
        return EntityArgument.getPlayers(this.commandContext, name).stream().map(ServerPlayer::getBukkitEntity).collect(Collectors.toSet());
    }

    @Override
    public Set<Player> getOptionalPlayers(String name) throws CommandSyntaxException {
        return EntityArgument.getOptionalPlayers(this.commandContext, name).stream().map(ServerPlayer::getBukkitEntity).collect(Collectors.toSet());
    }

    @Override
    public float getAngle(String name) {
        return AngleArgument.getAngle(this.commandContext, name);
    }

    @Override
    public Component getComponent(String name) {
        return PaperAdventure.asAdventure(ComponentArgument.getComponent(this.commandContext, name));
    }

    @Override
    public World getWorld(String name) throws CommandSyntaxException {
        return DimensionArgument.getDimension(this.commandContext, name).getWorld();
    }

    @Override
    public Component getMessage(String name) throws CommandSyntaxException {
        return PaperAdventure.asAdventure(MessageArgument.getMessage(this.commandContext, name));
    }

    @Override
    public GameMode getGameMode(String name) throws CommandSyntaxException {
        throw new CommandSyntaxException(CommandManagerV1_18_2.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
    }

    @Override
    public UUID getUuid(String name) {
        return UuidArgument.getUuid(this.commandContext, name);
    }

    @Override
    public Vector getVector(String name) {
        Vec3 vec3 = Vec3Argument.getVec3(this.commandContext, name);
        return new Vector(vec3.x, vec3.y, vec3.z);
    }

    @Override
    public Particle getParticle(String name) {
        return CraftParticle.toBukkit(ParticleArgument.getParticle(this.commandContext, name));
    }

    @Override
    public BlockInput getBlock(String name) {
        return new BlockInputV1_18_2(BlockStateArgument.getBlock(this.commandContext, name));
    }

    @Override
    public ItemInput getItem(String name) {
        return new ItemInputV1_18_2(ItemArgument.getItem(this.commandContext, name));
    }

    @Override
    public ItemPredicate getItemPredicate(String name) throws CommandSyntaxException {
        Predicate<ItemStack> predicate = ItemPredicateArgument.getItemPredicate(this.commandContext, name);
        return (it) -> predicate.test(CraftItemStack.asNMSCopy(it));
    }

    @Override
    public Enchantment getEnchantment(String name) throws CommandSyntaxException {
        return new CraftEnchantment(ItemEnchantmentArgument.getEnchantment(this.commandContext, name));
    }

    @Override
    public EntityType getEntityType(String name) throws CommandSyntaxException {
        throw new CommandSyntaxException(CommandManagerV1_18_2.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
    }

    @Override
    public EntityType getSummonableEntityType(String name) throws CommandSyntaxException {
        return EntityType.valueOf(EntitySummonArgument.getSummonableEntity(this.commandContext, name).getPath());
    }

    @Override
    public PotionEffectType getPotionEffectType(String name) throws CommandSyntaxException {
        return CraftPotionEffectType.getByKey(CraftNamespacedKey.fromMinecraft(Objects.requireNonNull(Registry.MOB_EFFECT.getKey(MobEffectArgument.getEffect(this.commandContext, name)))));
    }

}
