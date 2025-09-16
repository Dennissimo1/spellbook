package com.spellbook.spellbook.subcommands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument

class Del: CliktCommand() {

    val item by argument()
    override fun run() {
            val str = "item ${item.slice(IntRange(start = 0, endInclusive = 10))} was deleted"
            echo(str)
    }
}