package com.spellbook.spellbook

import com.spellbook.spellbook.subcommands.List
import com.spellbook.spellbook.subcommands.Add
import com.spellbook.spellbook.subcommands.Del
import picocli.CommandLine
import java.util.concurrent.Callable


@CommandLine.Command(name ="spellbook", mixinStandardHelpOptions = true, version = ["spellbook v0.1"], description = ["spellbook"], subcommands = [List::class, Del::class, Add::class ])
class SpellbookService: Callable<String> {
    override fun call(): String? {
        TODO("Not yet implemented")
    }
}