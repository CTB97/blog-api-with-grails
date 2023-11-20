package com.ctb.exceptions

class AuthorNotFoundException extends RuntimeException{

    AuthorNotFoundException(String message){
        super(message)
    }
}
