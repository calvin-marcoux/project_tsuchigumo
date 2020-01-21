package com.tsuchigumo.crawl

import org.jsoup.Jsoup

data class BasePage(
    var url: String = "",
    var resourcesUrl: List<String> = emptyList()
)
class HTMLExtraction {
    fun extract(url: String): BasePage {
        val connect = Jsoup.connect(url).get()
        val list:MutableList<String> = connect.select("img, script")
            .filter { it.attr("src").contains(url) }
            .map { it.attr("src") }
            .toMutableList()
        list.addAll(connect.select("link[rel=\"stylesheet\"]")
            .filter { it.attr("href").contains(url) }
            .map { it.attr("href") })
        return BasePage(url, list)
    }
}
