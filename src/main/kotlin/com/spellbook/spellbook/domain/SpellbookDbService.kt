package com.spellbook.spellbook.domain

import com.spellbook.spellbook.models.SpellbookEntry
import com.spellbook.spellbook.models.State

interface SpellbookDbService {

    fun putItemInSpellbook(entry: SpellbookEntry)
    fun listAllOpenStateItems(state: State): List<SpellbookEntry>
    fun markItemAsState(item: SpellbookEntry)
    fun markItemAsPriority(item: SpellbookEntry)
}