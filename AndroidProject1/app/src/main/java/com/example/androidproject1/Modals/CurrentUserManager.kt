package com.example.androidproject1.Modals

object CurrentUserManager {
    private var currentUser: User? = null

    fun getCurrentUser(): User? {
        return currentUser
    }

    fun setCurrentUser(user: User?) {
        currentUser = user
    }
}
