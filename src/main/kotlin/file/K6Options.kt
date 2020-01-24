package com.tsuchigumo.file

import kotlinx.serialization.Serializable

@Serializable
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