package com.sx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author maxiucheng
 * @date 2018/10/25
 * @jdk.version 1.8
 * @desc swagger封装返回对象
 */
@Data
@ApiModel("返回封装类")
public class BaseResponse<T> {

	@ApiModelProperty(value = "返回标识码")
	private boolean success;

	@ApiModelProperty(value = "状态码")
	private int code;

	@ApiModelProperty(value = "具体返回信息")
	private String message;

	@ApiModelProperty(value = "具体返回数据")
	private T result;

	public BaseResponse(T result ,boolean success ,int code, String message) {
		this.result = result;
		this.success = success;
		this.code = code;
		this.message = message;
	}

	public static BaseResponse success(Object result) {
		return new BaseResponse(result, Boolean.TRUE, 200, "");
	}

	public static BaseResponse fail(String message) {
		return new BaseResponse((Object)null, Boolean.FALSE, 200, message);
	}

	public static BaseResponse fail(Object result, String message) {
		return new BaseResponse(result, Boolean.FALSE, 200, message);
	}

	public static BaseResponse fail(Integer code, String message) {
		return new BaseResponse((Object)null, Boolean.FALSE, code, message);
	}

}
