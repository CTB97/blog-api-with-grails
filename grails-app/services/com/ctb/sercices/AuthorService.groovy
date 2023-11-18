package com.ctb.sercices

import com.ctb.domains.Author
import com.ctb.exceptions.AuthorNotFoundException
import com.ctb.exceptions.AuthorNotValidateException
import grails.converters.JSON
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
        //new Author(firstName: firstName,lastName: lastName).save()
        def author = new Author(firstName: firstName,lastName: lastName)
        if (author.validate()){
            author.save()

        }
        else {
            throw new AuthorNotValidateException("invalid author");
        }

    }
}
