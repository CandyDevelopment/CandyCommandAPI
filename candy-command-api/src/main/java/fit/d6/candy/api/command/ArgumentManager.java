package fit.d6.candy.api.command;

public interface ArgumentManager {

    ArgumentType stringArg();

    ArgumentType wordStringArg();

    ArgumentType greedyStringArg();

    ArgumentType booleanType();

    ArgumentType integerArg();

    ArgumentType integerArg(int min);

    ArgumentType integerArg(int min, int max);

    ArgumentType doubleArg();

    ArgumentType doubleArg(double min);

    ArgumentType doubleArg(double min, double max);

    ArgumentType longArg();

    ArgumentType longArg(long min);

    ArgumentType longArg(long min, long max);

    ArgumentType floatArg();

    ArgumentType floatArg(float min);

    ArgumentType floatArg(float min, float max);

    ArgumentType singleEntity();

    ArgumentType entities();

    ArgumentType singlePlayer();

    ArgumentType players();

    ArgumentType angle();

    ArgumentType component();

    ArgumentType world();

    ArgumentType message();

    ArgumentType gameMode();

    ArgumentType uuid();

    ArgumentType vector(boolean centerIntegers);

    ArgumentType particle();

    ArgumentType block();

    ArgumentType item();

    ArgumentType itemPredicate();

    ArgumentType enchantment();

    ArgumentType entityType();

    ArgumentType summonableEntityType();

    ArgumentType potionEffectType();

}
