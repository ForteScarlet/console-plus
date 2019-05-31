package com.forte.plusutils.consoleplus;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
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
    public static void updatePrintOut(Function<Object, String> printFunction) throws UnsupportedEncodingException, IllegalAccessException {
        PrintStream out = System.out;

        FortePlusPrintStream fortePlusPrintStream = FortePlusPrintStream.getInstance(out, printFunction);

        //取代对象
        System.setOut(fortePlusPrintStream);
    }

    /**
     * 取代System.out对象
     * @throws UnsupportedEncodingException
     * @throws IllegalAccessException
     */
    public static void updatePrintOut() throws UnsupportedEncodingException, IllegalAccessException {
        updatePrintOut(null);
    }


    /**
     * 取代System.err
     * @throws UnsupportedEncodingException
     * @throws IllegalAccessException
     */
    public static void updatePrintErr(Function<Object, String> printFunction) throws UnsupportedEncodingException, IllegalAccessException {
        PrintStream err = System.err;
        FortePlusPrintStream fortePlusPrintStream = FortePlusPrintStream.getInstance(err, printFunction);

        //取代对象
        System.setErr(fortePlusPrintStream);
    }

    /**
     * 取代System.err对象
     * @throws UnsupportedEncodingException
     * @throws IllegalAccessException
     */
    public static void updatePrintErr() throws UnsupportedEncodingException, IllegalAccessException {
        updatePrintErr(null);
    }

}
