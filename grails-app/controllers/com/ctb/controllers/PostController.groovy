package com.ctb.controllers

import com.ctb.sercices.PostService
import grails.rest.*
import grails.converters.*

class PostController {
    PostService postService
	static responseFormats = ['json', 'xml']
	
    def index() {
        respond postService.getAllPosts();
    }


}
