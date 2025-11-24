package com.spellbook.spellbook.domain

import com.spellbook.spellbook.models.SpellbookDto
import com.spellbook.spellbook.models.SpellbookEntry
import com.spellbook.spellbook.models.State
import com.spellbook.spellbook.models.convert
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class SpellbookDbServiceImpl(
    private val spellbookDbRepository: SpellbookDbRepository
): SpellbookDbService {

    private val logger = KotlinLogging.logger {}

    override fun putItemInSpellbook(entry: SpellbookEntry) {
        spellbookDbRepository.save(entry.convert())
    }

    override fun listAllOpenStateItems(state: State): List<SpellbookEntry> {
        return spellbookDbRepository.findSpellbookDtosByState(state).map { it.convert() }
    }

    override fun markItemAsState(id: Long, state: State) {
        val fromDb = spellbookDbRepository.getReferenceById(id)
        spellbookDbRepository.save(SpellbookDto(
            id = fromDb.id,
            item = fromDb.item,
            state = state,
            priority = fromDb.priority,
            date = fromDb.date,
        ))
    }

    override fun markItemAsPriority(item: SpellbookEntry) {
       val fromDb = spellbookDbRepository.getReferenceById(item.id.toLong())
        spellbookDbRepository.save(SpellbookDto(
            id = fromDb.id,
            item = fromDb.item,
            state = fromDb.state,
            priority = item.priority,
            date = fromDb.date,
        ))
    }

    override fun getItemDetails(id: Long): SpellbookEntry {
        val fromDb = spellbookDbRepository.getReferenceById(id)
        return fromDb.convert()
    }
}