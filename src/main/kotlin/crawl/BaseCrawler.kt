package com.tsuchigumo.crawl

import io.javalin.http.BadRequestResponse
import org.jsoup.Jsoup
import java.net.URL

data class BasePage(
    var url: String = "",
    var resourcesUrl: List<String> = emptyList()
)
object HTMLExtraction {
    fun extract(param: Map<String, Any>): List<BasePage> {
        val url = param["url"] ?: throw BadRequestResponse()
         return when (url) {
            is String -> listOf(getResources(url))
            is List<*> -> getResources(url)
            else -> throw TypeCastException()
        }
    }

    private fun getResources(urls: List<*>): List<BasePage>{
        return urls.filterIsInstance<String>().map { url -> getResources(url) }
    }

    private fun getResources(url: String): BasePage{
        val urlObj: URL = URL(url)
        val connect = Jsoup.connect(url).get()
        val list:MutableList<String> = connect.select("img, script")
                .filter { it.attr("src").contains(urlObj.host) }
                .map { it.attr("src") }
                .toMutableList()
        list.addAll(connect.select("""link[rel="stylesheet"]""")
                .filter { it.attr("href").contains(urlObj.host) }
                .map { it.attr("href") })
        return BasePage(url, list)
    }
}
