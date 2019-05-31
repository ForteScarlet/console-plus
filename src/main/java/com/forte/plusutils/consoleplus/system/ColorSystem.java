package com.forte.plusutils.consoleplus.system;

import com.forte.plusutils.consoleplus.FortePlusPrintStream;
import com.forte.plusutils.consoleplus.console.Colors;
import com.forte.plusutils.consoleplus.console.colors.ColorTypes;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.function.Function;

/**
 * 颜色控制台(未完成)
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class ColorSystem {

    private static final String OUT_TYPE = "OUT";
    private static final ColorTypes OUT_COLOR = Colors.FONT.WHITE;
    public static final PrintStream out;

    private static final ColorTypes ERR_COLOR = Colors.FONT.RED;
    private static final String ERR_TYPE = "ERR";
    public static final PrintStream err;

    private static final ColorTypes INFO_COLOR = Colors.FONT.BLUE;
    private static final String INFO_TYPE = "INFO";
    public static final PrintStream info;

    private static final ColorTypes DEBUG_COLOR = Colors.FONT.PURPLE;
    private static final String DEBUG_TYPE = "DEBUG";
    public static final PrintStream debug;

    static {
        out = getTimeTypePrintStream(System.out, OUT_TYPE, OUT_COLOR);
        err = getTimeTypePrintStream(System.out, ERR_TYPE, ERR_COLOR);

        info = getTimeTypePrintStream(System.out, INFO_TYPE, INFO_COLOR);
        debug = getTimeTypePrintStream(System.out, DEBUG_TYPE, DEBUG_COLOR);
    }

    private static PrintStream getTimeTypePrintStream(PrintStream printStream, String type, ColorTypes typeColor){
        try {
            return FortePlusPrintStream.getInstance(printStream, obj -> {
                Colors timeColors = getTimeStr(Colors.FONT.BLUE);
                Colors typeColors = getTypeStr(type, typeColor);
                return timeColors + " " + typeColors + " " + obj;
            });
        } catch (IllegalAccessException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Colors getTimeStr(ColorTypes typeColor){
        return Colors.builder().add("[" + LocalDateTime.now().toString() + "]", typeColor).build();
    }

    private static Colors getTypeStr(String type, ColorTypes typeColor){
        return Colors.builder()
                .add("[", Colors.FONT.BLUE)
                .add(type, typeColor)
                .add("]", Colors.FONT.BLUE)
                .build();
    }


    private static PrintStream getTimeTypePrintStream(PrintStream printStream, String type){
        return getTimeTypePrintStream(printStream, type, Colors.FONT.WHITE);
    }

    public static void setOutFunction(Function<Object, String> function){
        setFunction(function, (FortePlusPrintStream)out);
    }
    public static void setErrFunction(Function<Object, String> function){
        setFunction(function, (FortePlusPrintStream)err);
    }
    public static void setInfoFunction(Function<Object, String> function){
        setFunction(function, (FortePlusPrintStream)info);
    }
    public static void setDebugFunction(Function<Object, String> function){
        setFunction(function, (FortePlusPrintStream)debug);
    }

    public static void setOutTextFunction(Function<String, String> textFunction){
        setTextFunction(textFunction, (FortePlusPrintStream)out, OUT_TYPE, OUT_COLOR);
    }
    public static void setErrTextFunction(Function<String, String> textFunction){
        setTextFunction(textFunction, (FortePlusPrintStream)err, ERR_TYPE, ERR_COLOR);
    }
    public static void setInfoTextFunction(Function<String, String> textFunction){
        setTextFunction(textFunction, (FortePlusPrintStream)info, INFO_TYPE, INFO_COLOR);
    }
    public static void setDebugTextFunction(Function<String, String> textFunction){
        setTextFunction(textFunction, (FortePlusPrintStream)debug, DEBUG_TYPE, DEBUG_COLOR);
    }

    private static void setFunction(Function<Object, String> function, FortePlusPrintStream stream){
        stream.setPrintFunction(function);
    }

    private static void setTextFunction(Function<String, String> textFunction, FortePlusPrintStream stream, String type, ColorTypes colorTypes){
        stream.setPrintFunction(getTextFunction(textFunction, type, colorTypes));
    }

    private static Function<Object, String> getTextFunction(Function<String, String> textFunction, String type, ColorTypes colorTypes){
        return obj -> {
            Colors timeColors = getTimeStr(Colors.FONT.BLUE);
            Colors typeColors = getTypeStr(type, colorTypes);
            return timeColors + " " + typeColors + " " + textFunction.apply(String.valueOf(obj));
        };
    }

}
