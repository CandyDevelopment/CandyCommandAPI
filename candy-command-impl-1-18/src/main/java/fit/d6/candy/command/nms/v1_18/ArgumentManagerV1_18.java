package fit.d6.candy.command.nms.v1_18;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.LongArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fit.d6.candy.api.command.ArgumentManager;
import fit.d6.candy.api.command.ArgumentType;
import fit.d6.candy.command.nms.v1_18.argument.*;

public class ArgumentManagerV1_18 implements ArgumentManager {

    @Override
    public ArgumentType stringArg() {
        return StringArgumentTypeV1_18.STRING;
    }

    @Override
    public ArgumentType wordStringArg() {
        return StringArgumentTypeV1_18.WORD;
    }

    @Override
    public ArgumentType greedyStringArg() {
        return StringArgumentTypeV1_18.GREEDY_STRING;
    }

    @Override
    public ArgumentType booleanType() {
        return BooleanArgumentTypeV1_18.BOOL;
    }

    @Override
    public ArgumentType integerArg() {
        return new IntegerArgumentTypeV1_18(IntegerArgumentType.integer());
    }

    @Override
    public ArgumentType integerArg(int min) {
        return new IntegerArgumentTypeV1_18(IntegerArgumentType.integer(min));
    }

    @Override
    public ArgumentType integerArg(int min, int max) {
        return new IntegerArgumentTypeV1_18(IntegerArgumentType.integer(min, max));
    }

    @Override
    public ArgumentType doubleArg() {
        return new DoubleArgumentTypeV1_18(DoubleArgumentType.doubleArg());
    }

    @Override
    public ArgumentType doubleArg(double min) {
        return new DoubleArgumentTypeV1_18(DoubleArgumentType.doubleArg(min));
    }

    @Override
    public ArgumentType doubleArg(double min, double max) {
        return new DoubleArgumentTypeV1_18(DoubleArgumentType.doubleArg(min, max));
    }

    @Override
    public ArgumentType longArg() {
        return new LongArgumentTypeV1_18(LongArgumentType.longArg());
    }

    @Override
    public ArgumentType longArg(long min) {
        return new LongArgumentTypeV1_18(LongArgumentType.longArg(min));
    }

    @Override
    public ArgumentType longArg(long min, long max) {
        return new LongArgumentTypeV1_18(LongArgumentType.longArg(min, max));
    }

    @Override
    public ArgumentType floatArg() {
        return new FloatArgumentTypeV1_18(FloatArgumentType.floatArg());
    }

    @Override
    public ArgumentType floatArg(float min) {
        return new FloatArgumentTypeV1_18(FloatArgumentType.floatArg(min));
    }

    @Override
    public ArgumentType floatArg(float min, float max) {
        return new FloatArgumentTypeV1_18(FloatArgumentType.floatArg(min, max));
    }

    @Override
    public ArgumentType singleEntity() {
        return EntityArgumentTypeV1_18.SINGLE_ENTITY;
    }

    @Override
    public ArgumentType entities() {
        return EntityArgumentTypeV1_18.ENTITIES;
    }

    @Override
    public ArgumentType singlePlayer() {
        return EntityArgumentTypeV1_18.SINGLE_PLAYER;
    }

    @Override
    public ArgumentType players() {
        return EntityArgumentTypeV1_18.PLAYERS;
    }

    @Override
    public ArgumentType angle() {
        return AngleArgumentTypeV1_18.ANGLE;
    }

    @Override
    public ArgumentType component() {
        return ComponentArgumentTypeV1_18.COMPONENT;
    }

    @Override
    public ArgumentType world() {
        return DimensionArgumentTypeV1_18.DIMENSION;
    }

    @Override
    public ArgumentType message() {
        return MessageArgumentTypeV1_18.MESSAGE;
    }

    @Override
    public ArgumentType gameMode() {
        try {
            throw new CommandSyntaxException(CommandManagerV1_18.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArgumentType uuid() {
        return UuidArgumentTypeV1_18.UUID;
    }

    @Override
    public ArgumentType vector(boolean centerIntegers) {
        return centerIntegers ? VectorArgumentTypeV1_18.CENTER : VectorArgumentTypeV1_18.NO_CENTER;
    }

    @Override
    public ArgumentType particle() {
        return ParticleArgumentV1_18.PARTICLE;
    }

    @Override
    public ArgumentType block() {
        return BlockStateArgumentTypeV1_18.BLOCK_STATE;
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
        return EnchantmentArgumentV1_18.ENCHANTMENT;
    }

    @Override
    public ArgumentType entityType() {
        try {
            throw new CommandSyntaxException(CommandManagerV1_18.CANDY_COMMAND_EXCEPTION, new LiteralMessage("Unsupported argument type"));
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArgumentType summonableEntityType() {
        return SummonableEntityTypeArgumentV1_18.SUMMONABLE_ENTITY_TYPE;
    }

    @Override
    public ArgumentType potionEffectType() {
        return PotionEffectArgumentV1_18.MOB_EFFECT;
    }

}
