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

        saveDefaultConfig()
        reloadConfig()

    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (label.equals("customitem", true)) {
            if (sender is Player) {
                // sender.sendMessage(args)
                if (args.size == 2) {
                    try {
                        val level = ItemLevel.valueOf(args[1].toUpperCase())

                        if (args[0] in getConfig().getKeys(false)) {
                            val mat: String = getConfig().getString(args[0] + ".material")!!.toUpperCase()
                            val dispname = getConfig().getString(args[0] + ".name")!!
                            val attr = getConfig().getString(args[0] + ".attribute")!!.toUpperCase()
                            val slot = getConfig().getString(args[0] + ".slot")!!.toUpperCase()

                            val itemStack = ItemStack(Material.valueOf(mat))
                            itemStack.itemMeta = MagicMeta(
                                itemStack.itemMeta!!,
                                level,
                                dispname,
                                Attribute.valueOf(attr),
                                EquipmentSlot.valueOf(slot)
                            ).create()

                            sender.inventory.addItem(itemStack)
                            return true

                        }

                        sender.sendMessage("No item with that name")


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

