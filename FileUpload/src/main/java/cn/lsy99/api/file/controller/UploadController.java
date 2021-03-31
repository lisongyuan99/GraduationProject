package cn.lsy99.api.file.controller;

import cn.lsy99.api.file.exception.exception.FileErrorException;
import cn.lsy99.api.file.exception.exception.NoTokenException;
import cn.lsy99.api.file.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("file")
public class UploadController {

    private static final String FILE_DIR = "/srv/static/activity_publish/";
    // private static final String FILE_DIR = "D:\\";
    private static final String URL_PREFIX = "https://static.lsy99.cn/activity_publish/";
    @Value("${http.token.header}")
    private String tokenHeader;

    @PostMapping("upload")
    public String upload(@RequestHeader Map<String, String> headers, @RequestParam("file") MultipartFile multipartFile) {
        String token = headers.get(tokenHeader);
        if (token == null) {
            throw new NoTokenException();
        } else {
            JwtUtil.getInfoFromToken(token);
        }

        try {
            if (!multipartFile.isEmpty()) {
                // 文件夹路径为根路径加日期,判断是否存在
                File dir = new File(FILE_DIR);
                if (!dir.exists() && !dir.mkdirs()) {
                    throw new FileErrorException();
                }
                if (dir.exists() && !dir.isDirectory()) {
                    throw new FileErrorException();
                }
                // 获取文件字节流
                byte[] bytes = multipartFile.getBytes();

                // 获取文件sha256
                MessageDigest messageDigest = MessageDigest.getInstance("SHA3-256");
                byte[] shaBytes = messageDigest.digest(bytes);
                StringBuilder sha = new StringBuilder();
                for (byte b : shaBytes) {
                    sha.append(String.format("%02x", b));
                }

                // 获取文件扩展名
                String originName = multipartFile.getOriginalFilename();
                String ext = "";
                if (originName != null) {
                    int temp = originName.lastIndexOf(".");
                    if (temp >= 0) {
                        ext = originName.substring(temp);
                    }
                }

                // 生成文件并返回
                String generateFileName = sha.toString() + "_" + bytes.length + ext;
                File file = new File(dir + "/" + generateFileName);
                if (!file.exists()) {
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(bytes, 0, bytes.length);
                    fos.flush();
                    fos.close();
                    return URL_PREFIX + generateFileName;
                } else {
                    return URL_PREFIX + generateFileName;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileErrorException();
        }
        return "";
    }
}
