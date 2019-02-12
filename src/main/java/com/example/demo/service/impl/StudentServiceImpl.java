package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.ExcelBean;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.example.demo.util.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public List studentLogin(int start, int num) {

        List<Student> list = studentMapper.studentLogin(start, num);
        return list;
    }

    @Override
    public void addStudent(Student student,int dclass) {
        Map map = new HashMap();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date1 = df.format(new Date()).split("-")[0];
        String date2 = student.getSbrithday().split("-")[0];
        System.out.println(date1 + "==========" + date2);
        student.setSage(Integer.parseInt(date1) - Integer.parseInt(date2));
        student.setClassid(dclass);
        map.put("student", student);
        studentMapper.addStudent(map);

    }

    @Override
    public void delStudent(int id) {
        studentMapper.delStudent(id);
    }

    @Override
    public void delAll(String[] arr) {
        studentMapper.delAll(arr);
    }

    @Override
    public XSSFWorkbook exportExcelInfo(String filename) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException {
        List<Student> list = studentMapper.selectAllStudent();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(i + 1);
        }
        List<ExcelBean> excel = new ArrayList<>();
        Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook = null;
        //设置标题栏"名称","单位","单价","库存量","采购日期","备注信息"
        excel.add(new ExcelBean("序号", "id", 0));
        excel.add(new ExcelBean("学生名", "sname", 0));
        excel.add(new ExcelBean("学生密码", "spassword", 0));
        excel.add(new ExcelBean("学生手机号", "sphone", 0));
        excel.add(new ExcelBean("学生学号", "snumber", 0));
        excel.add(new ExcelBean("学生年龄", "sage", 0));
        excel.add(new ExcelBean("学生生日", "sbrithday", 0));
        map.put(0, excel);
        String sheetName =filename + ".xlsx";
        //调用ExcelUtil的方法  生成excel表格文件
        xssfWorkbook = ExcelUtil.createExcelFile(Student.class, list, map, sheetName);
        return xssfWorkbook;
    }

    @Override
    public void importExcelInfo(InputStream in, MultipartFile file) throws Exception {
        List<List<Object>> listob = ExcelUtil.getBankListByExcel(in, file.getOriginalFilename());
        //遍历listob数据，把数据放到List中
        for (int i = 0; i < listob.size(); i++) {
            List<Object> ob = listob.get(i);
            Student student= new Student();
            student.setSname((String)ob.get(1));
            student.setSpassword((String) ob.get(2));
            student.setSphone((String) ob.get(3));
            student.setSnumber((String)ob.get(4));
            student.setSage(Integer.parseInt((String) ob.get(5)));
            student.setSbrithday((String) ob.get(6));
           List list=new ArrayList();
           list.add(student);
            studentMapper.saveexcel(list);
        }
    }

    @Override
    public Student selStudent(Student student) {
        Map map=new HashMap();
        map.put("student",student);

       return studentMapper.selStudent(map);

    }
}
