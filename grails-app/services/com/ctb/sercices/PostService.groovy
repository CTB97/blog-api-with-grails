package com.ctb.sercices

import com.ctb.domains.Author
import com.ctb.domains.Post
import grails.gorm.transactions.Transactional

@Transactional
class PostService {

    def serviceMethod() {

    }

    def getAllPosts(){

        return Post.list();
    }

    def createPost(String title,String content,int idAuthor,Date date){

        def a = Author.get(idAuthor)

        a.addToPosts(new Post(title: title,content: content,createAt: date)).save()

    }
}
