package org.word.controller;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.word.service.WordService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by XiuYin.Cui on 2018/1/11.
 */
@Controller
public class WordController {

    @Autowired
    private WordService tableService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${swagger.url}")
    private String swaggerUrl;

    @Value("${server.port}")
    private Integer port;

    /**
     * 将 swagger 文档转换成 html 文档，可通过在网页上右键另存为 xxx.doc 的方式转换为 word 文档
     *
     * @param model
     * @param url   需要转换成 word 文档的资源地址
     * @return
     */
    @Deprecated
    @RequestMapping("/toWord")
    public String getWord(Model model, @RequestParam(value = "url", required = false) String url,
                          @RequestParam(value = "download", required = false, defaultValue = "1") Integer download) {
        url = StringUtils.defaultIfBlank(url, swaggerUrl);
        Map<String, Object> result = tableService.tableList(url);
        model.addAttribute("url", url);
        model.addAttribute("download", download);
        model.addAllAttributes(result);
        return "word";
    }

    /**
     * 将 swagger 文档一键下载为 doc 文档
     *
     * @param url      需要转换成 word 文档的资源地址
     * @param response
     */
    @RequestMapping("/downloadWord")
    public void word(@RequestParam(required = false) String url, HttpServletResponse response) {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + port + "/toWord?download=0&url=" + StringUtils.defaultIfBlank(url, swaggerUrl), String.class);
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        try (BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream())) {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("toWord.doc", "utf-8"));
            byte[] bytes = forEntity.getBody().getBytes();
            bos.write(bytes, 0, bytes.length);
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 处理下载word文档
    @RequestMapping("/download1")
    public void downloadWord(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            // 告诉浏览器用什么软件可以打开此文件
            response.setHeader("content-Type", "application/msword");
            // 下载文件的默认名称
            response.setHeader("Content-Disposition", "attachment;filename=test.doc");
            Map<String, Object> dataMap = this.getData("");
            //创建配置实例对象
            Configuration configuration = new Configuration();
            //设置编码
            configuration.setDefaultEncoding("UTF-8");
            //加载需要装填的模板
            configuration.setClassForTemplateLoading(this.getClass(), "/");
            //设置对象包装器
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            //设置异常处理器
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
            //获取ftl模板对象
            Template template = configuration.getTemplate("template.ftl", "UTF-8");
            //输出文档
            StringBuilder fileName = new StringBuilder("");
            String uuid = UUID.randomUUID().toString();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
            fileName.append(uuid).append("_").append(sdf1.format(new Date())).append("test").append(".doc");

            try {
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment;filename="
                        + new String(fileName.toString().getBytes("GBK"), "ISO-8859-1"));
                response.setCharacterEncoding("utf-8");//处理乱码问题
                //生成Word文档
                template.process(dataMap, response.getWriter());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                response.flushBuffer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> getData(String url) {
        Map<String, Object> dataMap = new HashMap<>();
        url = StringUtils.defaultIfBlank(url, swaggerUrl);
        Map<String, Object> result = tableService.tableList(url);
        result.put("test","test");
        return result;
    }


}
