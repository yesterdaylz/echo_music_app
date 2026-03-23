<p align="center">
  <img src="./app/src/main/ic_echo-playstore.png" width="120"/>
</p>

<h1 align="center">Echo Music App</h1>

# 简介

一个基于 Kotlin 的 Android 原生音乐应用目，主要用于个人学习、侧重于功能实现，仅供参考。

---

# 主要功能

## 已完成

- 支持本地音乐播放
- 支持网络音乐播放(由于接口问题目 ~~其实是我没看懂文档~~ 前大部分歌曲只有前奏或高潮部分)
- 网络音乐搜索，历史搜索记录
- 每日推荐、排行榜
- 接入deepseek聊天，支持创建、删除、置顶、命名会话（apikey需要自己官网申请）
- 音乐历史播放记录
- 收藏音乐
- 播放界面，基本播放与媒体控制功能：顺序播放，单曲循环，随机播放
- 迷你播放器
- 定时停止播放
- 动态域名设置
- 深色模式

## 待完成

- [ ] 重构
- [ ] 搜索记录单个删除
- [ ] 多用户
- [ ] 多语言
- [ ] 处理接口问题
- [ ] 深度思考（迟早换成火山模型🙂）
- [ ] 分类页面
- [ ] 美化ui

---

# 项目相关

## 开发语言

- kotlin 2.2.21

---

## 开发环境

- JDK: 17
- compileSdk: 36
- targetSdk:36
- minSdk:24

---

## Android相关

- Gradle  9.3.1
- AGP  9.1.0
- Jetpack (Lifecycle/Navigation/DataStore / Room)
- Retrofit/OkHttp
- Moshi
- Media3
- Glide
- Markwon
- ViewPager2
- ...

---

## 接口仓库地址

项目使用的 API 来源：[KuGouMusicApi](https://github.com/MakcRe/KuGouMusicApi)，感谢大佬💐🐿️

---

~~什么？你问为什么只有一点代码，因为最近心情不好把.git删了（有空慢慢提交吧）~~



