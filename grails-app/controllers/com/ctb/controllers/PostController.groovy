package com.ctb.controllers

import com.ctb.exceptions.PostNotFoundException
import com.ctb.exceptions.PostNotValidateException
import com.ctb.sercices.PostService
import grails.rest.*
import grails.converters.*
import grails.web.RequestParameter

class PostController {
    PostService postService
	static responseFormats = ['json', 'xml']
	
    def index() {
        respond postService.getAllPosts();
    }

    def createPost(){

        try {
            def requestBody = request.JSON
            def title= requestBody.title
            def content = requestBody.content
            def idAuthor = params.idAuthor.toInteger()

            postService.createPost(title,content,idAuthor)

            def response=[:]
            response.status=200
            response.message="success"
            render response as JSON
        }
        catch (PostNotValidateException e){
            def response=[:]
            response.status=400
            response.message="failed"
            render response as JSON

        }
    }

    def getPost(@RequestParameter('id') int id){
        //respond postService.getPostById(id)
        try {
           def author= postService.getPostById(id)

            respond author;

        }catch (PostNotFoundException e){
            def response = [:]
            response.status = 404 // Code d'état "Not Found"
            response.error = "Post not found."
            render response as JSON


        }

    }


}
