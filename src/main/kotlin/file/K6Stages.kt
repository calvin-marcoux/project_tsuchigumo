package com.tsuchigumo.file

import kotlinx.serialization.Serializable

@Serializable
data class K6Stages(val duration: String, val target: Int)