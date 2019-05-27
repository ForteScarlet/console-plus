package com.forte.utils.consoleplus.console.colors;

/**
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public interface ColorTypes {

    int getColorIndex();

    default boolean isBackGround(){
        return this instanceof BackGroundColorTypes;
    }

    default boolean isFont(){
        return this instanceof FontColorTypes;
    }

}
