package com.sx.swagger;

import com.sx.dto.BaseResponse;
import com.sx.model.UserForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xyj
 * @Description:
 * @CreateTime: 2018/1/24 23:19
 * @Version:
 */

@Api(tags = "企业基本信息" ,description = "企业征信基本信息-基础段")
@RestController
public class DemoController {

    @ApiOperation(value = "测试swagger")
//    @ApiResponse(code = 200 ,responseContainer ="List" ,response=UserForm.class, message = "返回对象")
    @PostMapping(value = "/query")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idList" ,allowMultiple = true, paramType = "query", dataType = "string")//请求参数中带有list集合
    })
    public BaseResponse<List<UserForm>> query(@RequestBody UserForm userForm){
        List<UserForm> userFormList = new ArrayList<UserForm>();
        userFormList.add(userForm);
        return BaseResponse.success(userFormList);
    }
}
