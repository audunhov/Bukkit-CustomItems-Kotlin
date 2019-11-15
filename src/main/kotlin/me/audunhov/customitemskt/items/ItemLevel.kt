package me.audunhov.customitemskt.items

import org.bukkit.ChatColor

enum class ItemLevel() {
    COMMON (0.1, ChatColor.WHITE),
    UNCOMMON (0.2, ChatColor.GREEN),
    RARE (0.3, ChatColor.BLUE),
    EPIC (0.4, ChatColor.LIGHT_PURPLE),
    LEGENDARY (0.5, ChatColor.GOLD);

    var power: Double = 0.0
    var chatColor = ChatColor.WHITE

    constructor(power: Double, chatColor: ChatColor){
        this.power = power
        this.chatColor = chatColor
    }

}