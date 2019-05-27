package com.forte.utils.consoleplus.system;

import java.io.*;
import java.util.function.Function;

/**
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class PrintSrteamPlus extends PrintStream {

    /** 字符串打印转化 */
    private final Function<?, String> peek;

    /**
     * Creates a new print stream.
     *
     * @param out       The output stream to which values and objects will be
     *                  printed
     * @param autoFlush A boolean; if true, the output buffer will be flushed
     *                  whenever a byte array is written, one of the
     *                  <code>println</code> methods is invoked, or a newline
     *                  character or byte (<code>'\n'</code>) is written
     * @param encoding  The name of a supported
     *                  <a href="../lang/package-summary.html#charenc">
     *                  character encoding</a>
     * @throws UnsupportedEncodingException If the named encoding is not supported
     * @since 1.4
     */
    private PrintSrteamPlus(OutputStream out, boolean autoFlush, String encoding, Function<?, String> peek) throws UnsupportedEncodingException {
        super(out, autoFlush, encoding);
        this.peek = peek;
    }

    public static PrintSrteamPlus build(Function<?, String> peek, String encoding) throws UnsupportedEncodingException {
        return new PrintSrteamPlus(new OutputStream() {
            @Override
            public void write(int b) { }
        }, false, encoding, peek);
    }



}
