package cn.lsy99.api.activity.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("file")
public class FileController {
    @PostMapping("upload")
    public String upload(@RequestBody Object body){
        log.info(body.toString());
        return "";
    }

    @PostMapping("uploadMany")
    public String uploadMany(@RequestBody Object body){
        return "";
    }
}
