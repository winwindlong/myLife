package com.dream.myLife.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zhang on 2018/2/26.
 */
//@WebServlet(name = "pageRedirectServlet", urlPatterns = {"/pageRedirectServlet"})
public class pageRedirectServlet  extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
//        // 设置响应内容类型
//        response.setContentType("text/html;charset=UTF-8");
//
//        // 要重定向的新位置
//        String site = new String("http://www.runoob.com");
//
//        response.setStatus(response.SC_MOVED_TEMPORARILY);
//        response.setHeader("Location", site);

//        // 设置响应内容类型
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        // 获取客户端的区域设置
//        Locale locale = request.getLocale( );
//        NumberFormat nft = NumberFormat.getPercentInstance(locale);
//        String formattedPerc = nft.format(0.51);
//
//        String title = "特定于区域设置的百分比";
//        String docType = "<!DOCTYPE html> \n";
//        out.println(docType +
//                "<html>\n" +
//                "<head><title>" + title + "</title></head>\n" +
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1 align=\"center\">" + formattedPerc + "</h1>\n" +
//                "</body></html>");

//        // 设置响应内容类型
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        // 获取客户端的区域设置
//        Locale locale = request.getLocale( );
//        NumberFormat nft = NumberFormat.getCurrencyInstance(locale);
//        String formattedCurr = nft.format(1000000);
//
//        String title = "特定于区域设置的货币";
//        String docType = "<!DOCTYPE html> \n";
//        out.println(docType +
//                "<html>\n" +
//                "<head><title>" + title + "</title></head>\n" +
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1 align=\"center\">" + formattedCurr + "</h1>\n" +
//                "</body></html>");

//        // 设置响应内容类型
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        // 获取客户端的区域设置
//        Locale locale = request.getLocale( );
//        String date = DateFormat.getDateTimeInstance(
//                DateFormat.FULL,
//                DateFormat.SHORT,
//                locale).format(new Date( ));
//
//        String title = "特定于区域设置的日期";
//        String docType = "<!DOCTYPE html> \n";
//        out.println(docType +
//                "<html>\n" +
//                "<head><title>" + title + "</title></head>\n" +
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1 align=\"center\">" + date + "</h1>\n" +
//                "</body></html>");

        // 设置响应内容类型
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        // 设置西班牙语言代码
//        response.setHeader("Content-Language", "es");
//
//        String title = "En Espa&ntilde;ol";
//        String docType = "<!DOCTYPE html> \n";
//        out.println(docType +
//                "<html>\n" +
//                "<head><title>" + title + "</title></head>\n" +
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1>" + "En Espa&ntilde;ol:" + "</h1>\n" +
//                "<h1>" + "&iexcl;Hola Mundo!" + "</h1>\n" +
//                "</body></html>");

        // 获取客户端的区域设置
        Locale locale = request.getLocale();
        String language = locale.getLanguage();
        String country = locale.getCountry();

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String title = "检测区域设置";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + language + "</h1>\n" +
                "<h2 align=\"center\">" + country + "</h2>\n" +
                "</body></html>");
    }

}
