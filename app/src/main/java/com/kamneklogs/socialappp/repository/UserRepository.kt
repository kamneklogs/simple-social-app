package com.kamneklogs.socialappp.repository

import com.kamneklogs.socialappp.model.User

object UserRepository {

    var users = HashMap<String, User>()

    fun saveUser(user: User): User? {
        return users.put(user.username, user);
    }

    fun findUserByUsername(username: String): User? {
        return users[username]
    }

}