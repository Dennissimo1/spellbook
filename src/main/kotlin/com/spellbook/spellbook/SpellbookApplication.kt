package com.spellbook.spellbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import picocli.CommandLine
import kotlin.system.exitProcess

@SpringBootApplication
class SpellbookApplication

fun main(args: Array<String>) : Unit = exitProcess(CommandLine(SpellbookService()).execute(*args))
