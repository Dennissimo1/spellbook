package com.spellbook.spellbook.subcommands

import picocli.CommandLine
import java.util.concurrent.Callable

@CommandLine.Command(name = "del", description = ["deletes an item"])
class Del: Callable<String> {

    @CommandLine.Parameters(index = "0", description = ["item to delete"])
    var item: String = "something"
    override fun call(): String? {
        return "item ${item.slice(IntRange(start = 0, endInclusive = 10))} was deleted"
    }
}