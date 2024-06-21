package no.kotlinRestApi.core.application.common

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class Response<T>(
    val result: T? = null,
    val error: String? = null,
    val statusCode: Int
)

object SendResponse {
    fun <T> success(result: T, status: HttpStatus = HttpStatus.OK): ResponseEntity<Response<T>> {
        require(status.is2xxSuccessful) { "Status is not of 2xx" }
        return ResponseEntity(Response(result = result, statusCode = status.value()), status)
    }

    fun <T> error(error: String, status: HttpStatus): ResponseEntity<Response<T>> {
        require(status.is4xxClientError || status.is5xxServerError) { "Status code is not of 4xx or 5xx" }
        return ResponseEntity(Response(result = null, error = error, statusCode = status.value()), status)
    }
}
