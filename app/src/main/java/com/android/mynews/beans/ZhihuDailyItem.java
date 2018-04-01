package com.android.mynews.beans;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28.
 */

public class ZhihuDailyItem {
    /**
     * images : ["https://pic1.zhimg.com/v2-5a4fc8987550eab04248145b3df89394.jpg"]
     * type : 0
     * id : 9674380
     * ga_prefix : 032416
     * title : 整个人都「吓傻」是种怎样的体验？
     * multipic : true
     */

    private int type;
    private int id;
    private String ga_prefix;
    private String title;
    private boolean multipic;
    private List<String> images;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMultipic() {
        return multipic;
    }

    public void setMultipic(boolean multipic) {
        this.multipic = multipic;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
