2021/10/17

+ ~~框架搭建~~
+ ~~数据库搭建~~
+ ~~基础页面~~
    + index.jsp
    + 404.jsp
+ ~~插入user表数据~~

+ 开发小结
    + 今天框架搭的概算顺利 就是又出现了controller 404报错 很烦啊 上次也遇到了忘记上次是怎么解决的了操

---

2021/10/18

+ ~~解决controller报错~~
+ ~~登陆页面~~
+ ~~mybatis适配~~
+ ~~interceptor权限拦截器~~

+ 开发小结
  + bug终于解决了 但不是我解决的 是他自己消失的
  + ~~不想用mybatis了 这么轻量级的平台 用屁mybatis~~
  + return ModelAndView 不可以用redirect哦
  + 找到问题所在了 在mapper生成错误导致一连串的报错
    + 解决方法 加载mapper映射 配置sessionFactory

---

2021/10/19

+ ~~页面拦截器~~
+ ~~查询所有用户~~
  + ~~权限检测~~
+ 用户的CRUD
  + ~~权限检测~~
  + ~~增~~
    + ~~必要元素检查~~
  + ~~删~~
  + ~~查~~
  + ~~改~~
    + ~~必要元素检查~~
+ ~~美化index页面~~
+ 开发小结
  + 总体挺顺利就好像jquery在jsp页面用有点奇怪的bug
  + input标签没有内容判断用！！！比较好
  + 会出现图片或者js文件加载报错302检查后发现是拦截器拦截掉了

---

2021/10/20

+ ~~用户的CRUD~~
  + ~~改~~
+ ~~非管理员改密码~~
+ ~~展示所有equipment~~
+ 设备的CRUD
  + ~~增~~
    + ~~必要元素检查~~
  + ~~删~~
  + ~~查~~
  + ~~改~~
    + ~~必要元素检查~~
+ 开发小结
  + 在查询时取出的List集合判断时好像无法判断为空所以另加了一个函数用来判断存在
  + 新学的mysql语句 LIMIT number 可以选获取哪一条数据 MAX/MIN(列名) 获取某一列最大最小值
  + 明天暂停一天 看看论文

---

2021/10/22

+ ~~借取设备~~
+ ~~归还设备~~
  + ~~只可以归还自己的设备~~
+ 开发小结
  + 记得给form标签内的select标签取名字不然不传值哦
  + mybatis抽风了参数传递失误 使用@Param强制绑定解决了
  + 不要给mysql列名设置为return 会报错

---

2021/10/25

+ ~~上云~~
+ ~~退出登录功能~~
+ 开发小结
  + 上云注意各个版本的兼容性
  + tomcat报错看log读原因
  + 版本尤其注意dependency版本