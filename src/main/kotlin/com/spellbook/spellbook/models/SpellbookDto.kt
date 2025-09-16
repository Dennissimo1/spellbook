package com.spellbook.spellbook.models

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

data class SpellbookDto(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val entryId: Long,
    val item: String,
    val state: State,
    val priority: Priority,
    val date: Instant,
) {
    fun SpellbookDto.convert(): SpellbookEntry {
        return SpellbookEntry(
            itemToDo = this.item,
            priority = this.priority,
            stateOfItem = this.state,
            dateFirstEntered = this.date.map(),
        )
    }

    fun State.map(): String =
        when (this) {
            State.NOT_PICKED_UP -> "Not picked up"
            State.BUSY -> "Busy"
            State.FINISHED -> "Finished"
            State.POSTPONED -> "Postponed"
    }

    fun Priority.map(): String = when (this) {
        Priority.HIGH -> "High"
        Priority.MEDIUM -> "Medium"
        Priority.LOW -> "Low"
    }

    private fun Instant.map(): LocalDateTime =
        LocalDateTime.from(this.atZone(ZoneId.systemDefault()).toInstant())
}

enum class Priority {
    HIGH, MEDIUM, LOW
}

enum class State {
    NOT_PICKED_UP,
    BUSY,
    FINISHED,
    POSTPONED,
}