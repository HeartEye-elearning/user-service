package com.hearteye.userservice.responses

data class UserByIdResponse(
    val id: String,
    val firstName: String,
    val lastName: String,
    val createdAt: String
)
