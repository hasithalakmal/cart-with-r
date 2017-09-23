package com.smile24es.ts_project.controller;

import com.smile24es.ts_project.utill.Error;
import com.smile24es.ts_project.utill.ErrorCode;
import com.smile24es.ts_project.utill.MovieProjectApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by hasithagamage on 5/13/17.
 */
public class BaseRestController {

    private static final Logger SL4J_LOGGER = LoggerFactory.getLogger(BaseRestController.class);

    protected static final String UNKNOWN_ERROR = "Unknown Error";
    protected static final String ERRORS =  "errors.";


    @Autowired
    private MessageSource messages;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Error handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {

        SL4J_LOGGER.debug("Handling error {}", e);
        if (e instanceof MovieProjectApiException) {
            SL4J_LOGGER.debug("Handling profile api exception");
            Locale locale = request.getLocale();
            String message = this.messages.getMessage(ERRORS + ((MovieProjectApiException) e).getHttpStatusCode().value(), new Object[]{}, e.getMessage(), locale);
            return getError(((MovieProjectApiException) e).getHttpStatusCode().value(), ((MovieProjectApiException) e).getErrorCode(), message, ((MovieProjectApiException) e).getHttpStatusCode().toString(), response);
        } else {
            SL4J_LOGGER.debug("Handling other exception");
            SL4J_LOGGER.error("Generic exception handler: {}", e.getMessage(), e);
            Locale locale = request.getLocale();
            String message = this.messages.getMessage(ERRORS + ErrorCode.UNEXPECTED_ERROR, new Object[]{}, UNKNOWN_ERROR, locale);
            return getError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ErrorCode.UNEXPECTED_ERROR, message, e.getMessage(), response);
        }
    }

    private Error getError(int httpStatusCode, String errorCode, String description, String additionalInfo, HttpServletResponse response) {
        Error error = new Error();
        error.setCode(errorCode);
        error.setDescription(description);
        error.setAdditionalInfo(additionalInfo);
        response.setStatus(httpStatusCode);
        return error;
    }
}
