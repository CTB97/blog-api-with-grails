package com.ctb.sercices

import com.ctb.domains.Author
import com.ctb.domains.Post
import com.ctb.exceptions.AuthorNotFoundException
import com.ctb.exceptions.PostNotFoundException
import com.ctb.exceptions.PostNotValidateException
import grails.gorm.transactions.Transactional

import java.time.Instant

@Transactional
class PostService {

    def serviceMethod() {

    }

    def getAllPosts(){

        return Post.list();
    }

    def createPost(String title,String content,int idAuthor){

        def a = Author.get(idAuthor)
        if (a){
            def p = new Post(title: title,content: content,createAt: Instant.now(),author: a)
            if(p.validate()){
                a.addToPosts(p).save()
            }
            else
            {
                throw new PostNotValidateException('invalid post')
            }

        }
        else {
            throw new AuthorNotFoundException("author not found")
        }


    }

    def getPostById(int id){

        def post = Post.get(id);


        if(!post){
            throw new PostNotFoundException('Post not Found')
        }

        println(post.id)

        return post;
    }
}
