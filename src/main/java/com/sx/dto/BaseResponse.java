package com.sx.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseResponse<T> {
	@ApiModelProperty(value = "返回码：正确0, 警告2，错误为自定义码")
	private int responseCode;
	@ApiModelProperty(value = "返回消息")
	private String responseMsg;
	@ApiModelProperty(value = "返回具体内容")
	private T result;

	public BaseResponse(int responseCode, String responseMsg, T result) {
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
		this.result = result;
	}
	//这两个方法写在这里纯粹为了省地儿
	public static BaseResponse generateOKResponseEntity(Object object) {
		return new BaseResponse<>(200, "Success", object);
	}

	public static BaseResponse generateBadResponseEntity(String message, Object object) {
		return new BaseResponse<>(500, message, object);
	}

	public static BaseResponse generateBadResponseEntity(int code, String message, Object object) {
		return new BaseResponse<>(code, message, object);
	}

}
