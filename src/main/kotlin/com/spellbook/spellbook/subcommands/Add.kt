package com.spellbook.spellbook.subcommands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.option
import com.spellbook.spellbook.domain.SpellbookDbRepository
import com.spellbook.spellbook.domain.SpellbookDbService
import com.spellbook.spellbook.models.Priority
import com.spellbook.spellbook.models.SpellbookEntry
import com.spellbook.spellbook.models.State
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDateTime

class Add(

): CliktCommand() {

    @Autowired
    private val spellbookDbRepository =  SpellbookDbRepository

    val item by argument()
    val priorityHigh by option("--priorityHigh", "-ph", help = "Add high priority")
    val priorityMedium by option("--priorityMedium", "-pm", help = "Add medium priority")
    val priorityLow by option("--priorityLow", "-pl", help = "Add low priority")

        override fun run() {
                val entry = SpellbookEntry(
                    itemToDo = item,
                    priority = mapPriority(priorityHigh, priorityMedium, priorityLow),
                    stateOfItem = State.NOT_PICKED_UP,
                    dateFirstEntered = LocalDateTime.now(),
                )
            try {
                dbService.putItemInSpellbook(entry)
                val success = "item ${item.slice(IntRange(start = 0, endInclusive = 10))} was added to the spellbook"
                echo(success)
            } catch (e: Exception) {
                echo("Something went wrong while adding item: ${e.message}")
            }
        }

        fun mapPriority(highPriority: String?, mediumPriority: String?, lowPriority: String?): Priority {
            if (highPriority != null ) {
                return Priority.HIGH
            } else if (mediumPriority != null) {
                return Priority.MEDIUM
            } else if (lowPriority != null) {
                return Priority.LOW
            }
            return Priority.LOW
        }
}
