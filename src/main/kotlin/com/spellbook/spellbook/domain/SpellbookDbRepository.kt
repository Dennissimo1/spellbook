package com.spellbook.spellbook.domain

import com.spellbook.spellbook.models.Priority
import com.spellbook.spellbook.models.SpellbookDto
import com.spellbook.spellbook.models.SpellbookEntry
import com.spellbook.spellbook.models.State
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpellbookDbRepository : JpaRepository<SpellbookDto, Long> {

    fun findSpellbookDtosByState(state: State): List<SpellbookDto>
    fun findSpellbookDtosByPriority(priority: Priority): List<SpellbookDto>
}