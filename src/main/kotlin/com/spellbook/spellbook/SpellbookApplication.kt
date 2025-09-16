package com.spellbook.spellbook

import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.core.subcommands
import com.spellbook.spellbook.subcommands.Add
import com.spellbook.spellbook.subcommands.Del
import com.spellbook.spellbook.subcommands.ListIt
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpellbookApplication

fun main(args: Array<String>) = SpellbookService()
    .subcommands(Add(), Del(), ListIt())
    .main(args)
