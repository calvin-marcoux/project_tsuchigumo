package com.tsuchigumo.file

import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.EndpointGroup


object FileController : EndpointGroup {

    override fun addEndpoints() {
        get("") {
            it.render("template/templateFile.vtl", mapOf("data" to K6Templating.generateFile(it.queryParamMap())))
                    .contentType("text/javascript")
        }
    }
}