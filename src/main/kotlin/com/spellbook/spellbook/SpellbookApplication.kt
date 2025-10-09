package com.spellbook.spellbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpellbookApplication

fun main(args: Array<String>) {
    runApplication<SpellbookApplication>(*args)
}
