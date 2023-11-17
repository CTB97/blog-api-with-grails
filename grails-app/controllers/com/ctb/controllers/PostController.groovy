package com.ctb.controllers

import com.ctb.exceptions.PostNotFoundException
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
