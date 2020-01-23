package com.tsuchigumo.file

import com.tsuchigumo.crawl.BasePage
import com.tsuchigumo.crawl.HTMLExtraction

data class K6Stages(val duration: String, val target: Int)

data class K6Options(
        val stages: List<K6Stages>?,
        val rps: Int?,
        val noVUConnectionReuse: Boolean?,
        val noConnectionReuse: Boolean?,
        val maxRedirects: Int?,
        val batch: Int?,
        val batchPerHost: Int?,
        val iterations: Int?,
        val duration: Int?)

object K6Templating {
    fun generateFile(params: Map<String, Any>): List<BasePage> {
        return HTMLExtraction.extract(params)
    }

    fun generateFile(params: Map<String, Any>, options: K6Options): List<BasePage> {
        return HTMLExtraction.extract(params)
    }
}