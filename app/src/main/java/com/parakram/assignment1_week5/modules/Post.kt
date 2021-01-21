package com.parakram.assignment1_week5.modules
import java.io.Serializable

class Post: Serializable {
    var username: String
    var profileLink: String
    var postImageLink: String
    var caption: String

    constructor(username: String, profileLink: String, postImageLink: String, caption: String) {
        this.username = username
        this.profileLink = profileLink
        this.postImageLink = postImageLink
        this.caption = caption
    }

    override fun toString(): String {
        return super.toString()
    }
}