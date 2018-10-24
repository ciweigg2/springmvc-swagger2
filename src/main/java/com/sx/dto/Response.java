package com.sx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Administrator on 2018/10/24.
 */
@Data
@AllArgsConstructor
public class Response<T> {

	private String code;

	private String message;

	private String status;

	private T object;

}
