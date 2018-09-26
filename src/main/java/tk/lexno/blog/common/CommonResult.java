package tk.lexno.blog.common;

public class CommonResult {
    private String message;
    private Integer code;
    private Object data;

    public CommonResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static CommonResult ok() {
        return new CommonResult(200, "执行成功！");
    }

    public static CommonResult ok(String message) {
        return new CommonResult(200, message);
    }

    public static  CommonResult ok(String message, Object data) {
        return new CommonResult(200, message, data);
    }

    public static CommonResult error() {
        return new CommonResult(500, "执行失败！");
    }

    public static  CommonResult error(String message) {
        return new CommonResult(500, message);
    }

    public static CommonResult error(Integer code, String message) {
        return new CommonResult(code, message);
    }

    public static CommonResult error(Integer code, String message, Object data) {
        return new CommonResult(code, message, data);
    }
}
