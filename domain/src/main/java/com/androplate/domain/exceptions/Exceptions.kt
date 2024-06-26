package com.androplate.domain.exceptions

import java.io.IOException

abstract class HandledException(
    cause: Throwable? = null,
    message: String? = null
) : IOException(message, cause)

/**
 * When App has no internet connection and API call can not be processed
 */
class NetworkError(cause: Throwable?) : HandledException(cause)

/**
 * When API does not response. Time Out
 */
class ResponseTimeoutError(cause: Throwable?) : HandledException(cause)

/**
 * Unhandled error
 */
class UnhandledError(cause: Throwable?) : HandledException(cause)

/**
 * Null pointer exception
 */
class NullPointerError(cause: Throwable?) : HandledException(cause)

sealed class ServerError(
    open val serverCode: String,
    open val serverMessage: String,
    open val serverRequestId: String,
    open val serverUiErrorCode: String,
    open val serverErrorTitle: String,
    open val serverErrorDescription: String
) : HandledException() {

    data class ClientError(
        override val serverCode: String,
        override val serverMessage: String,
        override val serverRequestId: String,
        override val serverUiErrorCode: String,
        override val serverErrorTitle: String,
        override val serverErrorDescription: String
    ) : ServerError(
        serverCode,
        serverMessage,
        serverRequestId,
        serverUiErrorCode,
        serverErrorTitle,
        serverErrorDescription
    )

    data class ServerIsDown(
        override val serverCode: String,
        override val serverMessage: String,
        override val serverRequestId: String,
        override val serverUiErrorCode: String,
        override val serverErrorTitle: String,
        override val serverErrorDescription: String
    ) : ServerError(
        serverCode,
        serverMessage,
        serverRequestId,
        serverUiErrorCode,
        serverErrorTitle,
        serverErrorDescription
    )

    data class Unknown(
        override val serverCode: String,
        override val serverMessage: String,
        override val serverRequestId: String,
        override val serverUiErrorCode: String,
        override val serverErrorTitle: String,
        override val serverErrorDescription: String
    ) : ServerError(
        serverCode,
        serverMessage,
        serverRequestId,
        serverUiErrorCode,
        serverErrorTitle,
        serverErrorDescription
    )

    data class NotAuthorized(
        override val serverCode: String,
        override val serverMessage: String,
        override val serverRequestId: String,
        override val serverUiErrorCode: String,
        override val serverErrorTitle: String,
        override val serverErrorDescription: String
    ) : ServerError(
        serverCode,
        serverMessage,
        serverRequestId,
        serverUiErrorCode,
        serverErrorTitle,
        serverErrorDescription
    ) {
        fun isDeviceIdIncorrect(): Boolean {
            return serverCode == "device_id_incorrect"
        }

        fun isTokenExpired(): Boolean {
            return serverCode == "unauthorized"
        }
    }
}

