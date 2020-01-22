package com.tsuchigumo

import com.tsuchigumo.crawl.CrawlController
import com.tsuchigumo.file.FileController
import io.javalin.Javalin
import io.javalin.core.compression.Brotli
import io.javalin.core.compression.Gzip
import io.javalin.plugin.rendering.JavalinRenderer
import io.javalin.plugin.rendering.template.JavalinVelocity
import io.javalin.apibuilder.ApiBuilder.*

fun main(args: Array<String>) {
    val app = Javalin.create { config ->
        config.compressionStrategy(Brotli(4), Gzip(6))
        JavalinRenderer.register(JavalinVelocity, ".vtl")
    }.start(7000)

    app.routes {
        path("api") {
            path("crawl") {
                get(CrawlController::getCrawlData)
            }
            path("file") {
                get(FileController::getK6File)
            }
        }
    }
}
