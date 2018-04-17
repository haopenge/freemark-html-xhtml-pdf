<html>
<head>
    <title>Welcome FreeMarker!</title>
    <meta charset="utf-8"></meta>
    <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
    <meta http-equiv="x-ua-compatible" content="ie=edge"></meta>
    <link rel="icon" href="https://static.jianshukeji.com/hcode/images/favicon.ico"></link>
    <script src="https://img.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
    <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
</head>
<body>

<#-- 单个属性 替换   -->
<h1>Welcome  ${name}</h1>


<img src="${imgUrl}"
     class="shrinkToFit" height="474" width="266"/>

<#-- list 属性替换 -->
<table border="1">
		<#list students as student>
            <tr>
                <td>${student.name} </td>
                <td>${student.id}</td>
            </tr>
        </#list>
</table>

<#--常用指令-->

<#--1. 赋值   =左边是要赋值的变量 ， = 右边是从map 中传递值，在freemarker 标签中可以直接调用变量名获取后台传递的值，不需要+${}  -->
<#assign showDate = showDate/>


<#--2. 判断 -->
<#if showDate == true> 现在时间是：${date?string('yyyy-MM-dd')}

<#else>就不给你显示，来一百块
</#if>


<#-- 3. 处理未定义变量或值为null ，当定义的变量为空或者未定义，默认情况下  -->

<#-- 3.1 设置默认值  防止未输入字段，空指针异常-->
<h1> 葫芦玩总共有几个 ？答： ${number !8} </h1>

<h1> 小明的车是神马牌子 ？ 答：${(student.car.sign) !'宝马741'} </h1>


<#-- 3.2 加if 判断-->
<#if weather??> Hi,${weather}
<#else> 今天天气信息没有获取到,你就看做是晴天吧，反正也没下雨
</#if>
<#if (user.car.sign)? exists>Hi,${user} </#if>

<#-- 3.3 修改全局配置 -->
<#setting classic_compatible=true>
<h1> 小洋人的价钱是： ${price} 元 </h1>


<#-- 4. 格式化输出-->

<#-- 转成字符串显示 -->
${12.6?c} <br/>
<#-- 按数字显示 -->
${ 123456 ?string.number} <br/>
<#-- 按贷币格式显示 -->
${123456 ?string.currency} <br/>
<#-- 按百分比格式显示 -->
${1.12 ?string.percent} <br/>

<#--去空格 -->
${description ?trim} <br/>

<#-- 格式化日期-->
${date?string("yyyy-MM-dd HH:mm:ss")} <br/>
${date?string("yyyyMMdd")} <br>


<#-- 5. 插入其他模块 -->
<#--<#include "/mime.ftl">-->


</body>
</html>