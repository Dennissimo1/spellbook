package com.spellbook.spellbook.controller

import com.spellbook.spellbook.models.Priority
import com.spellbook.spellbook.models.SpellbookEntry
import com.spellbook.spellbook.models.State
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.UUID

@RestController
@RequestMapping("/v1")
class SpellbookController(
    private val spellbookService: SpellbookService
) {
    private val logger = KotlinLogging.logger {}

    @GetMapping(value = ["/add"])
    fun addEntry(
        @RequestParam(value = "item") item: String,
        @RequestParam(value = "priority") priority: String? = "low",
        @RequestParam(value = "status") status: String? = "new",
    ) {
        val entry = SpellbookEntry(
            id = UUID.randomUUID().toString(),
            itemToDo = item,
            priority = mapPriority(priority),
            stateOfItem = mapStatus(status, item),
            dateFirstEntered = LocalDateTime.now()
        )
         try {
            spellbookService.addItemToDb(entry)
            ResponseEntity.ok()
        } catch (e: Exception) {
            logger.error(e) { "Failed to add item to spellbook: ${e.message}" }
            ResponseEntity.notFound()
        }
    }

    @GetMapping(value = ["/getAll"])
    fun getAllEntries(
        @RequestParam(value = "priority") priority: String?,
        @RequestParam(value = "status") status: String?,
    ): List<SpellbookEntry> {
        //TODO lets use the priority and status request params here as well. For now, only list all open items.
        return spellbookService.getAllOpenItems()
    }

    private fun mapPriority(prio: String?): Priority {
        return when (prio) {
            "high" -> Priority.HIGH
            "medium" -> Priority.MEDIUM
            "low" -> Priority.LOW
            else -> Priority.LOW
        }
    }

    private fun mapStatus(status: String?, item: String): State {
        return when (status) {
            "new" -> State.NEW
            "not picked up" -> State.NOT_PICKED_UP
            "postponed" -> State.POSTPONED
            "done" -> State.FINISHED
            "finished" -> State.FINISHED
            else -> {
                logger.warn {
                    "Unknown spellbook status $status for item ${item.slice(IntRange(start = 0, endInclusive = 10))}. A default 'new' was mapped."
                }
                State.NEW
            }
        }
    }
}