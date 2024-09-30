package com.hearteye.userservice.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun <T : Any> T.getLogger(): Logger {
    return LoggerFactory.getLogger(this::class.java)
}