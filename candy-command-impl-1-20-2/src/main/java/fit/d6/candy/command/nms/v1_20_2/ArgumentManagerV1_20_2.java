package fit.d6.candy.command.nms.v1_20_2;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.LongArgumentType;
import fit.d6.candy.api.command.ArgumentManager;
import fit.d6.candy.api.command.ArgumentType;
import fit.d6.candy.command.nms.v1_20_2.argument.*;

public class ArgumentManagerV1_20_2 implements ArgumentManager {

    @Override
    public ArgumentType stringArg() {
        return StringArgumentTypeV1_20_2.STRING;
    }

    @Override
    public ArgumentType wordStringArg() {
        return StringArgumentTypeV1_20_2.WORD;
    }

    @Override
    public ArgumentType greedyStringArg() {
        return StringArgumentTypeV1_20_2.GREEDY_STRING;
    }

    @Override
    public ArgumentType booleanType() {
        return BooleanArgumentTypeV1_20_2.BOOL;
    }

    @Override
    public ArgumentType integerArg() {
        return new IntegerArgumentTypeV1_20_2(IntegerArgumentType.integer());
    }

    @Override
    public ArgumentType integerArg(int min) {
        return new IntegerArgumentTypeV1_20_2(IntegerArgumentType.integer(min));
    }

    @Override
    public ArgumentType integerArg(int min, int max) {
        return new IntegerArgumentTypeV1_20_2(IntegerArgumentType.integer(min, max));
    }

    @Override
    public ArgumentType doubleArg() {
        return new DoubleArgumentTypeV1_20_2(DoubleArgumentType.doubleArg());
    }

    @Override
    public ArgumentType doubleArg(double min) {
        return new DoubleArgumentTypeV1_20_2(DoubleArgumentType.doubleArg(min));
    }

    @Override
    public ArgumentType doubleArg(double min, double max) {
        return new DoubleArgumentTypeV1_20_2(DoubleArgumentType.doubleArg(min, max));
    }

    @Override
    public ArgumentType longArg() {
        return new LongArgumentTypeV1_20_2(LongArgumentType.longArg());
    }

    @Override
    public ArgumentType longArg(long min) {
        return new LongArgumentTypeV1_20_2(LongArgumentType.longArg(min));
    }

    @Override
    public ArgumentType longArg(long min, long max) {
        return new LongArgumentTypeV1_20_2(LongArgumentType.longArg(min, max));
    }

    @Override
    public ArgumentType floatArg() {
        return new FloatArgumentTypeV1_20_2(FloatArgumentType.floatArg());
    }

    @Override
    public ArgumentType floatArg(float min) {
        return new FloatArgumentTypeV1_20_2(FloatArgumentType.floatArg(min));
    }

    @Override
    public ArgumentType floatArg(float min, float max) {
        return new FloatArgumentTypeV1_20_2(FloatArgumentType.floatArg(min, max));
    }

    @Override
    public ArgumentType singleEntity() {
        return EntityArgumentTypeV1_20_2.SINGLE_ENTITY;
    }

    @Override
    public ArgumentType entities() {
        return EntityArgumentTypeV1_20_2.ENTITIES;
    }

    @Override
    public ArgumentType singlePlayer() {
        return EntityArgumentTypeV1_20_2.SINGLE_PLAYER;
    }

    @Override
    public ArgumentType players() {
        return EntityArgumentTypeV1_20_2.PLAYERS;
    }

    @Override
    public ArgumentType angle() {
        return AngleArgumentTypeV1_20_2.ANGLE;
    }

    @Override
    public ArgumentType component() {
        return ComponentArgumentTypeV1_20_2.COMPONENT;
    }

    @Override
    public ArgumentType world() {
        return DimensionArgumentTypeV1_20_2.DIMENSION;
    }

    @Override
    public ArgumentType message() {
        return MessageArgumentTypeV1_20_2.MESSAGE;
    }

    @Override
    public ArgumentType gameMode() {
        return GameModeArgumentTypeV1_20_2.GAME_MODE;
    }

    @Override
    public ArgumentType uuid() {
        return UuidArgumentTypeV1_20_2.UUID;
    }

    @Override
    public ArgumentType vector(boolean centerIntegers) {
        return centerIntegers ? VectorArgumentTypeV1_20_2.CENTER : VectorArgumentTypeV1_20_2.NO_CENTER;
    }

    @Override
    public ArgumentType particle() {
        return ParticleArgumentV1_20_2.PARTICLE;
    }

    @Override
    public ArgumentType block() {
        return BlockStateArgumentTypeV1_20_2.BLOCK_STATE;
    }

    @Override
    public ArgumentType item() {
        return ItemArgumentTypeV1_20_2.ITEM;
    }

    @Override
    public ArgumentType itemPredicate() {
        return ItemPredicateArgumentTypeV1_20_2.ITEM_PREDICATE;
    }

    @Override
    public ArgumentType enchantment() {
        return EnchantmentArgumentV1_20_2.ENCHANTMENT;
    }

    @Override
    public ArgumentType entityType() {
        return EntityTypeArgumentV1_20_2.ENTITY_TYPE;
    }

    @Override
    public ArgumentType summonableEntityType() {
        return SummonableEntityTypeArgumentV1_20_2.SUMMONABLE_ENTITY_TYPE;
    }

    @Override
    public ArgumentType potionEffectType() {
        return PotionEffectArgumentV1_20_2.MOB_EFFECT;
    }

}
