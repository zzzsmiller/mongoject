package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 3/18/13
 * Time: 6:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldFreemarkerStyle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

        try {
            Template template = configuration.getTemplate("hello.ftl");
            HashMap<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "Free MTF marker");
            StringWriter stringWriter = new StringWriter();
            template.process(helloMap, stringWriter);
            System.out.println(stringWriter);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
