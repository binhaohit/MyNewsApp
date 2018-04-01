package com.android.mynews.beans;

import java.util.List;

/**
 * Created by Administrator on 2018/3/24.
 */

public class ZhihuBean {
    /**
     * date : 20180324
     * stories : [{"images":["https://pic1.zhimg.com/v2-5a4fc8987550eab04248145b3df89394.jpg"],"type":0,"id":9674380,"ga_prefix":"032416","title":"整个人都「吓傻」是种怎样的体验？"},{"title":"大学举行宿舍装扮大赛，终于能名正言顺地装扮又破又小的宿舍了","ga_prefix":"032415","images":["https://pic1.zhimg.com/v2-187140759c1df893e335f4813d390d88.jpg"],"multipic":true,"type":0,"id":9675683},{"images":["https://pic3.zhimg.com/v2-5bfd028c610f4d605a21c82fa611d4a6.jpg"],"type":0,"id":9674464,"ga_prefix":"032415","title":"共享单车一直不给我退押金，能不能告它集资诈骗？"},{"images":["https://pic4.zhimg.com/v2-d07cead0c4d3e0fdb258873bd9e16be7.jpg"],"type":0,"id":9674768,"ga_prefix":"032413","title":"做比特币矿工的这一年，我觉得自己根本连矿工都算不上"},{"images":["https://pic3.zhimg.com/v2-b87d9cf30a5b962571bdd09a2f0e6066.jpg"],"type":0,"id":9675579,"ga_prefix":"032412","title":"大误 · 你从来没听懂过《痒》"},{"images":["https://pic1.zhimg.com/v2-c75efa58d74d7a2444ec0dfab90d415c.jpg"],"type":0,"id":9675640,"ga_prefix":"032412","title":"征收报复性关税，中美「贸易战」已经开始了？"},{"images":["https://pic3.zhimg.com/v2-55ad1e8bb823b5fabf4d68035b6c5d36.jpg"],"type":0,"id":9674927,"ga_prefix":"032410","title":"那些没干到 40 岁的程序员，后来都怎么样了？"},{"images":["https://pic2.zhimg.com/v2-05e8899e7db503133f485ac0b570cc5d.jpg"],"type":0,"id":9675305,"ga_prefix":"032409","title":"如何在吵架上赢过你的律师朋友"},{"images":["https://pic4.zhimg.com/v2-cc9d9a8803264a6d57b4661ff59e533f.jpg"],"type":0,"id":9673399,"ga_prefix":"032408","title":"老觉得时间不够用？你的问题其实没出在「时间管理」上"},{"title":"刘爸刘妈的日常 · 儿子常联系呀！","ga_prefix":"032408","images":["https://pic4.zhimg.com/v2-e72a4927075007f39ab588e1cb79b787.jpg"],"multipic":true,"type":0,"id":9675645},{"title":"新手养花最容易犯哪些错误？","ga_prefix":"032407","images":["https://pic1.zhimg.com/v2-e522862aaec1fffc92da0bcae514452c.jpg"],"multipic":true,"type":0,"id":9675296},{"images":["https://pic1.zhimg.com/v2-f05ac479b6335d46eb5fca233713f274.jpg"],"type":0,"id":9674947,"ga_prefix":"032407","title":"「谁说我们科研狗就得忍受清贫的生活了？」"},{"images":["https://pic3.zhimg.com/v2-c0ca920e8f24278854366aa8ffca591e.jpg"],"type":0,"id":9675517,"ga_prefix":"032406","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-9120de463fb7d64ba10852da4700dd30.jpg","type":0,"id":9675645,"ga_prefix":"032408","title":"刘爸刘妈的日常 · 儿子常联系呀！"},{"image":"https://pic1.zhimg.com/v2-fe76b0a6941a2a9e9a3a073a95658100.jpg","type":0,"id":9675305,"ga_prefix":"032409","title":"如何在吵架上赢过你的律师朋友"},{"image":"https://pic4.zhimg.com/v2-c4aa23e65615f0c778e86c942327287f.jpg","type":0,"id":9675296,"ga_prefix":"032407","title":"新手养花最容易犯哪些错误？"},{"image":"https://pic1.zhimg.com/v2-8b1ecfafeedc969130a4f8d6cd523c98.jpg","type":0,"id":9674947,"ga_prefix":"032407","title":"「谁说我们科研狗就得忍受清贫的生活了？」"},{"image":"https://pic1.zhimg.com/v2-7f8fcaaa4266b1a77b2ec91bfb035a28.jpg","type":0,"id":9675640,"ga_prefix":"032412","title":"征收报复性关税，中美「贸易战」已经开始了？"}]
     */

    private String date;
    private List<ZhihuDailyItem> stories;
    private List<ZhihuDailyItem> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ZhihuDailyItem> getStories() {
        return stories;
    }

    public void setStories(List<ZhihuDailyItem> stories) {
        this.stories = stories;
    }

    public List<ZhihuDailyItem> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<ZhihuDailyItem> top_stories) {
        this.top_stories = top_stories;
    }

//    public static class StoriesBean {
//        /**
//         * images : ["https://pic1.zhimg.com/v2-5a4fc8987550eab04248145b3df89394.jpg"]
//         * type : 0
//         * id : 9674380
//         * ga_prefix : 032416
//         * title : 整个人都「吓傻」是种怎样的体验？
//         * multipic : true
//         */
//
//        private int type;
//        private int id;
//        private String ga_prefix;
//        private String title;
//        private boolean multipic;
//        private List<String> images;
//
//        public int getType() {
//            return type;
//        }
//
//        public void setType(int type) {
//            this.type = type;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getGa_prefix() {
//            return ga_prefix;
//        }
//
//        public void setGa_prefix(String ga_prefix) {
//            this.ga_prefix = ga_prefix;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public boolean isMultipic() {
//            return multipic;
//        }
//
//        public void setMultipic(boolean multipic) {
//            this.multipic = multipic;
//        }
//
//        public List<String> getImages() {
//            return images;
//        }
//
//        public void setImages(List<String> images) {
//            this.images = images;
//        }
//    }
//
//    public static class TopStoriesBean {
//        /**
//         * image : https://pic1.zhimg.com/v2-9120de463fb7d64ba10852da4700dd30.jpg
//         * type : 0
//         * id : 9675645
//         * ga_prefix : 032408
//         * title : 刘爸刘妈的日常 · 儿子常联系呀！
//         */
//
//        private String image;
//        private int type;
//        private int id;
//        private String ga_prefix;
//        private String title;
//
//        public String getImage() {
//            return image;
//        }
//
//        public void setImage(String image) {
//            this.image = image;
//        }
//
//        public int getType() {
//            return type;
//        }
//
//        public void setType(int type) {
//            this.type = type;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getGa_prefix() {
//            return ga_prefix;
//        }
//
//        public void setGa_prefix(String ga_prefix) {
//            this.ga_prefix = ga_prefix;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//    }
}
