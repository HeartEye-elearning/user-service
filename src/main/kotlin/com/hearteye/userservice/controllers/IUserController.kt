package com.hearteye.userservice.controllers

import com.hearteye.userservice.requests.CreateUserRequest
import com.hearteye.userservice.responses.AllUsersResponse
import com.hearteye.userservice.responses.UserByIdResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import java.util.UUID
import org.springframework.http.ResponseEntity

interface IUserController {
    @Operation(
        summary = "Get a user by id",
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    fun getUserById(id: UUID): ResponseEntity<UserByIdResponse>

    @Operation(
        summary = "Get all users",
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    fun getUsers(): ResponseEntity<List<AllUsersResponse>>

    @Operation(
        summary = "Create a new user",
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "User created successfully"),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    fun createUser(request: CreateUserRequest): ResponseEntity<UserByIdResponse>
}