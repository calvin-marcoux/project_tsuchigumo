package com.tsuchigumo.crawl

import kotlinx.serialization.Serializable

@Serializable
data class BasePage(
    var url: String = "",
    var resourcesUrl: List<String> = emptyList()
)