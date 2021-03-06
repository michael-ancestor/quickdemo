package com.jack.maven.webapp;

import org.apache.http.HttpEntity;

import javax.servlet.*;
import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;

public class JdkHttp implements Servlet {
    public void init(ServletConfig pa) throws ServletException {
        System.out.println("init");
    }
    public ServletConfig getServletConfig() {
        return null;
    }
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("service it "+req.getClass().getName());

        PrintWriter pw=resp.getWriter();

        try {

            URL url = new URL("http://www.baidu.com");
            HttpURLConnection conn = (HttpURLConnection )url.openConnection();

            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.connect();

            OutputStream outs = conn.getOutputStream();
            InputStream ins = conn.getInputStream();

            int count = 10;
            byte[] buf = new byte[count];
            int readCount = 0; // 已经成功读取的字节的个数
            while (readCount < count) {
                readCount += ins.read(buf, readCount, count - readCount);
            }

            String msg = new String(buf);
            System.out.println("get " + msg);

	    pw.println("got msg "+msg);
        } catch (Exception e) {
            System.out.println("got exception:"+e);
            e.printStackTrace();
	    pw.println("got exeception "+e);
        }

    }
    public String getServletInfo() {
        return "";
    }
    public void destroy() {
        System.out.println("destroy!");
    }
}
