package fit.d6.candy.command.nms.v1_19_4.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import fit.d6.candy.api.command.ArgumentTypes;
import net.minecraft.commands.arguments.GameModeArgument;

public class GameModeArgumentTypeV1_19_4 extends ArgumentTypeV1_19_4 {

    public final static GameModeArgumentTypeV1_19_4 GAME_MODE = new GameModeArgumentTypeV1_19_4();

    private final GameModeArgument argument = GameModeArgument.gameMode();

    @Override
    public ArgumentType<?> toBrigadier() {
        return argument;
    }

    @Override
    public ArgumentTypes getType() {
        return ArgumentTypes.GAME_MODE;
    }
}
