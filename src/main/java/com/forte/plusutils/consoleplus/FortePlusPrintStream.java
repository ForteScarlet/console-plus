package com.forte.plusutils.consoleplus;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Function;

/**
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class FortePlusPrintStream extends PrintStream {

    /**
     * 消息转化器，默认不做处理
     */
    private Function<Object, String> printFunction = String::valueOf;

    /**
     * Creates a new print stream.  This stream will not flush automatically.
     *
     * @param out The output stream to which values and objects will be
     *            printed
     * @see PrintWriter#PrintWriter(OutputStream)
     */
    public FortePlusPrintStream(OutputStream out) {
        super(out);
    }

    /**
     * Creates a new print stream.
     *
     * @param out       The output stream to which values and objects will be
     *                  printed
     * @param autoFlush A boolean; if true, the output buffer will be flushed
     *                  whenever a byte array is written, one of the
     *                  <code>println</code> methods is invoked, or a newline
     *                  character or byte (<code>'\n'</code>) is written
     * @see PrintWriter#PrintWriter(OutputStream, boolean)
     */
    public FortePlusPrintStream(OutputStream out, boolean autoFlush) {
        super(out, autoFlush);
    }

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
    public FortePlusPrintStream(OutputStream out, boolean autoFlush, String encoding) throws UnsupportedEncodingException {
        super(out, autoFlush, encoding);
    }

    /**
     * Creates a new print stream, without automatic line flushing, with the
     * specified file name.  This convenience constructor creates
     * the necessary intermediate {@link OutputStreamWriter
     * OutputStreamWriter}, which will encode characters using the
     * {@linkplain Charset#defaultCharset() default charset}
     * for this instance of the Java virtual machine.
     *
     * @param fileName The name of the file to use as the destination of this print
     *                 stream.  If the file exists, then it will be truncated to
     *                 zero size; otherwise, a new file will be created.  The output
     *                 will be written to the file and is buffered.
     * @throws FileNotFoundException If the given file object does not denote an existing, writable
     *                               regular file and a new regular file of that name cannot be
     *                               created, or if some other error occurs while opening or
     *                               creating the file
     * @throws SecurityException     If a security manager is present and {@link
     *                               SecurityManager#checkWrite checkWrite(fileName)} denies write
     *                               access to the file
     * @since 1.5
     */
    public FortePlusPrintStream(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    /**
     * Creates a new print stream, without automatic line flushing, with the
     * specified file name and charset.  This convenience constructor creates
     * the necessary intermediate {@link OutputStreamWriter
     * OutputStreamWriter}, which will encode characters using the provided
     * charset.
     *
     * @param fileName The name of the file to use as the destination of this print
     *                 stream.  If the file exists, then it will be truncated to
     *                 zero size; otherwise, a new file will be created.  The output
     *                 will be written to the file and is buffered.
     * @param csn      The name of a supported {@linkplain Charset
     *                 charset}
     * @throws FileNotFoundException        If the given file object does not denote an existing, writable
     *                                      regular file and a new regular file of that name cannot be
     *                                      created, or if some other error occurs while opening or
     *                                      creating the file
     * @throws SecurityException            If a security manager is present and {@link
     *                                      SecurityManager#checkWrite checkWrite(fileName)} denies write
     *                                      access to the file
     * @throws UnsupportedEncodingException If the named charset is not supported
     * @since 1.5
     */
    public FortePlusPrintStream(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        super(fileName, csn);
    }

    /**
     * Creates a new print stream, without automatic line flushing, with the
     * specified file.  This convenience constructor creates the necessary
     * intermediate {@link OutputStreamWriter OutputStreamWriter},
     * which will encode characters using the {@linkplain
     * Charset#defaultCharset() default charset} for this
     * instance of the Java virtual machine.
     *
     * @param file The file to use as the destination of this print stream.  If the
     *             file exists, then it will be truncated to zero size; otherwise,
     *             a new file will be created.  The output will be written to the
     *             file and is buffered.
     * @throws FileNotFoundException If the given file object does not denote an existing, writable
     *                               regular file and a new regular file of that name cannot be
     *                               created, or if some other error occurs while opening or
     *                               creating the file
     * @throws SecurityException     If a security manager is present and {@link
     *                               SecurityManager#checkWrite checkWrite(file.getPath())}
     *                               denies write access to the file
     * @since 1.5
     */
    public FortePlusPrintStream(File file) throws FileNotFoundException {
        super(file);
    }

    /**
     * Creates a new print stream, without automatic line flushing, with the
     * specified file and charset.  This convenience constructor creates
     * the necessary intermediate {@link OutputStreamWriter
     * OutputStreamWriter}, which will encode characters using the provided
     * charset.
     *
     * @param file The file to use as the destination of this print stream.  If the
     *             file exists, then it will be truncated to zero size; otherwise,
     *             a new file will be created.  The output will be written to the
     *             file and is buffered.
     * @param csn  The name of a supported {@linkplain Charset
     *             charset}
     * @throws FileNotFoundException        If the given file object does not denote an existing, writable
     *                                      regular file and a new regular file of that name cannot be
     *                                      created, or if some other error occurs while opening or
     *                                      creating the file
     * @throws SecurityException            If a security manager is present and {@link
     *                                      SecurityManager#checkWrite checkWrite(file.getPath())}
     *                                      denies write access to the file
     * @throws UnsupportedEncodingException If the named charset is not supported
     * @since 1.5
     */
    public FortePlusPrintStream(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        super(file, csn);
    }


    /**
     * Prints a character.  The character is translated into one or more bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * <code>{@link #write(int)}</code> method.
     *
     * @param c The <code>char</code> to be printed
     */
    @Override
    public void print(char c) {
        super.print(printFunction.apply(c));
    }

    /**
     * Prints an integer.  The string produced by <code>{@link
     * String#valueOf(int)}</code> is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * <code>{@link #write(int)}</code> method.
     *
     * @param i The <code>int</code> to be printed
     * @see Integer#toString(int)
     */
    @Override
    public void print(int i) {
        super.print(printFunction.apply(i));
    }

    /**
     * Prints a long integer.  The string produced by <code>{@link
     * String#valueOf(long)}</code> is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * <code>{@link #write(int)}</code> method.
     *
     * @param l The <code>long</code> to be printed
     * @see Long#toString(long)
     */
    @Override
    public void print(long l) {
        super.print(printFunction.apply(l));
    }

    /**
     * Prints a floating-point number.  The string produced by <code>{@link
     * String#valueOf(float)}</code> is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * <code>{@link #write(int)}</code> method.
     *
     * @param f The <code>float</code> to be printed
     * @see Float#toString(float)
     */
    @Override
    public void print(float f) {
        super.print(printFunction.apply(f));
    }

    /**
     * Prints a double-precision floating-point number.  The string produced by
     * <code>{@link String#valueOf(double)}</code> is translated into
     * bytes according to the platform's default character encoding, and these
     * bytes are written in exactly the manner of the <code>{@link
     * #write(int)}</code> method.
     *
     * @param d The <code>double</code> to be printed
     * @see Double#toString(double)
     */
    @Override
    public void print(double d) {
        super.print(printFunction.apply(d));
    }

    /**
     * Prints an array of characters.  The characters are converted into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * <code>{@link #write(int)}</code> method.
     *
     * @param s The array of chars to be printed
     * @throws NullPointerException If <code>s</code> is <code>null</code>
     */
    @Override
    public void print(char[] s) {
        super.print(printFunction.apply(charArrayToStr(s)).toCharArray());
    }

    /**
     * Prints a string.  If the argument is <code>null</code> then the string
     * <code>"null"</code> is printed.  Otherwise, the string's characters are
     * converted into bytes according to the platform's default character
     * encoding, and these bytes are written in exactly the manner of the
     * <code>{@link #write(int)}</code> method.
     *
     * @param s The <code>String</code> to be printed
     */
    @Override
    public void print(String s) {
        super.print(printFunction.apply(s));
    }

    /**
     * Prints an object.  The string produced by the <code>{@link
     * String#valueOf(Object)}</code> method is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * <code>{@link #write(int)}</code> method.
     *
     * @param obj The <code>Object</code> to be printed
     * @see Object#toString()
     */
    @Override
    public void print(Object obj) {
        super.print(printFunction.apply(obj));
    }

    /**
     * Terminates the current line by writing the line separator string.  The
     * line separator string is defined by the system property
     * <code>line.separator</code>, and is not necessarily a single newline
     * character (<code>'\n'</code>).
     */
    @Override
    public void println() {
        super.println();
    }

    /**
     * Prints a boolean and then terminate the line.  This method behaves as
     * though it invokes <code>{@link #print(boolean)}</code> and then
     * <code>{@link #println()}</code>.
     *
     * @param x The <code>boolean</code> to be printed
     */
    @Override
    public void println(boolean x) {
        super.println(x);
    }

    /**
     * Prints a character and then terminate the line.  This method behaves as
     * though it invokes <code>{@link #print(char)}</code> and then
     * <code>{@link #println()}</code>.
     *
     * @param x The <code>char</code> to be printed.
     */
    @Override
    public void println(char x) {
        super.println(x);
    }

    /**
     * Prints an integer and then terminate the line.  This method behaves as
     * though it invokes <code>{@link #print(int)}</code> and then
     * <code>{@link #println()}</code>.
     *
     * @param x The <code>int</code> to be printed.
     */
    @Override
    public void println(int x) {
        super.println(x);
    }

    /**
     * Prints a long and then terminate the line.  This method behaves as
     * though it invokes <code>{@link #print(long)}</code> and then
     * <code>{@link #println()}</code>.
     *
     * @param x a The <code>long</code> to be printed.
     */
    @Override
    public void println(long x) {
        super.println(x);
    }

    /**
     * Prints a float and then terminate the line.  This method behaves as
     * though it invokes <code>{@link #print(float)}</code> and then
     * <code>{@link #println()}</code>.
     *
     * @param x The <code>float</code> to be printed.
     */
    @Override
    public void println(float x) {
        super.println(x);
    }

    /**
     * Prints a double and then terminate the line.  This method behaves as
     * though it invokes <code>{@link #print(double)}</code> and then
     * <code>{@link #println()}</code>.
     *
     * @param x The <code>double</code> to be printed.
     */
    @Override
    public void println(double x) {
        super.println(x);
    }

    /**
     * Prints an array of characters and then terminate the line.  This method
     * behaves as though it invokes <code>{@link #print(char[])}</code> and
     * then <code>{@link #println()}</code>.
     *
     * @param x an array of chars to print.
     */
    @Override
    public void println(char[] x) {
        super.println(x);
    }

    /**
     * Prints a String and then terminate the line.  This method behaves as
     * though it invokes <code>{@link #print(String)}</code> and then
     * <code>{@link #println()}</code>.
     *
     * @param x The <code>String</code> to be printed.
     */
    @Override
    public void println(String x) {
        super.println(x);
    }

    /**
     * Prints an Object and then terminate the line.  This method calls
     * at first String.valueOf(x) to get the printed object's string value,
     * then behaves as
     * though it invokes <code>{@link #print(String)}</code> and then
     * <code>{@link #println()}</code>.
     *
     * @param x The <code>Object</code> to be printed.
     */
    @Override
    public void println(Object x) {
        super.println(x);
    }

    /**
     * A convenience method to write a formatted string to this output stream
     * using the specified format string and arguments.
     *
     * <p> An invocation of this method of the form <tt>out.printf(format,
     * args)</tt> behaves in exactly the same way as the invocation
     *
     * <pre>
     *     out.format(format, args) </pre>
     *
     * @param format A format string as described in <a
     *               href="../util/Formatter.html#syntax">Format string syntax</a>
     * @param args   Arguments referenced by the format specifiers in the format
     *               string.  If there are more arguments than format specifiers, the
     *               extra arguments are ignored.  The number of arguments is
     *               variable and may be zero.  The maximum number of arguments is
     *               limited by the maximum dimension of a Java array as defined by
     *               <cite>The Java&trade; Virtual Machine Specification</cite>.
     *               The behaviour on a
     *               <tt>null</tt> argument depends on the <a
     *               href="../util/Formatter.html#syntax">conversion</a>.
     * @return This output stream
     * @throws IllegalFormatException If a format string contains an illegal syntax, a format
     *                                specifier that is incompatible with the given arguments,
     *                                insufficient arguments given the format string, or other
     *                                illegal conditions.  For specification of all possible
     *                                formatting errors, see the <a
     *                                href="../util/Formatter.html#detail">Details</a> section of the
     *                                formatter class specification.
     * @throws NullPointerException   If the <tt>format</tt> is <tt>null</tt>
     * @since 1.5
     */
    @Override
    public PrintStream printf(String format, Object... args) {
        return super.printf(printFunction.apply(format), args);
    }

    /**
     * A convenience method to write a formatted string to this output stream
     * using the specified format string and arguments.
     *
     * <p> An invocation of this method of the form <tt>out.printf(l, format,
     * args)</tt> behaves in exactly the same way as the invocation
     *
     * <pre>
     *     out.format(l, format, args) </pre>
     *
     * @param l      The {@linkplain Locale locale} to apply during
     *               formatting.  If <tt>l</tt> is <tt>null</tt> then no localization
     *               is applied.
     * @param format A format string as described in <a
     *               href="../util/Formatter.html#syntax">Format string syntax</a>
     * @param args   Arguments referenced by the format specifiers in the format
     *               string.  If there are more arguments than format specifiers, the
     *               extra arguments are ignored.  The number of arguments is
     *               variable and may be zero.  The maximum number of arguments is
     *               limited by the maximum dimension of a Java array as defined by
     *               <cite>The Java&trade; Virtual Machine Specification</cite>.
     *               The behaviour on a
     *               <tt>null</tt> argument depends on the <a
     *               href="../util/Formatter.html#syntax">conversion</a>.
     * @return This output stream
     * @throws IllegalFormatException If a format string contains an illegal syntax, a format
     *                                specifier that is incompatible with the given arguments,
     *                                insufficient arguments given the format string, or other
     *                                illegal conditions.  For specification of all possible
     *                                formatting errors, see the <a
     *                                href="../util/Formatter.html#detail">Details</a> section of the
     *                                formatter class specification.
     * @throws NullPointerException   If the <tt>format</tt> is <tt>null</tt>
     * @since 1.5
     */
    @Override
    public PrintStream printf(Locale l, String format, Object... args) {
        return super.printf(l, format, args);
    }


    /** character[]转char[] */
    private Character[] charToCharacter(char[] x){
        Character[] re = new Character[x.length];
        for (int i = 0; i < x.length; i++) {
            re[i] = x[i];
        }
        return re;
    }

    /** char[]转character[] */
    private char[] characterToChar(Character[] x){
        char[] re = new char[x.length];
        for (int i = 0; i < x.length; i++) {
            re[i] = x[i];
        }
        return re;
    }

    private String charArrayToStr(char[] s){
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            sb.append(c);
        }
        return sb.toString();
    }


    public void setPrintFunction(Function<Object, String> printFunction) {
        this.printFunction = printFunction;
    }


    public static FortePlusPrintStream getInstance(PrintStream printStream, Function<Object, String> printFunction) throws IllegalAccessException, UnsupportedEncodingException {

        FortePlusPrintStream fortePlusPrintStream = new FortePlusPrintStream(new OutputStream() {
            @Override
            public void write(int b){}
        }, true, "UTF-8");


        //PrintStream的参数
        Field[] declaredFields = PrintStream.class.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object o = field.get(printStream);
            field.set(fortePlusPrintStream, o);
        }

        if(printFunction != null){
            fortePlusPrintStream.setPrintFunction(printFunction);
        }

        return fortePlusPrintStream;
    }


}
