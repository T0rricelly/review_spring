package jpa.example.basexamp.advice.exceptions;

public class ResourceExists extends RuntimeException{

    public ResourceExists(String message){
        super(message);
    }
}
