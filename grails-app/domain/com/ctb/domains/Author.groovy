package com.ctb.domains

class Author {

    String firstName;
    String lastName;

    static hasMany=[posts:Post]

    static constraints = {
    }
}
