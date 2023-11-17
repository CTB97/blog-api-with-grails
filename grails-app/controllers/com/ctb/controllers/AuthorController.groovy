package com.ctb.controllers

import com.ctb.exceptions.AuthorNotFoundException
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

    def getAuthor(@RequestParameter('id')int id){
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
