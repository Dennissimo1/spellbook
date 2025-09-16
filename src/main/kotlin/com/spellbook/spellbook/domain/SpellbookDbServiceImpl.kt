package com.spellbook.spellbook.domain

import com.spellbook.spellbook.models.SpellbookEntry
import com.spellbook.spellbook.models.State
import org.springframework.stereotype.Service

@Service
class SpellbookDbServiceImpl: SpellbookDbService {
    override fun putItemInSpellbook(entry: SpellbookEntry) {
        TODO("Not yet implemented")
    }

    override fun listAllStateItemsForToday(state: State): List<SpellbookEntry> {
        TODO("Not yet implemented")
    }

    override fun markItemAsState(item: SpellbookEntry) {
        TODO("Not yet implemented")
    }

    override fun markItemAsPriority(item: SpellbookEntry) {
        TODO("Not yet implemented")
    }
}