package com.parakram.assignment1_week5.modules
import java.io.Serializable

class Users: Serializable {
    var covID: Int
    var firstName: String
    var lastName: String
    var username: String
    var password: String
    var batch: String
    var profileLink: String

    constructor(
        covID: Int,
        firstName: String,
        lastName: String,
        username: String,
        password: String,
        batch: String,
        profileLink: String
    ) {
        this.covID = covID
        this.firstName = firstName
        this.lastName = lastName
        this.username = username
        this.password = password
        this.batch = batch
        this.profileLink = profileLink
    }

    override fun toString(): String {
        return super.toString()
    }
}
