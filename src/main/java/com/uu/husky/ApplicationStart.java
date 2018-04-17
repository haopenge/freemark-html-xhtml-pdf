package com.uu.husky;

import com.itextpdf.text.DocumentException;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.uu.husky.entity.Student;
import com.uu.husky.html2pdf.XHtml2Pdf;
import com.uu.husky.utils.FreeMarkToHtml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * 描述：
 *
 * @author liupenghao
 * @create 2018-04-17 9:58
 **/
public class ApplicationStart {
    public static void main(String[] args) {

        URL url = Thread.currentThread().getContextClassLoader().getResource("");

        Map replaceData = initData();

        FreeMarkToHtml.freemarkToHtml(url.getPath(), "template.ftl", replaceData, url.getPath() + "result.html");

        try {
            XHtml2Pdf.XHtml2Pdf(url.getPath() + "result.html", url.getPath() + "result.pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (CssResolverException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, Object> initData() {
        HashMap<String, Object> needReplaceMapData = new HashMap<String, Object>();
        /******************************************单个属性************************************/
        needReplaceMapData.put("name", "刘亦菲");


        /******************************************list 属性添加***********************************/
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 2; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName(" 葫芦娃" + i + "号");
            students.add(student);
        }
        needReplaceMapData.put("students", students);

        /******************************************日期 ***********************************/
        needReplaceMapData.put("date", new Date());

        needReplaceMapData.put("showDate", true);

        needReplaceMapData.put("imgUrl", "http://n.sinaimg.cn/translate/344/w700h1244/20180410/B_F_-fyzeyqa1740187.jpg");

        needReplaceMapData.put("description", "描述                        一只猫");
        return needReplaceMapData;
    }
}
