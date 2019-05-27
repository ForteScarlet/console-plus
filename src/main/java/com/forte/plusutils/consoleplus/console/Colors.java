package com.forte.plusutils.consoleplus.console;

import com.forte.plusutils.consoleplus.console.colors.BackGroundColorTypes;
import com.forte.plusutils.consoleplus.console.colors.ColorTypes;
import com.forte.plusutils.consoleplus.console.colors.FontColorTypes;

/**
 * 控制台可以用的颜色
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Colors {

    /** 背景色 */
    public final static BackGroundColorTypes.BackGroundColor BACK_GROUND = BackGroundColorTypes.BackGroundColor.getInstance();
    /** 字体色 */
    public final static FontColorTypes.FontColor FONT = FontColorTypes.FontColor.getInstance();

    /** 颜色字体 */
    private final String COLOR_STR;

    /** 按照顺序的颜色数组 */
    private final ColorTypes[] COLORS;

    /**构造 */
    Colors(String str, ColorTypes[] colors){
        this.COLOR_STR = str;
        this.COLORS = colors;
    }

    /** 获取一个色彩字构建器 */
    public static ColorsBuilder builder(){
        return ColorsBuilder.getInstance();
    }

    public ColorTypes[] getColorTypes(){
        return COLORS;
    }

    /**
     * 重写toString
     */
    @Override
    public String toString(){
        return COLOR_STR;
    }
}
