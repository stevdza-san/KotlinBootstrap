package com.stevdza.san.kotlinbs.util

object UniqueIdGenerator {
    private val componentIds = mutableSetOf<String>()

    fun generateUniqueId(baseName: String): String {
        var id = baseName
        var counter = 1

        while (componentIds.contains(id)) {
            id = "$baseName${counter++}"
        }

        componentIds.add(id)
        return id
    }

    fun removeUniqueId(id: String) {
        componentIds.remove(id)
    }
}