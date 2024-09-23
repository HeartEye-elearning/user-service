package com.hearteye.userservice.models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date
import java.util.UUID
import org.hibernate.annotations.CreationTimestamp

@Entity
@Table(name = "users")
data class User(
    @Id
    val id: UUID = UUID.randomUUID(),

    val firstName: String,

    val lastName: String,

    @CreationTimestamp
    val createdAt: Date,
) {
    constructor(firstName: String, lastName: String) : this(
        firstName = firstName,
        lastName = lastName,
        createdAt = Date()
    )
}