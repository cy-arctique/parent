package cn.arctique.springcloud.base.business.index.controller;

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
@RequestMapping("/index")
@Api("index")
public class BusinessIndexController {

    @Reference(version = "1.0.0")
    private ShareService shareService;

    /**
     * 测试接口 链接数据库 分页查找share表中的所有数据
     *
     * @param page
     * @return {@link Result}
     */
    @GetMapping("/findAll")
    @ApiOperation("测试读取数据库接口")
    public Result findAll1(Page page) {
        return Result.success(HttpStatus.OK.value(), "测试成功", shareService.findAll(page));
    }

    /**
     * 测试接口 hello world
     *
     * @param string
     * @return {@link Result}
     */
    @GetMapping("/getString")
    @ApiOperation("测试hello world接口")
    public Result getString1(String string) {
        return Result.success(HttpStatus.OK.value(), "测试成功", shareService.getString(string));
    }
}
