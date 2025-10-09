package com.spellbook.spellbook.domain

import com.spellbook.spellbook.models.SpellbookDto
import com.spellbook.spellbook.models.SpellbookEntry
import com.spellbook.spellbook.models.State
import com.spellbook.spellbook.models.convert
import org.springframework.stereotype.Service

@Service
class SpellbookDbServiceImpl(
    private val spellbookDbRepository: SpellbookDbRepository
): SpellbookDbService {
    override fun putItemInSpellbook(entry: SpellbookEntry) {
        spellbookDbRepository.save(entry.convert())
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