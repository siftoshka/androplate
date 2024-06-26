package com.androplate.core.logger

interface Logger {
    fun verbose(throwable: Throwable, message: String)
    fun verbose(message: String)
    fun error(message: String)
    fun error(throwable: Throwable, message: String)
    fun debug(message: String)
    fun debug(throwable: Throwable, message: String)
    fun warn(message: String)
    fun warn(throwable: Throwable, message: String)
    fun info(message: String)
    fun info(throwable: Throwable, message: String)
}