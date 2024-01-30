package fit.d6.candy.command.nms.v1_19_1;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.LongArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fit.d6.candy.api.command.ArgumentManager;
import fit.d6.candy.api.command.ArgumentType;
import fit.d6.candy.command.nms.v1_19_1.argument.*;

public class ArgumentManagerV1_19_1 implements ArgumentManager {

    @Override
    public ArgumentType stringArg() {
        return StringArgumentTypeV1_19_1.STRING;
    }

    @Override
    public ArgumentType wordStringArg() {
        return StringArgumentTypeV1_19_1.WORD;
    }

    @Override
    public ArgumentType greedyStringArg() {
        return StringArgumentTypeV1_19_1.GREEDY_STRING;
    }

    @Override
    public ArgumentType booleanType() {
        return BooleanArgumentTypeV1_19_1.BOOL;
    }

    @Override
    public ArgumentType integerArg() {
        return new IntegerArgumentTypeV1_19_1(IntegerArgumentType.integer());
    }

    @Override
    public ArgumentType integerArg(int min) {
        return new IntegerArgumentTypeV1_19_1(IntegerArgumentType.integer(min));
    }

    @Override
    public ArgumentType integerArg(int min, int max) {
        return new IntegerArgumentTypeV1_19_1(IntegerArgumentType.integer(min, max));
    }

    @Override
    public ArgumentType doubleArg() {
        return new DoubleArgumentTypeV1_19_1(DoubleArgumentType.doubleArg());
    }

    @Override
    public ArgumentType doubleArg(double min) {
        return new DoubleArgumentTypeV1_19_1(DoubleArgumentType.doubleArg(min));
    }

    @Override
    public ArgumentType doubleArg(double min, double max) {
        return new DoubleArgumentTypeV1_19_1(DoubleArgumentType.doubleArg(min, max));
    }

    @Override
    public ArgumentType longArg() {
        return new LongArgumentTypeV1_19_1(LongArgumentType.longArg());
    }

    @Override
    public ArgumentType longArg(long min) {
        return new LongArgumentTypeV1_19_1(LongArgumentType.longArg(min));
    }

    @Override
    public ArgumentType longArg(long min, long max) {
        return new LongArgumentTypeV1_19_1(LongArgumentType.longArg(min, max));
    }

    @Override
    public ArgumentType floatArg() {
        return new FloatArgumentTypeV1_19_1(FloatArgumentType.floatArg());
    }

    @Override
    public ArgumentType floatArg(float min) {
        return new FloatArgumentTypeV1_19_1(FloatArgumentType.floatArg(min));
    }

    @Override
    public ArgumentType floatArg(float min, float max) {
        return new FloatArgumentTypeV1_19_1(FloatArgumentType.floatArg(min, max));
    }

    @Override
    public ArgumentType singleEntity() {
        return EntityArgumentTypeV1_19_1.SINGLE_ENTITY;
    }

    @Override
    public ArgumentType entities() {
        return EntityArgumentTypeV1_19_1.ENTITIES;
    }

    @Override
    public ArgumentType singlePlayer() {
        return EntityArgumentTypeV1_19_1.SINGLE_PLAYER;
    }

    @Override
    public ArgumentType players() {
        return EntityArgumentTypeV1_19_1.PLAYERS;
    }

    @Override
    public ArgumentType angle() {
        return AngleArgumentTypeV1_19_1.ANGLE;
    }

    @Override
    public ArgumentType component() {
        return ComponentArgumentTypeV1_19_1.COMPONENT;
    }

    @Override
    public ArgumentType world() {
        return DimensionArgumentTypeV1_19_1.DIMENSION;
    }

    @Override
    public ArgumentType message() {
        return MessageArgumentTypeV1_19_1.MESSAGE;
    }

    @Override
    public ArgumentType gameMode() {
        try {
            throw new CommandSyntaxException(CommandManagerV1_19_1.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArgumentType uuid() {
        return UuidArgumentTypeV1_19_1.UUID;
    }

    @Override
    public ArgumentType vector(boolean centerIntegers) {
        return centerIntegers ? VectorArgumentTypeV1_19_1.CENTER : VectorArgumentTypeV1_19_1.NO_CENTER;
    }

    @Override
    public ArgumentType particle() {
        return ParticleArgumentV1_19_1.PARTICLE;
    }

    @Override
    public ArgumentType block() {
        return BlockStateArgumentTypeV1_19_1.BLOCK_STATE;
    }

    @Override
    public ArgumentType item() {
        return ItemArgumentTypeV1_19_1.ITEM;
    }

    @Override
    public ArgumentType itemPredicate() {
        return ItemPredicateArgumentTypeV1_19_1.ITEM_PREDICATE;
    }

    @Override
    public ArgumentType enchantment() {
        return EnchantmentArgumentV1_19_1.ENCHANTMENT;
    }

    @Override
    public ArgumentType entityType() {
        try {
            throw new CommandSyntaxException(CommandManagerV1_19_1.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArgumentType summonableEntityType() {
        return SummonableEntityTypeArgumentV1_19_1.SUMMONABLE_ENTITY_TYPE;
    }

    @Override
    public ArgumentType potionEffectType() {
        return PotionEffectArgumentV1_19_1.MOB_EFFECT;
    }

}
