package com.kamneklogs.socialapp.repository

import com.kamneklogs.socialapp.model.User

object UserRepository {

    var users = HashMap<String, User>()

    fun saveUser(user: User): User? {
        return users.put(user.username, user);
    }

    fun findUserByUsername(username: String): User? {
        return users[username]
    }
}