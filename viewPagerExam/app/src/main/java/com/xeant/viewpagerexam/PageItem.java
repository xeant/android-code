package com.xeant.viewpagerexam.dummy;

public class PageItem {
    private Integer bgColor;
    private Integer imageSrc;
    private Integer content;
    
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

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }
}

