package com.tsuchigumo.file

import com.tsuchigumo.crawl.BasePage
import com.tsuchigumo.crawl.HTMLExtraction

object K6Templating {
    fun generateFile(params: Map<String, Any>): List<BasePage> {
        return HTMLExtraction.extract(params)
    }

    fun generateFile(params: Map<String, Any>, options: K6Options): List<BasePage> {
        return HTMLExtraction.extract(params)
    }
}