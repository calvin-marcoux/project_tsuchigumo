package com.tsuchigumo.crawl

import io.javalin.apibuilder.EndpointGroup
import io.javalin.http.Context

object CrawlController{
    fun getCrawlData(ctx: Context) {
        ctx.json(HTMLExtraction.extract(ctx.queryParamMap()))
    }
}