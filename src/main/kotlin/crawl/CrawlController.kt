package com.tsuchigumo.crawl

import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.EndpointGroup

object CrawlController : EndpointGroup {

    override fun addEndpoints() {
        get("") {it.json(HTMLExtraction.extract(it.queryParamMap()))}
    }
}