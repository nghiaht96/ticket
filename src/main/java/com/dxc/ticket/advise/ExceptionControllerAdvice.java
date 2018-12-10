package com.dxc.ticket.advise;

import com.dxc.ticket.common.StorageError;
import com.dxc.ticket.exception.StorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

//    /**
//     * Handle the java generic {@link Exception}.
//     *
//     * @param ex java generic {@link Exception}
//     * @return ResponseEntity with message "Un-expected error. Please contact your administrator." and INTERNAL_SERVER_ERROR
//     */
//    @ExceptionHandler(Exception.class)
//    ResponseEntity<String> exceptionHandler(Exception ex) {
//        LOGGER.error("Un-expected error. Please contact your administrator.", ex);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
//        return new ResponseEntity<>(messageSourceAccessor.getMessage(StorageError.UNEXPECTED.name()),
//                httpHeaders, StorageError.UNEXPECTED.getHttpStatus());
//    }

    /**
     * Handle the {@link com.dxc.ticket.exception.StorageException}
     *
     * @param ex {@link com.dxc.ticket.exception.StorageException}
     * @return ResponseEntity with {@link StorageError} specified by the exception.
     */
    @ExceptionHandler(StorageException.class)
    ResponseEntity<String> StorageRestException(StorageException ex) {
        StorageError response = ex.getResponse();
        String msgCode = response.name();
        String message = messageSourceAccessor.getMessage(msgCode, ex.getParameters().toArray(), msgCode);
        LOGGER.info(message, ex.getCause() == null ? ex : ex.getCause());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
        return new ResponseEntity<>(message, httpHeaders, response.getHttpStatus());
    }

}
