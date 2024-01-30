package fit.d6.candy.command.nms.v1_19_3;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.LongArgumentType;
import fit.d6.candy.api.command.ArgumentManager;
import fit.d6.candy.api.command.ArgumentType;
import fit.d6.candy.command.nms.v1_19_3.argument.*;

public class ArgumentManagerV1_19_3 implements ArgumentManager {

    @Override
    public ArgumentType stringArg() {
        return StringArgumentTypeV1_19_3.STRING;
    }

    @Override
    public ArgumentType wordStringArg() {
        return StringArgumentTypeV1_19_3.WORD;
    }

    @Override
    public ArgumentType greedyStringArg() {
        return StringArgumentTypeV1_19_3.GREEDY_STRING;
    }

    @Override
    public ArgumentType booleanType() {
        return BooleanArgumentTypeV1_19_3.BOOL;
    }

    @Override
    public ArgumentType integerArg() {
        return new IntegerArgumentTypeV1_19_3(IntegerArgumentType.integer());
    }

    @Override
    public ArgumentType integerArg(int min) {
        return new IntegerArgumentTypeV1_19_3(IntegerArgumentType.integer(min));
    }

    @Override
    public ArgumentType integerArg(int min, int max) {
        return new IntegerArgumentTypeV1_19_3(IntegerArgumentType.integer(min, max));
    }

    @Override
    public ArgumentType doubleArg() {
        return new DoubleArgumentTypeV1_19_3(DoubleArgumentType.doubleArg());
    }

    @Override
    public ArgumentType doubleArg(double min) {
        return new DoubleArgumentTypeV1_19_3(DoubleArgumentType.doubleArg(min));
    }

    @Override
    public ArgumentType doubleArg(double min, double max) {
        return new DoubleArgumentTypeV1_19_3(DoubleArgumentType.doubleArg(min, max));
    }

    @Override
    public ArgumentType longArg() {
        return new LongArgumentTypeV1_19_3(LongArgumentType.longArg());
    }

    @Override
    public ArgumentType longArg(long min) {
        return new LongArgumentTypeV1_19_3(LongArgumentType.longArg(min));
    }

    @Override
    public ArgumentType longArg(long min, long max) {
        return new LongArgumentTypeV1_19_3(LongArgumentType.longArg(min, max));
    }

    @Override
    public ArgumentType floatArg() {
        return new FloatArgumentTypeV1_19_3(FloatArgumentType.floatArg());
    }

    @Override
    public ArgumentType floatArg(float min) {
        return new FloatArgumentTypeV1_19_3(FloatArgumentType.floatArg(min));
    }

    @Override
    public ArgumentType floatArg(float min, float max) {
        return new FloatArgumentTypeV1_19_3(FloatArgumentType.floatArg(min, max));
    }

    @Override
    public ArgumentType singleEntity() {
        return EntityArgumentTypeV1_19_3.SINGLE_ENTITY;
    }

    @Override
    public ArgumentType entities() {
        return EntityArgumentTypeV1_19_3.ENTITIES;
    }

    @Override
    public ArgumentType singlePlayer() {
        return EntityArgumentTypeV1_19_3.SINGLE_PLAYER;
    }

    @Override
    public ArgumentType players() {
        return EntityArgumentTypeV1_19_3.PLAYERS;
    }

    @Override
    public ArgumentType angle() {
        return AngleArgumentTypeV1_19_3.ANGLE;
    }

    @Override
    public ArgumentType component() {
        return ComponentArgumentTypeV1_19_3.COMPONENT;
    }

    @Override
    public ArgumentType world() {
        return DimensionArgumentTypeV1_19_3.DIMENSION;
    }

    @Override
    public ArgumentType message() {
        return MessageArgumentTypeV1_19_3.MESSAGE;
    }

    @Override
    public ArgumentType gameMode() {
        return GameModeArgumentTypeV1_19_3.GAME_MODE;
    }

    @Override
    public ArgumentType uuid() {
        return UuidArgumentTypeV1_19_3.UUID;
    }

    @Override
    public ArgumentType vector(boolean centerIntegers) {
        return centerIntegers ? VectorArgumentTypeV1_19_3.CENTER : VectorArgumentTypeV1_19_3.NO_CENTER;
    }

    @Override
    public ArgumentType particle() {
        return ParticleArgumentV1_19_3.PARTICLE;
    }

    @Override
    public ArgumentType block() {
        return BlockStateArgumentTypeV1_19_3.BLOCK_STATE;
    }

    @Override
    public ArgumentType item() {
        return ItemArgumentTypeV1_19_3.ITEM;
    }

    @Override
    public ArgumentType itemPredicate() {
        return ItemPredicateArgumentTypeV1_19_3.ITEM_PREDICATE;
    }

    @Override
    public ArgumentType enchantment() {
        return EnchantmentArgumentV1_19_3.ENCHANTMENT;
    }

    @Override
    public ArgumentType entityType() {
        return EntityTypeArgumentV1_19_3.ENTITY_TYPE;
    }

    @Override
    public ArgumentType summonableEntityType() {
        return SummonableEntityTypeArgumentV1_19_3.SUMMONABLE_ENTITY_TYPE;
    }

    @Override
    public ArgumentType potionEffectType() {
        return PotionEffectArgumentV1_19_3.MOB_EFFECT;
    }

}
