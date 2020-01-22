package com.tsuchigumo

import com.tsuchigumo.crawl.HTMLExtraction
import io.javalin.Javalin
import io.javalin.core.compression.Brotli
import io.javalin.core.compression.Gzip
import io.javalin.plugin.rendering.JavalinRenderer
import io.javalin.plugin.rendering.template.JavalinVelocity

fun main(args: Array<String>) {
    val app = Javalin.create { config ->
        config.compressionStrategy(Brotli(4), Gzip(6))
        JavalinRenderer.register(JavalinVelocity, ".vtl")
    }.start(7000)
    app.get("/") { ctx ->
        ctx.render(
            "template/templateFile.vtl",
            mapOf("data" to HTMLExtraction().extract("https://eleveurs.ca"))
        ).contentType("text/javascript")
    }
    app.get("/api/crawl") { ctx -> ctx.json(HTMLExtraction().extract("https://eleveurs.ca")) }
}
