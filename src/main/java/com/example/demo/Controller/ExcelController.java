package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/excel")
public class ExcelController {
    @Resource
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;
    @RequestMapping("/export")
    @ResponseBody
    public  void export(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException, java.text.ParseException {
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet("学生信息表");
        String[] title={"序号","学生名","学生密码","学院名称","专业名称","班级名称","学生手机号","学生学号","学生年龄","学生生日"};
        HSSFRow row=sheet.createRow(0);
        for (int i=0;i<title.length;i++){
            HSSFCell cell=row.createCell(i);
            HSSFRichTextString text=new HSSFRichTextString(title[i]);
            cell.setCellValue(text);
        }
        List<Student> list = studentMapper.selectAllStudent();
        System.out.println(JSON.toJSONString(list));
        int i=0;
        for (Student student:list) {
            HSSFRow row1=sheet.createRow(i+1);
           row1.createCell(0).setCellValue(i+1);
            row1.createCell(1).setCellValue(student.getSname());
            row1.createCell(2).setCellValue(student.getSpassword());
            row1.createCell(3).setCellValue(student.getXyName());
            row1.createCell(4).setCellValue(student.getZyName());
            row1.createCell(5).setCellValue(student.getCname());
            row1.createCell(6).setCellValue(student.getSphone());
            row1.createCell(7).setCellValue(student.getSnumber());
            row1.createCell(8).setCellValue(student.getSage());
            row1.createCell(9).setCellValue(student.getSbrithday());
           i++;
        }
        String filename="学生信息"+System.currentTimeMillis()+".xlsx";
        try {
            try {
                  filename=new String(filename.getBytes(),"ISO8859-1");
            }catch (Exception e){
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            OutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/import")
    public String impotr(MultipartFile file, Model model) throws Exception {
        int adminId = 1;
        //获取上传的文件
        /*String month = request.getParameter("month");*/

        InputStream in =file.getInputStream();
        //数据导入
        studentService.importExcelInfo(in,file);
        in.close();
        return "redirect:/student-list.html";
    }
}
