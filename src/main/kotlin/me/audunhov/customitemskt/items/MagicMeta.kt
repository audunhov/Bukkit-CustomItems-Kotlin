package me.audunhov.customitemskt.items

import org.bukkit.ChatColor
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.meta.ItemMeta
import java.util.*

class MagicMeta(val meta: ItemMeta, val itemLevel: ItemLevel, val displayName: String, val attribute: Attribute, val equipmentSlot: EquipmentSlot) {

    fun create(): ItemMeta {

        val levelName: String = itemLevel.name.toLowerCase().capitalize()
        meta.setDisplayName("${itemLevel.chatColor}$levelName $displayName")
        meta.addAttributeModifier(
            attribute,
            AttributeModifier(
                UUID.randomUUID(),
                attribute.name,
                itemLevel.power,
                AttributeModifier.Operation.MULTIPLY_SCALAR_1,
                equipmentSlot
            )
        )

        return meta

    }

}