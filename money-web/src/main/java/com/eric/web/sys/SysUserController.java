package com.eric.web.sys;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric
 * @date 2021/4/27 22:45
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @GetMapping("/test")
    public void test() {
        System.out.println("多模块测试");
    }
}
