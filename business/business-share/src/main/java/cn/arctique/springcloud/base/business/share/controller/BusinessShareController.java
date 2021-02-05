package cn.arctique.springcloud.base.business.share.controller;

import cn.arctique.springcloud.base.common.util.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.arctique.springcloud.base.share.provider.api.service.ShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author arctique
 * @date 2020/9/16 14:09
 */
@RestController
@RequestMapping("/share")
@Api("share")
public class BusinessShareController {

    @Reference(version = "1.0.0")
    private ShareService shareService;

    /**
     * 测试接口 hello world
     *
     * @param string
     * @return {@link Result}
     */
    @ApiOperation(value = "看个der1")
    @GetMapping("/getString")
    public Result getString(String string) {
        return Result.success(HttpStatus.OK.value(), "测试成功", shareService.getString(string));
    }


    /**
     * 测试接口 链接数据库 分页查找share表中的所有数据
     *
     * @param page
     * @return {@link Result}
     */
    @ApiOperation(value = "看个der2")
    @GetMapping("/findAll")
    public Result findAll(Page page) {
        return Result.success(HttpStatus.OK.value(), "测试成功", shareService.findAll(page));
    }
}
