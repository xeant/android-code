package com.xeant.viewpagerexam;

public class PageItem {
    private Integer bgColor;
    private Integer imageSrc;
    private String content;

    public PageItem(Integer bgColor, Integer imageSrc, String content) {
        this.bgColor = bgColor;
        this.imageSrc = imageSrc;
        this.content = content;
    }

    @Override
    public String toString() {
        return "PageItem{" +
                "bgColor=" + bgColor +
                ", imageSrc=" + imageSrc +
                ", content=" + content +
                '}';
    }

    public Integer getBgColor() {
        return bgColor;
    }

    public void setBgColor(Integer bgColor) {
        this.bgColor = bgColor;
    }

    public Integer getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(Integer imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

