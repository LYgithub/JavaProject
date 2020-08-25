package com.kawyang;

/**
 * @author LiYang
 * @Project Name: Spring-Ioc-Printer
 * @Package Name: com.kawyang.impl
 * Created by MacBook Air on 2020/08/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class TextPaper implements Paper {
    private String context = "  ";
    private int charPerLine = 16,
    linePerPage = 5,
    posX = 0,
    posY = 0,
    posP = 1;

    public void putIntChar(char c) {
        context += c;
        ++posX;
        char line = '\n';
        if ( c == line){
            context += Paper.newLine + "  ";
            posX = 0;
            posY ++;
        }

        if(posY == linePerPage){
            context += "===  第" + this.posP + "页  ===";
            context += "\r\n---------------------\r\n";
            posX = 0;
            posP++;
            posY = 0;

        }

        if( posX == charPerLine){
            context += Paper.newLine;
            posX = 0;
            ++posY;
        }

        if(posY == linePerPage){
            context += "===  第" + this.posP + "页  ===";
            context += "\r\n---------------------\r\n";
            posX = 0;
            posP++;
            posY = 0;
        }
    }

    public String getContext() {
        String ret = this.context;

        // 补充每页空行
        if( !(posX == 0 && posY==0)){
            int count = linePerPage - posY;
            for (int i = 0; i < count; i++) {
                ret += Paper.newLine;
            }

            ret += "===  第" + this.posP + "页  ===";
        }
        return ret;
    }

    public int getCharPerLine() {
        return charPerLine;
    }

    public void setCharPerLine(int charPerLine) {
        this.charPerLine = charPerLine;
    }

    public int getLinePerPage() {
        return linePerPage;
    }

    public void setLinePerPage(int linePerPage) {
        this.linePerPage = linePerPage;
    }
}
