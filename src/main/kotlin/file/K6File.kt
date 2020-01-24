package com.tsuchigumo.file

import com.tsuchigumo.crawl.BasePage
import kotlinx.serialization.Serializable

@Serializable
data class K6File(val id: Int, val page: BasePage, val options: K6Options)