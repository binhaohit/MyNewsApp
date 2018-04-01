# MyNewsApp
just an app for learning

设计框架：
MVP（不太严格，目前没有数据库数据）

应用框架：
（1）网络请求以及异步更新：Retrofit+Rxjava+Json
（2）图片下载：Glide
（3）控件绑定：ButterKnife
（4）显示列表：RecycleView
（5）显示布局控件组合：Toolbar && ViewPager+Fragment+Menu && DrawerLayout+NavigationView

数据源：
http://news-at.zhihu.com/api/4/news/latest  -- 显示最新新闻
http://news-at.zhihu.com/api/4/news/before/{date}  -- 显示更多内容时加载早期新闻
