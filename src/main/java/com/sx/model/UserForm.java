package com.sx.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */

@Data
@ApiModel("企业用户基本信息")
public class UserForm {
	/**
	 * ApiModelProperty()用于方法，字段 表示对model属性的说明或者数据操作更改
	 * value–字段说明
	 * name–重写属性名字
	 * dataType–重写属性类型
	 * required–是否必填
	 * example–举例说明
	 * hidden–隐藏
	 */
	@ApiModelProperty(value="用户id",example="1")
	private Long id;

	@ApiModelProperty(value="用户名",example="zhangxin")
	private String username;

	@ApiModelProperty(value="密码",example="123456")
	private String password;

	@ApiModelProperty(value="id集合",example="[1,2]")
	private List idList;

}