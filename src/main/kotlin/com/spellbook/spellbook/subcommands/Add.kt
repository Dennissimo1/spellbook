package com.spellbook.spellbook.subcommands

import picocli.CommandLine

@CommandLine.Command(name = "add", description = ["adds an items"])
class Add {

    @CommandLine.Parameters(index = "0", description = ["item to add"])
    lateinit var item: String
}