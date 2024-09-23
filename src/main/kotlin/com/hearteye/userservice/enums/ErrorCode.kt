package com.hearteye.userservice.enums

enum class ErrorCode(val code: String, val status: Int = 400) {
    USER_NOT_FOUND("USER0001", 404),
}