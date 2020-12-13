package util;

/**
 * 封装了常用的状态码
 */
public enum StateCodeEnum {

    SUCCESSFUL(200, "操作成功"),
    FAIL(101, "操作失败"),
    FORBIDDEN(403, "禁止访问");

    private int code;
    private String message;

    StateCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
