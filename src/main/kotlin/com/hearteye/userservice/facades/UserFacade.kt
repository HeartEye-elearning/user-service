package com.hearteye.userservice.facades

import com.hearteye.userservice.mappers.UserMapper
import com.hearteye.userservice.models.User
import com.hearteye.userservice.requests.CreateUserRequest
import com.hearteye.userservice.responses.AllUsersResponse
import com.hearteye.userservice.responses.UserByIdResponse
import com.hearteye.userservice.services.UserService
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class UserFacade(
    private val userService: UserService,
    private val userMapper: UserMapper
) {
    fun getUserById(id: UUID): UserByIdResponse {
        val user = userService.getUserById(id)
        return userMapper.mapUserToUserByIdResponse(user)
    }

    fun getUsers(): List<AllUsersResponse> {
        val users = userService.getUsers()
        return userMapper.mapUsersToAllUsersResponse(users)
    }

    fun createUser(request: CreateUserRequest): UserByIdResponse {
        val user = User(
            firstName = request.firstName,
            lastName = request.lastName
        )
        val createdUser = userService.createUser(user)
        return userMapper.mapUserToUserByIdResponse(createdUser)
    }
}