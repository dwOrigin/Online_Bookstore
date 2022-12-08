package com.springboot.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

public class generator {
    public static void main(String[] args) {
        generator();
    }
    private static void generator(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/online_bookstore?serverTimezone=UTC", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("book_store") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\Users\\chen9\\OneDrive - 东南大学\\大三上学期\\数据库原理\\作业四\\online_bookstore\\springboot\\src\\main\\java");//个人要修改
//
                })
                .packageConfig(builder -> {
                    builder.parent("com.springboot") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "C:\\Users\\chen9\\OneDrive - 东南大学\\大三上学期\\数据库原理\\作业四\\online_bookstore\\springboot\\src\\main\\resources\\mapper\\")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok();//驼峰
                    builder.controllerBuilder().enableHyphenStyle()
                            .enableRestStyle();//
                    builder.addInclude("Users","Books","Search","Shoppings"); // 设置需要生成的表名

//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .execute();
    }
}
