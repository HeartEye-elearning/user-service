package com.hearteye.userservice.exceptions

import com.hearteye.userservice.enums.ErrorCode
import com.hearteye.userservice.utils.getLogger
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    private val logger = getLogger()

    @ExceptionHandler(APIException::class)
    fun handleApiException(
        ex: APIException,
        response: HttpServletResponse,
    ): ResponseEntity<ServiceError> {
        logger.error("API exception: ${ex.errorCode.name} - ${ex.message}")
        return createResponse(
            status = HttpStatus.valueOf(ex.errorCode.status),
            message = ex.message,
            errorCode = ex.errorCode
        )
    }

    private fun createResponse(
        message: String,
        status: HttpStatus,
        errorCode: ErrorCode? = null
    ): ResponseEntity<ServiceError> =
        ResponseEntity(
            ServiceError(
                status = status.value(),
                message = message,
                errorCode = errorCode?.name ?: status.reasonPhrase
            ),
            status
        )

    data class ServiceError(
        val status: Int,
        val message: String,
        val errorCode: String
    )
}