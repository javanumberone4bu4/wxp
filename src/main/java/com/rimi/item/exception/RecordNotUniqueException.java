package com.rimi.item.exception;

/**
 * 记录不唯一异常类
 *
 * @author Wang Xiaoping
 * @date 2019/9/23 8:49
 */
public class RecordNotUniqueException extends RuntimeException {
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public RecordNotUniqueException() {
        super();
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public RecordNotUniqueException(String message) {
        super(message);
    }
}
