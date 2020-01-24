package com.tsuchigumo.persistance

import redis.clients.jedis.Jedis

object Jedis {
    val connection = Jedis("localhost")
}