package fit.d6.candy.api.command;

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

import java.util.UUID;

public enum ArgumentTypes {

    STRING(new Class[]{String.class}),
    BOOLEAN(new Class[]{Boolean.class, boolean.class}),
    INTEGER(new Class[]{Integer.class, int.class}),
    DOUBLE(new Class[]{Double.class, double.class}),
    LONG(new Class[]{Long.class, long.class}),
    FLOAT(new Class[]{Float.class, float.class}),
    SINGLE_ENTITY(new Class[]{Entity.class}),
    ENTITIES(new Class[]{Entity.class}),
    SINGLE_PLAYER(new Class[]{Player.class}),
    PLAYERS(new Class[]{Player.class}),
    ANGLE(new Class[]{float.class}),
    COMPONENT(new Class[]{Component.class}),
    WORLD(new Class[]{World.class}),
    MESSAGE(new Class[]{Component.class}),
    GAME_MODE(new Class[]{GameMode.class}),
    UUID(new Class[]{UUID.class}),
    VECTOR(new Class[]{Vector.class}),
    PARTICLE(new Class[]{Particle.class}),
    BLOCK(new Class[]{BlockInput.class}),
    ITEM(new Class[]{ItemInput.class}),
    ITEM_PREDICATE(new Class[]{ItemPredicate.class}),
    ENCHANTMENT(new Class[]{Enchantment.class}),
    ENTITY_TYPE(new Class[]{EntityType.class}),
    SUMMONABLE_ENTITY_TYPE(new Class[]{EntityType.class}),
    POTION_EFFECT_TYPE(new Class[]{PotionEffectType.class});

    private final Class[] classes;

    ArgumentTypes(Class[] classes) {
        this.classes = classes;
    }

    public Class[] getClasses() {
        return classes;
    }

}
