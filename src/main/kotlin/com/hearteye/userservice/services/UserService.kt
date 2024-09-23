package com.hearteye.userservice.services

import com.hearteye.userservice.enums.ErrorCode
import com.hearteye.userservice.exceptions.APIException
import com.hearteye.userservice.models.User
import com.hearteye.userservice.repositories.UserRepository
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUserById(id: UUID): User =
        userRepository.findById(id).orElseThrow { APIException("User not found", ErrorCode.USER_NOT_FOUND) }

    fun getUsers(): List<User> = userRepository.findAll()

    fun createUser(user: User): User = userRepository.save(user)
}