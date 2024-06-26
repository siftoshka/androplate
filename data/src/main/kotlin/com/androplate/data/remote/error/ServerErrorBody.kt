package com.androplate.data.remote.error

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
class ServerErrorBody(
    val errorCode: String? = null,
    val message: String? = null,
    val requestId: String? = null,
    val uiErrorCode: String? = null,
    val title: String? = null,
    val description: String? = null,

    /**
     * Sometimes an error from the server is nested in the "error" field but sometimes it's not.
     */
    @SerialName("error") val wrappedError: ServerErrorBody? = null,
)
