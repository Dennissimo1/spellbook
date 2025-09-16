package com.spellbook.spellbook

import com.github.ajalt.clikt.core.CliktCommand


class SpellbookService: CliktCommand(name = "spellbook") {
    override fun run() {
        echo()
    }
}