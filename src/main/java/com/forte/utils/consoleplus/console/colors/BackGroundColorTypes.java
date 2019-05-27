package com.forte.utils.consoleplus.console.colors;

/**
 * 背景颜色
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public enum BackGroundColorTypes implements ColorTypes {
    //背景：40:黑 41:深红 42:绿 43:黄色 44:蓝色 45:紫色 46:深绿 47:白色。
    /** 黑 */
    BLACK(40, "\u001b[40mBLACK\u001b[0m"),
    /** 深红 */
    DARK_RED(41, "\u001b[41mDARK_RED\u001b[0m"),
    /** 绿 */
    GREEN(42, "\u001b[42mGREEN\u001b[0m"),
    /** 黄色 */
    YELLOW(43, "\u001b[43mYELLOW\u001b[0m"),
    /** 蓝色 */
    BLUE(44, "\u001b[44mBLUE\u001b[0m"),
    /** 紫色 */
    PURPLE(45, "\u001b[45mPURPLE\u001b[0m"),
    /** 深绿 */
    DARK_GREEN(46, "\u001b[46mDARK_GREEN\u001b[0m"),
    /** 白色 */
    WHITE(47, "\u001b[47mWHITE\u001b[0m"),
    ;

    /** 颜色代码 */
    private final int colorIndex;

    private final String toString;

    /**
     * 构造
     */
    BackGroundColorTypes(int colorIndex, String toString){
        this.colorIndex = colorIndex;
        this.toString = toString;
    }


    /**获取颜色代码 */
    @Override
    public int getColorIndex(){
        return this.colorIndex;
    }

    /** 通过颜色代码获取字体颜色枚举 */
    public static BackGroundColorTypes getColor(int index){
        for(BackGroundColorTypes c : values()){
            if(c.colorIndex == index){
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return toString;
    }

    /** 颜色静态常量类 */
    public static class BackGroundColor{
        public final BackGroundColorTypes BLACK         = BackGroundColorTypes.BLACK;
        public final BackGroundColorTypes DARK_RED      = BackGroundColorTypes.DARK_RED;
        public final BackGroundColorTypes GREEN         = BackGroundColorTypes.GREEN;
        public final BackGroundColorTypes YELLOW        = BackGroundColorTypes.YELLOW;
        public final BackGroundColorTypes BLUE          = BackGroundColorTypes.BLUE;
        public final BackGroundColorTypes PURPLE        = BackGroundColorTypes.PURPLE;
        public final BackGroundColorTypes DARK_GREEN    = BackGroundColorTypes.DARK_GREEN;
        public final BackGroundColorTypes WHITE         = BackGroundColorTypes.WHITE;
        private static final BackGroundColor SINGLE     = new BackGroundColor();
        public static BackGroundColor getInstance(){
            return SINGLE;
        }
    }

}
