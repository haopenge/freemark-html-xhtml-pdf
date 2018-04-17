package com.uu.husky.html2pdf;

import org.w3c.tidy.Tidy;

import java.io.*;

/**
 * 将html 转换成为严格的XHTML
 */
public class Html2Xhtml {

    /**
     * 转化类
     *
     * @param html  html文件输入路径(带文件名称)
     * @param xhtml xhtml文件输入路径(带文件名称)
     * @return
     */
    public static String html2Xhtml(String html, String xhtml) {

        String path = null;
        try {
            FileInputStream fin = new FileInputStream(html);
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            int data = -1;
            while ((data = fin.read()) != -1) {
                byteArrayOut.write(data);
            }
            fin.close();
            byte[] htmlFileData = byteArrayOut.toByteArray();

            byteArrayOut.close();

            ByteArrayInputStream tidyInput = new ByteArrayInputStream(
                    htmlFileData);
            ByteArrayOutputStream tidyOut = new ByteArrayOutputStream();
            Tidy tidy = new Tidy();
            tidy.setInputEncoding("UTF-8");
            tidy.setOutputEncoding("UTF-8");
            tidy.setShowWarnings(false);
            tidy.setIndentContent(true);
            tidy.setSmartIndent(true);
            tidy.setIndentAttributes(false);
            tidy.setMakeClean(true);
            tidy.setQuiet(true);
            tidy.setWord2000(true);
            tidy.setXHTML(true);
            tidy.setErrout(new PrintWriter(System.out));

            tidy.parse(tidyInput, tidyOut);
            tidyInput.close();
            tidyOut.writeTo(new FileOutputStream(xhtml));
            tidyOut.flush();
            tidyOut.close();
            path = xhtml;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            path = null;
        } catch (IOException e) {
            e.printStackTrace();
            path = null;
        }

        return path;
    }

}
