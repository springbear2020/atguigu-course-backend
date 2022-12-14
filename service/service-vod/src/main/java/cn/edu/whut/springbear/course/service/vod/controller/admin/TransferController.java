package cn.edu.whut.springbear.course.service.vod.controller.admin;

import cn.edu.whut.springbear.course.common.util.Result;
import cn.edu.whut.springbear.course.service.vod.service.TransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Spring-_-Bear
 * @datetime 2022-10-21 09:43
 */
@RestController
@Api(tags = "文件管理接口")
@RequestMapping("admin/vod/transfer")
public class TransferController {
    @Autowired
    private TransferService transferService;

    /**
     * 文件上传至腾讯云对象存储空间
     */
    @ApiOperation("文件上传")
    @PostMapping("upload")
    public Result upload(@ApiParam(name = "file", value = "文件对象", required = true) @RequestParam("file") MultipartFile file) {
        String accessUrl = transferService.fileUpload(file);
        return accessUrl == null ? Result.fail("上传文件至腾讯云失败", null) : Result.success("上传文件至腾讯云成功", accessUrl);
    }
}
