package com.tsuchigumo

import com.tsuchigumo.crawl.HTMLExtraction
import io.javalin.Javalin
import io.javalin.core.compression.Brotli
import io.javalin.core.compression.Gzip

fun main(args: Array<String>) {
    val app = Javalin.create{ config ->
        config.compressionStrategy(Brotli(4), Gzip(6))
    }.start(7000)
    app.get("/") { ctx -> ctx.result("Hello World") }
    app.get("/api/crawl") { ctx -> ctx.json(HTMLExtraction().extract("https://eleveurs.ca"))}
}
