package com.tsuchigumo.persistance

import com.google.common.hash.Hashing
import com.tsuchigumo.file.K6File
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.nio.charset.StandardCharsets

object K6FilePersistence {
    private val json = Json(JsonConfiguration.Stable)

    fun save(id: String? = null, data: K6File) {
        val id = id ?: generateId(data.id.toString())
        Jedis.connection[id] = json.stringify(K6File.serializer(), data)
    }

    fun get(id: String) = json.parse(K6File.serializer(), Jedis.connection[generateId(id)])

    private fun generateId(id: String) = Hashing.sha256().hashString(id, StandardCharsets.UTF_8).toString()
}