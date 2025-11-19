package com.spellbook.spellbook.controller

import com.spellbook.spellbook.domain.SpellbookDbService
import com.spellbook.spellbook.models.SpellbookEntry
import com.spellbook.spellbook.models.State
import org.springframework.stereotype.Component

@Component
class SpellbookService(
    private val spellbookDbService: SpellbookDbService,
    dbService: SpellbookDbService,
) {

    fun addItemToDb(sbEntry: SpellbookEntry) {
        spellbookDbService.putItemInSpellbook(sbEntry)
    }

    fun getAllOpenItems(): List<SpellbookEntry> {
        return State.entries.map { state -> spellbookDbService.listAllOpenStateItems(state) }.flatten()
    }

}