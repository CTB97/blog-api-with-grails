package com.ctb

import com.ctb.domains.Author
import com.ctb.domains.Post
import com.ctb.sercices.AuthorService
import com.ctb.sercices.PostService

class BootStrap {

    AuthorService authorService
    PostService postService

    def init = { servletContext ->

        def a= authorService.createAuthor("cheikh Tidiane","BOYE")
        def b= authorService.createAuthor("Amadou","Ndiaye")

        //def c = Author.get(1)

        //println(c.id)

        //def p1= new Post(title: "post1",content: "some contain")

        //def p2= new Post(title: "post2",content: "some contain")

       // postService.createPost("post 1","un post test",1)

        //a.addToAuthors(p1).save()

        //a.addToPosts(p1).save()



       // a.addToPosts(p1)
        //p2.save()
    }
    def destroy = {
    }
}
