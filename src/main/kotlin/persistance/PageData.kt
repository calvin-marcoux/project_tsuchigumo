package com.tsuchigumo.persistance

import com.google.common.hash.Hashing
import com.tsuchigumo.crawl.BasePage
import kotlinx.serialization.json.*
import java.nio.charset.StandardCharsets

object PageDataPersistence{

    val json = Json(JsonConfiguration.Stable)

    fun save(id: String? = null, data: BasePage) {
        val id = id ?: generateId(data.url)
        Jedis.connection[id] = json.stringify(BasePage.serializer(), data);
    }

    fun get(id: String) = json.parse(BasePage.serializer(), Jedis.connection[generateId(id)])

    private fun generateId(id: String) = Hashing.sha256().hashString(id, StandardCharsets.UTF_8).toString()
}