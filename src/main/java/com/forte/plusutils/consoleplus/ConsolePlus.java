package com.forte.plusutils.consoleplus;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.function.Function;

/**
 * 控制台PLUS
 * - 获取彩色输出器
 * - 改变{@link System}的out、err
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class ConsolePlus {

    /**
     * 取代System.out对象
     * @throws UnsupportedEncodingException
     * @throws IllegalAccessException
     */
    public static void updatePrint(Function<String, String> printFunction) throws UnsupportedEncodingException, IllegalAccessException {
        PrintStream out = System.out;
        FortePlusPrintStream fortePlusPrintStream = new FortePlusPrintStream(new OutputStream() {
            @Override
            public void write(int b){}
        }, true, "UTF-8");


        //PrintStream的参数
        Field[] declaredFields = PrintStream.class.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object o = field.get(out);
            field.set(fortePlusPrintStream, o);
        }

        if(printFunction != null){
            fortePlusPrintStream.setPrintFunction(printFunction);
        }

        //取代对象
        System.setOut(fortePlusPrintStream);
    }

    /**
     * 取代System.out对象
     * @throws UnsupportedEncodingException
     * @throws IllegalAccessException
     */
    public static void updatePrint() throws UnsupportedEncodingException, IllegalAccessException {
        updatePrint(null);
    }



}
