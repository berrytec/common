package util;

/**
 * 返回结果处理
 *
 * @author levc
 * @Param data 数据
 */
public class ResultMessage<T> {
    private String message;
    private int code;
    private T data;

    public ResultMessage(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static <T> ResultMessage<T> successful(T data) {
        return new ResultMessage<>(StateCodeEnum.SUCCESSFUL.getMessage(), StateCodeEnum.SUCCESSFUL.getCode(), data);
    }

    public static <T> ResultMessage<T> fail(T data) {
        return new ResultMessage<>(StateCodeEnum.FAIL.getMessage(), StateCodeEnum.FAIL.getCode(), data);
    }

    public ResultMessage<T> message(String message) {
        return new ResultMessage<>(message, this.code, null);
    }

    public static <T> ResultMessage<T> forbidden() {
        return new ResultMessage<>(StateCodeEnum.FORBIDDEN.getMessage(), StateCodeEnum.FORBIDDEN.getCode(), null);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
