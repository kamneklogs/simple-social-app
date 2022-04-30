package com.kamneklogs.socialapp.service

import com.kamneklogs.socialapp.model.User
import com.kamneklogs.socialapp.repository.UserRepository

object UserService {
    fun saveUser(user: User): User? {
        return UserRepository.saveUser(user)
    }

    fun findUserByUsername(username: String): User? {
        return UserRepository.findUserByUsername(username)
    }

}