package com.example.demo.Controller;

import com.example.demo.service.StudentService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/excel")
public class ExcelController {
    @Resource
    private StudentService studentService;
    @RequestMapping("/export")
    @ResponseBody
    public  void export(HttpServletRequest request, HttpServletResponse response, String filename) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException, java.text.ParseException {

        if(filename!=""){
            response.reset(); //清除buffer缓存
            Map<String,Object> map=new HashMap<String,Object>();
            // 指定下载的文件名，浏览器都会使用本地编码，即GBK，浏览器收到这个文件名后，用ISO-8859-1来解码，然后用GBK来显示
            // 所以我们用GBK解码，ISO-8859-1来编码，在浏览器那边会反过来执行。
            try {
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("GBK"),"ISO-8859-1"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            XSSFWorkbook workbook=null;
            //导出Excel对象
            workbook = studentService.exportExcelInfo(filename);
            System.out.println(filename+"===================");
            String path="D:\\"+filename+".xlsx";
            try {
                OutputStream out = new FileOutputStream(path);
                //output = response.getOutputStream();
                BufferedOutputStream bufferedOutPut = new BufferedOutputStream(out);
                bufferedOutPut.flush();
                workbook.write(bufferedOutPut);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/import")
    public String impotr(MultipartFile file, Model model) throws Exception {
        int adminId = 1;
        System.out.println(file.getOriginalFilename()+"22222222");
        //获取上传的文件
        /*String month = request.getParameter("month");*/

        InputStream in =file.getInputStream();
        //数据导入
        studentService.importExcelInfo(in,file);
        in.close();
        return "login";
    }
}
