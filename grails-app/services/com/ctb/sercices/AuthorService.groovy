package com.ctb.sercices

import com.ctb.domains.Author
import com.ctb.exceptions.AuthorNotFoundException
import grails.gorm.transactions.Transactional

@Transactional
class AuthorService {

    def serviceMethod() {

    }

    def getAllAuthors(){

        return Author.list()
    }

    def getAuthorById(int id){

        def author = Author.get(id);

        if(!author){
            throw new AuthorNotFoundException("author not found")
        }

        return author
    }

    def createAuthor(String firstName,String lastName){

        new Author(firstName: firstName,lastName: lastName).save()

    }
}
