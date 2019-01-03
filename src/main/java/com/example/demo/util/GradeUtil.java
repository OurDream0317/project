package com.example.demo.util;

import com.example.demo.model.xzc;

public class GradeUtil {
    public xzc selectGrade(int xy,int zy,int cla){
      xzc xzc1=new xzc();
        switch (xy){
            case 1:
                xzc1.setXy1("信息与技术学院");
                break;
            case 2:
                xzc1.setXy1("人文学院");
                break;
            case 3:
                xzc1.setXy1("数学与统计学院");
                break;
            case 4:
                xzc1.setXy1("电子电气工程学院");
                break;
            case 5:break;
            case 6:break;
            case 7:break;
            case 8:break;
            case 9:break;
            case 10:break;
            case 11:break;
            case 12:break;
            case 13:break;
            case 14:break;
            case 15:break;
            case 16:break;
            case 17:break;
            case 18:break;
            case 19:break;
            case 20:break;
            case 21:break;
            case 22:break;
            case 23:break;

        }
        switch (zy){
            case 1:
                xzc1.setZy2("软件工程");
                break;
            case 2:
                xzc1.setZy2("物联网工程");
                break;
            case 3:
                xzc1.setZy2("数据科学与大数据技术");
                break;
            case 4:
                xzc1.setZy2("电子商务");
                break;
            case 5:
                xzc1.setZy2("汉语言文学");
                break;
            case 6:break;
            case 7:break;
            case 8:break;
            case 9:break;
            case 10:break;
            case 11:break;
            case 12:break;
            case 13:break;
            case 14:break;
            case 15:break;
            case 16:break;
            case 17:break;
            case 18:break;
            case 19:break;
            case 20:break;

        }
        switch (cla){
            case 1:
                xzc1.setCla3("软件工程1班");
                break;
            case 2:
                xzc1.setCla3("物联网1班");break;
            case 3:
                xzc1.setCla3("电子商务1班");break;
            case 4:
                xzc1.setCla3("电子商务2班");break;
            case 5:
                xzc1.setCla3("数据科学与大数据技术1班");break;
            case 6:
                xzc1.setCla3("数据科学与大数据技术2班");break;
            case 7:break;
            case 8:break;
            case 9:break;
            case 10:break;

        }
        return xzc1;
    }
}
