package com.hearteye.userservice.controllers

import com.hearteye.userservice.facades.UserFacade
import com.hearteye.userservice.requests.CreateUserRequest
import com.hearteye.userservice.responses.AllUsersResponse
import com.hearteye.userservice.responses.UserByIdResponse
import java.util.UUID
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController(private val userFacade: UserFacade) : IUserController {
    @GetMapping("/{id}")
    override fun getUserById(
        @PathVariable id: UUID
    ): ResponseEntity<UserByIdResponse> {
        return ResponseEntity.ok(userFacade.getUserById(id))
    }

    @GetMapping
    override fun getUsers(): ResponseEntity<List<AllUsersResponse>> {
        return ResponseEntity.ok(userFacade.getUsers())
    }

    @PostMapping
    override fun createUser(
        @RequestBody request: CreateUserRequest
    ): ResponseEntity<UserByIdResponse> {
        return ResponseEntity.ok(userFacade.createUser(request))
    }
}