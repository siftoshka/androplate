package com.androplate.core.exceptionhandler

/**
 * This class is responsible to log handled Exceptions and set logs before exception handled
 * @see ExceptionLogger
 */

interface ExceptionLogger {
    fun logException(exception: Throwable)
    fun setLogValue(key: String, value: Int)
    fun setLogValue(key: String, value: Float)
    fun setLogValue(key: String, value: Double)
    fun setLogValue(key: String, value: Long)
    fun setLogValue(key: String, value: String)
    fun setLogValue(key: String, value: Boolean)
}