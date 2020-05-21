package com.example.libraryse.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
public class FileUploadConfig {

        /**
         * 文件上传配置
         * @return
         */
        @Bean
        public MultipartConfigElement multipartConfigElement() {
            MultipartConfigFactory factory = new MultipartConfigFactory();
            //文件最大
            factory.setMaxFileSize(DataSize.parse("300960KB")); //KB,MB
            /// 设置总上传数据总大小
            factory.setMaxRequestSize(DataSize.parse("309600KB"));
            return factory.createMultipartConfig();
        }
    }

