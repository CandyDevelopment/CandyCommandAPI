package fit.d6.candy.command.nms.v1_15_2;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.LongArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fit.d6.candy.api.command.ArgumentManager;
import fit.d6.candy.api.command.ArgumentType;
import fit.d6.candy.command.nms.v1_15_2.argument.*;

public class ArgumentManagerV1_15_2 implements ArgumentManager {

    @Override
    public ArgumentType stringArg() {
        return StringArgumentTypeV1_15_2.STRING;
    }

    @Override
    public ArgumentType wordStringArg() {
        return StringArgumentTypeV1_15_2.WORD;
    }

    @Override
    public ArgumentType greedyStringArg() {
        return StringArgumentTypeV1_15_2.GREEDY_STRING;
    }

    @Override
    public ArgumentType booleanType() {
        return BooleanArgumentTypeV1_15_2.BOOL;
    }

    @Override
    public ArgumentType integerArg() {
        return new IntegerArgumentTypeV1_15_2(IntegerArgumentType.integer());
    }

    @Override
    public ArgumentType integerArg(int min) {
        return new IntegerArgumentTypeV1_15_2(IntegerArgumentType.integer(min));
    }

    @Override
    public ArgumentType integerArg(int min, int max) {
        return new IntegerArgumentTypeV1_15_2(IntegerArgumentType.integer(min, max));
    }

    @Override
    public ArgumentType doubleArg() {
        return new DoubleArgumentTypeV1_15_2(DoubleArgumentType.doubleArg());
    }

    @Override
    public ArgumentType doubleArg(double min) {
        return new DoubleArgumentTypeV1_15_2(DoubleArgumentType.doubleArg(min));
    }

    @Override
    public ArgumentType doubleArg(double min, double max) {
        return new DoubleArgumentTypeV1_15_2(DoubleArgumentType.doubleArg(min, max));
    }

    @Override
    public ArgumentType longArg() {
        return new LongArgumentTypeV1_15_2(LongArgumentType.longArg());
    }

    @Override
    public ArgumentType longArg(long min) {
        return new LongArgumentTypeV1_15_2(LongArgumentType.longArg(min));
    }

    @Override
    public ArgumentType longArg(long min, long max) {
        return new LongArgumentTypeV1_15_2(LongArgumentType.longArg(min, max));
    }

    @Override
    public ArgumentType floatArg() {
        return new FloatArgumentTypeV1_15_2(FloatArgumentType.floatArg());
    }

    @Override
    public ArgumentType floatArg(float min) {
        return new FloatArgumentTypeV1_15_2(FloatArgumentType.floatArg(min));
    }

    @Override
    public ArgumentType floatArg(float min, float max) {
        return new FloatArgumentTypeV1_15_2(FloatArgumentType.floatArg(min, max));
    }

    @Override
    public ArgumentType singleEntity() {
        return EntityArgumentTypeV1_15_2.SINGLE_ENTITY;
    }

    @Override
    public ArgumentType entities() {
        return EntityArgumentTypeV1_15_2.ENTITIES;
    }

    @Override
    public ArgumentType singlePlayer() {
        return EntityArgumentTypeV1_15_2.SINGLE_PLAYER;
    }

    @Override
    public ArgumentType players() {
        return EntityArgumentTypeV1_15_2.PLAYERS;
    }

    @Override
    public ArgumentType angle() {
        try {
            throw new CommandSyntaxException(CommandManagerV1_15_2.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArgumentType component() {
        return ComponentArgumentTypeV1_15_2.COMPONENT;
    }

    @Override
    public ArgumentType world() {
        return DimensionArgumentTypeV1_15_2.DIMENSION;
    }

    @Override
    public ArgumentType message() {
        return MessageArgumentTypeV1_15_2.MESSAGE;
    }

    @Override
    public ArgumentType gameMode() {
        try {
            throw new CommandSyntaxException(CommandManagerV1_15_2.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArgumentType uuid() {
        try {
            throw new CommandSyntaxException(CommandManagerV1_15_2.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArgumentType vector(boolean centerIntegers) {
        return centerIntegers ? VectorArgumentTypeV1_15_2.CENTER : VectorArgumentTypeV1_15_2.NO_CENTER;
    }

    @Override
    public ArgumentType particle() {
        return ParticleArgumentV1_15_2.PARTICLE;
    }

    @Override
    public ArgumentType block() {
        return BlockStateArgumentTypeV1_15_2.BLOCK_STATE;
    }

    @Override
    public ArgumentType item() {
        return null;
    }

    @Override
    public ArgumentType itemPredicate() {
        return null;
    }

    @Override
    public ArgumentType enchantment() {
        return EnchantmentArgumentV1_15_2.ENCHANTMENT;
    }

    @Override
    public ArgumentType entityType() {
        try {
            throw new CommandSyntaxException(CommandManagerV1_15_2.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArgumentType summonableEntityType() {
        return SummonableEntityTypeArgumentV1_15_2.SUMMONABLE_ENTITY_TYPE;
    }

    @Override
    public ArgumentType potionEffectType() {
        return PotionEffectArgumentV1_15_2.MOB_EFFECT;
    }

}
