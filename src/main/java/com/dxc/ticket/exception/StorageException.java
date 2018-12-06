package com.dxc.ticket.exception;

import com.dxc.ticket.common.StorageError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StorageException extends RuntimeException{


    private static final long serialVersionUID = 1491607362490161046L;
    private final StorageError response;
    private final transient List<Object> parameters = new ArrayList<>();

    /**
     * Constructs a new {@code ProposalGenException} with the specified detail message. The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param response NumberGeneratorRestError
     */
    public StorageException(StorageError response) {
        this(response, null, new Object[0]);
    }

    /**
     * Constructs a new {@code ProposalGenException} with the specified detail message including parameters. The cause is not initialized, and may subsequently
     * be initialized by a call to {@link #initCause}.
     *
     * @param response Sensor flow response * @param params list of parameters.
     */
    public StorageException(StorageError response, Object... params) {
        this(response, null, params);
    }

    /**
     * Construct the {@code ProposalGenException} with specified {@link StorageError}, the cause {@link Throwable} and the list of parameters.
     *
     * @param response Rest error response.
     * @param cause    root cause of this exception.
     * @param params   list of parameters.
     */
    public StorageException(StorageError response, Throwable cause, Object... params) {
        super(response.name() + Arrays.stream(params).map(Object::toString).collect(Collectors.joining(",", "[", "]")), cause);
        this.response = response;
        Collections.addAll(this.parameters, params);
    }

    /**
     * @return
     */
    public List<Object> getParameters() {
        return Collections.unmodifiableList(parameters);
    }

    /**
     * @param param
     */
    public void addParameters(Object param) {
        this.parameters.add(param);
    }

    /**
     * @return
     */
    public StorageError getResponse() {
        return response;
    }
}
