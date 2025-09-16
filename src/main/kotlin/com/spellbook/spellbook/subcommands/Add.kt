package com.spellbook.spellbook.subcommands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.option
import com.spellbook.spellbook.domain.SpellbookDbService
import com.spellbook.spellbook.models.SpellbookEntry

class Add(
    private val dbService: SpellbookDbService
): CliktCommand() {
    val item by argument()
    val priorityHigh by option("--priorityHigh", "-ph", help = "Add high priority")
    val priorityMedium by option("--priorityMedium", "-pm", help = "Add medium priority")
    val priorityLow by option("--priorityLow", "-pl", help = "Add low priority")
    override fun run() {
        if (!priorityHigh.isNullOrBlank()) {
            val entry = SpellbookEntry(

            )
            dbService.putItemInSpellbook()
        }
        val success = "item ${item.slice(IntRange(start = 0, endInclusive = 10))} was added to the spellbook"
        echo(success)
    }
}