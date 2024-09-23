package com.hearteye.userservice.mappers

import com.hearteye.userservice.models.User
import com.hearteye.userservice.responses.AllUsersResponse
import com.hearteye.userservice.responses.UserByIdResponse
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun mapUserToUserByIdResponse(user: User): UserByIdResponse {
        return UserByIdResponse(
            id = user.id.toString(),
            firstName = user.firstName,
            lastName = user.lastName,
            createdAt = user.createdAt.toString()
        )
    }

    fun mapUsersToAllUsersResponse(users: List<User>): List<AllUsersResponse> {
        return users.map { user ->
            AllUsersResponse(
                id = user.id.toString(),
                firstName = user.firstName,
                lastName = user.lastName,
                createdAt = user.createdAt.toString()
            )
        }
    }
}