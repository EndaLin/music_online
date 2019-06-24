package com.dgut.music_online.tool;

import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileOperator {
    public static String fileUploud(MultipartFile file) throws IOException {
        //获取项目根路径
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        //获取文件后缀名
        String backName = file.getOriginalFilename().split("\\.")[1];
        //生成UUID随机文件名   UUID主要是为了避免文件名重复 导致覆盖旧的文件
        String fileName = UUID.randomUUID().toString().replaceAll("-","") + "." + backName;
        //生成图片的相对路径
        String relativePath = null;
        // 如果是mp3 文件
        if (backName.equals("mp3"))
            relativePath = "/songs/"+ fileName;
        else
            relativePath = "/images/" + fileName;

        //拼接成完整路径
        path =path + "/static" + relativePath;
        //创建文件到指定路径
        file.transferTo(new File(path));

        return relativePath;
    }
}
