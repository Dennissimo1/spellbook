package com.spellbook.spellbook.models

import java.time.LocalDateTime
import java.time.ZoneOffset

data class SpellbookEntry(
    val itemToDo: String,
    val priority: Priority,
    val stateOfItem: State,
    val dateFirstEntered: LocalDateTime,
) {
    fun SpellbookEntry.convert(): SpellbookDto {
        return SpellbookDto(
            entryId = 0L,
            item = this.itemToDo,
            state = this.stateOfItem,
            priority = this.priority,
            date = this.dateFirstEntered.toInstant(ZoneOffset.UTC),
        )
    }
}
