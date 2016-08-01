# Android开发工具包 #
![I.T.Hooks icon](http://www.ithooks.com/images/index_logo_img.png)
> [上海铁钩信息科技](http://www.ithooks.com)

================

# 目录
*   [使用](#use)
*   [common包](#common)
    *   [SharedPreferences缓存管理](#SharedPreferencesHelper)
    *   [应用版本获取](#AppVersionHelper)
    *   [屏幕分辨率相关](#UiHelper)
    *   [字符串处理工具](#StringUtils)
    *   [网络环境判断](#AppNetworkInfo)
    *   [MD5加密](#MD5)
    *   [时间操作](#DateUtil)



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

<h3 id="UiHelper">UiHelper</h3>
> 屏幕分辨率转化、宽高数值获取


<h3 id="StringUtils">StringUtils</h3>
> 字符串处理工具

```
StringUtils.isEmpty(str);
```

<h3 id="AppNetworkInfo">AppNetworkInfo</h3>
> 网络环境 & GPS判断 & 检查手机上是否安装了指定的软件


<h3 id="MD5">MD5</h3>
> MD5加密

```
//替换default key
MD5.KEY = newKey;
//加密字符串
MD5.getMD5KeyStr(str);
```


<h3 id="DateUtil">DateUtil</h3>
> 时间操作转换类





