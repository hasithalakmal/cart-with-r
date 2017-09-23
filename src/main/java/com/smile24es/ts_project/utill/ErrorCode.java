package com.smile24es.ts_project.utill;

/**
 * The class to hold error codes for Permission API
 */
public final class ErrorCode {

    private ErrorCode() {
        //Disallow instantiation
    }

    public static final String UNEXPECTED_ERROR = "10010";
    public static final String INVALID_PARAMETERS = "10000";

    public static final String GENERIC_DAO_LEVEL_EXCEPTION = "20000";
}
