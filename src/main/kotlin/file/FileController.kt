package com.tsuchigumo.file

import io.javalin.http.Context

object FileController {
    fun getK6File(ctx: Context) {
        ctx
            .render("template/templateFile.vtl", mapOf("data" to K6Templating.generateFile(ctx.queryParamMap())))
            .contentType("text/javascript")
    }
}