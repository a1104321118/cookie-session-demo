/**
 * 详解 cookie 和 session
 * http://blog.csdn.net/fangaoxin/article/details/6952954/
 *
 * cookie：
 * 属性名              描述
 *
 * String name        该Cookie的名称。Cookie一旦创建，名称便不可更改
 * Object value       该Cookie的值。如果值为Unicode字符，需要为字符编码。如果值为二进制数据，则需要使用BASE64编码
 * int maxAge         该Cookie失效的时间，单位秒。如果为正数，则该Cookie在maxAge秒之后失效。如果为负数，该Cookie为临时Cookie，关闭浏览器即失效，浏览器也不会以任何形式保存该Cookie。如果为0，表示删除该Cookie。默认为–1
 * boolean secure     该Cookie是否仅被使用安全协议传输。安全协议。安全协议有HTTPS，SSL等，在网络上传输数据之前先将数据加密。默认为false
 * String path        该Cookie的使用路径。如果设置为“/sessionWeb/”，则只有contextPath为“/sessionWeb”的程序可以访问该Cookie。如果设置为“/”，则本域名下contextPath都可以访问该Cookie。注意最后一个字符必须为“/”
 * String domain      可以访问该Cookie的域名。如果设置为“.google.com”，则所有以“google.com”结尾的域名都可以访问该Cookie。注意第一个字符必须为“.”
 * String comment     该Cookie的用处说明。浏览器显示Cookie信息的时候显示该说明
 * int version        该Cookie使用的版本号。0表示遵循Netscape的Cookie规范，1表示遵循W3C的RFC 2109规范
 *
 * Session中包括各种方法，使用起来要比Cookie方便得多。Session的常用方法如表1.2所示。
 * 方法名       描述
 * void setAttribute(String attribute, Object value)  设置Session属性。value参数可以为任何Java Object。通常为java Bean。value信息不宜过大
 * String getAttribute(String attribute)  返回Session属性
 * Enumeration getAttributeNames()  返回Session中存在的属性名
 * void removeAttribute(String attribute)  移除Session属性
 * String getId()  返回Session的ID。该ID由服务器自动创建，不会重复
 * long getCreationTime()  返回Session的创建日期。返回类型为long，常被转化为Date类型，例如：Date createTime = new Date(session.get CreationTime())
 * long getLastAccessedTime()  返回Session的最后活跃时间。返回类型为long
 * int getMaxInactiveInterval()  返回Session的超时时间。单位为秒。超过该时间没有访问，服务器认为该Session失效
 * void setMaxInactiveInterval(int second)  设置Session的超时时间。单位为秒
 * boolean isNew()  返回该Session是否是新创建的
 * void invalidate()  使该Session失效

 *Tomcat中Session的默认超时时间为20分钟。通过setMaxInactiveInterval(int seconds)修改超时时间。
 *可以修改web.xml改变Session的默认超时时间。例如修改为60分钟：

 *<session-config>
 *   <session-timeout>60</session-timeout>      <!-- 单位：分钟 -->
 * </session-config>
 * 注意：<session-timeout>参数的单位为分钟，而setMaxInactiveInterval(int s)单位为秒
 *
 *
 *
 *
 * Created by Administrator on 2017/6/12 0012.
 */
package com.hr;

