package com.ctb.sercices

import com.ctb.domains.Author
import grails.gorm.transactions.Transactional

@Transactional
class AuthorService {

    def serviceMethod() {

    }

    def createAuthor(String firstName,String lastName){

        new Author(firstName: firstName,lastName: lastName).save()

    }
}
