package com.ctb.domains

class Post {

    String title;
    String content;
    Date createAt;

    static belongsTo=[author:Author]

    static constraints = {
    }
}
