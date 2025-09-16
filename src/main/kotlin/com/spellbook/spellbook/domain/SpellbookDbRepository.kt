package com.spellbook.spellbook.domain

import com.spellbook.spellbook.models.SpellbookDto
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SpellbookDbRepository : CrudRepository<SpellbookDto, Long> {

//    fun findSpellbookEntriesByState(state: State): List<SpellbookEntry>
//    fun findSpellbookEntriesByPriority_High(): List<SpellbookEntry>
//    fun findSpellbookEntriesByPriority_Medium(): List<SpellbookEntry>
//    fun findSpellbookEntriesByPriority_Low(): List<SpellbookEntry>
}