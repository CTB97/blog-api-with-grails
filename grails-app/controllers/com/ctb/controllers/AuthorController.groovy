package com.ctb.controllers

import com.ctb.domains.Author
import com.ctb.exceptions.AuthorNotFoundException
import com.ctb.exceptions.AuthorNotValidateException
import com.ctb.sercices.AuthorService
import grails.rest.*
import grails.converters.*
import grails.web.RequestParameter

class AuthorController {
    AuthorService authorService;
	static responseFormats = ['json', 'xml']
	
    def index() {

        respond authorService.getAllAuthors();
    }

    def createAuthor(){
        def requestBody= request.JSON

        def firstName= requestBody.firstName
        def lastName= requestBody.lastName
        def author= new Author(firstName: firstName,lastName: lastName)

        try {
            authorService.createAuthor(firstName,lastName)
            def response=[:]
            response.status=200
            response.message="success"
            render response as JSON

        }
        catch (AuthorNotValidateException e){
            def response=[:]
            response.status=400
            response.message="failed"
            render response as JSON

        }

    }

    def getAuthor(@RequestParameter('id') int id){
        try{

            def author= authorService.getAuthorById(id)
            respond author

        }catch (AuthorNotFoundException e){
            def response = [:]
            response.status = 404 // Code d'état "Not Found"
            response.error = "Author not found."
            render response as JSON
        }

    }
}
