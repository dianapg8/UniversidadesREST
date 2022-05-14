package com.ibm.academia.apirest.exceptions;

public class badRequestException extends RuntimeException
{
    public badRequestException(String message)
    {
        super(message);
    }

}
