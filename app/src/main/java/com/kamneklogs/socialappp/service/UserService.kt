package com.kamneklogs.socialappp.service

import com.kamneklogs.socialappp.model.User
import com.kamneklogs.socialappp.repository.UserRepository

object UserService {
    fun saveUser(user: User): User? {
        return UserRepository.saveUser(user)
    }

    fun findUserByUsername(username: String): User? {
        return UserRepository.findUserByUsername(username)
    }
}