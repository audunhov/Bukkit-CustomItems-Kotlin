package me.audunhov.customitemskt

import me.audunhov.customitemskt.items.ItemLevel
import me.audunhov.customitemskt.items.MagicMeta
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin


class Main : JavaPlugin() {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(Events(), this)
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (label.equals("customitem", true)) {
            if (sender is Player) {
                // sender.sendMessage(args)
                if (args.size == 2) {
                    try {
                        val level = ItemLevel.valueOf(args[1].toUpperCase())

                        when (args[0].toLowerCase()) {

                            "bots" -> {
                                val itemStack = ItemStack(Material.LEATHER_BOOTS)
                                itemStack.itemMeta = MagicMeta(
                                    itemStack.itemMeta!!,
                                    level,
                                    "Boots of Travel",
                                    Attribute.GENERIC_MOVEMENT_SPEED,
                                    EquipmentSlot.FEET

                                ).create()
                                sender.inventory.addItem(itemStack)
                            }

                            "hot" -> {
                                val itemStack = ItemStack(Material.SLIME_BALL)
                                itemStack.itemMeta = MagicMeta(
                                    itemStack.itemMeta!!,
                                    level,
                                    "Heart of Tarrasque",
                                    Attribute.GENERIC_MAX_HEALTH,
                                    EquipmentSlot.OFF_HAND

                                ).create()
                                sender.inventory.addItem(itemStack)
                            }

                            "hyperstone" -> {
                                val itemStack = ItemStack(Material.EMERALD)
                                itemStack.itemMeta = MagicMeta(
                                    itemStack.itemMeta!!,
                                    level,
                                    "Hyperstone",
                                    Attribute.GENERIC_ATTACK_SPEED,
                                    EquipmentSlot.OFF_HAND

                                ).create()
                                sender.inventory.addItem(itemStack)
                            }

                            else -> {
                                sender.sendMessage("Unknown custom item")
                            }
                        }


                    } catch (e: java.lang.IllegalArgumentException) {
                        sender.sendMessage("Found no level with that name")
                    }

                    if (args[0].equals("bots", true)) {


                        return true
                    }
                    return false
                }
            }

        }
        return true
    }
}

