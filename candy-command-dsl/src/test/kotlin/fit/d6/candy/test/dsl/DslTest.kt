package fit.d6.candy.test.dsl

import fit.d6.candy.command.dsl.*
import fit.d6.candy.dsl.*
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player

class DslTest {

    fun main() {
        Command("example") {

            Literal("subcommand") {

            }

            Literal("argument") {

                Literal("string") {

                    Argument<String>("name", stringArg()) { name ->

                        Suggester { context, argument, suggestion ->
                            suggestion.suggests("DeeChael", Component.text("Main maintainer of Candy Command API"))
                            suggestion.suggests(
                                "\"Nostal Yuu\"",
                                Component.text("Friend of the main maintainer DeeChael")
                            )
                        }

                        Executor { context, argument ->

                            context.sender.sendMessage("You typed name is ${name()}")

                            return@Executor 1
                        }

                    }

                }

                Literal("players") {

                    Argument<Set<Player>>("players", playersArg()) { playersArg ->

                        Executor { context, argument ->
                            val players = playersArg()
                            context.sender.sendMessage("You selected: $players")
                            for (player in players) {
                                player.sendMessage("You are selected by a command sender")
                            }
                            return@Executor 1
                        }

                    }

                }

            }

        }
    }

}