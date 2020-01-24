package com.tsuchigumo.crawl

import com.tsuchigumo.persistance.PageDataPersistence
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.EndpointGroup

object CrawlController : EndpointGroup {

    override fun addEndpoints() {
        get(":id") {
            it.json(PageDataPersistence.get(it.pathParam("id")))
        }

        get("") {
            var a = HTMLExtraction.extract(it.queryParamMap())
            a.forEach { page -> PageDataPersistence.save(data = page) }
            it.json(a)
        }
    }
}