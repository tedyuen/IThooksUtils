# Android开发工具包 #
![I.T.Hooks icon](http://www.ithooks.com/images/index_logo_img.png)
[上海铁钩信息科技](http://www.ithooks.com)

================

# 目录
*   [使用](#use)
*   [common](#common)
    *   [SharedPreferencesHelper](#SharedPreferencesHelper)
    *   [AppVersionHelper](#AppVersionHelper)



<h2 id="use">使用</h2>
**build.gradle**中添加
```
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

Gradle添加依赖

```gradle
dependencies {
    compile 'com.github.tedyuen:IThooksUtils:0.0.1'
}
```


<h2 id="common">common</h2>

<h3 id="SharedPreferencesHelper">SharedPreferencesHelper</h3>
> SharedPreferences缓存帮助类

```
//Application中注册
SharedPreferencesHelper sph = SharedPreferencesHelper.getInstance();
        sph.Builder(context);
```


<h3 id="AppVersionHelper">AppVersionHelper</h3>
> 获取app版本号和版本名称
```
AppVersionHelper.getVersionName(context);
AppVersionHelper.getVersionCode(context);
```

