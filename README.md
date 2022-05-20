# README

### 使用前说明

+ 导入项目前请先配置、启动nacos
+ 导入项目前请先创建数据库[learninglibrary]，sql脚本在项目根目录
+ 我的邮箱cy.arctique@gmail.com

### 版本说明

```text
java : 1.8.0_201
spring-cloud.version : Hoxton.SR3
spring-boot-starter-parent.version : 2.2.5.RELEASE
dubbo.version : 2.7.3
nacos-client.version : 1.1.1
swagger.version : 2.9.2
```
具体其它详细版本请参照dependencies

### 项目模块
```text
|_parent                                    root
|___|___business                            消费者
|_________|_________business-index          首页消费者
|_________|_________business-oauth2         用户认证授权
|_________|_________business-share          分享消费者
|___|___common                              公共模块
|_________|_________common-config           配置
|_________|_________common-util             工具类
|___|___dependencies                        依赖版本管理
|___|___gateway                             网关配置
|___|___provider                            服务提供者
|_________|_________share-provider-api      分享服务提供者
|_________|_________share-provider-service  分享服务提供者
|_________|_________user-provider-api       用户服务提供者
|_________|_________user-provider-service   用户服务提供者
```

### 项目启动

+ ~~模块启动顺序~~
  + ~~服务提供者~~
    + ~~ShareProviderApplication~~
    + ~~UserProviderApplication~~
  + ~~服务消费者~~
    + ~~BusinessIndexApplication~~
    + ~~BusinessOauth2Application~~
    + ~~BusinessShareApplication~~
  + ~~网关~~
    + ~~GatewayApplication~~

+ 配置dubbo关闭consumer自动检测provider
```yml
dubbo:
  consumer:
    check: false
```
**启动顺序可任意**

### Swagger 访问模块接口

+ http://localhost:9999/doc.html

+ 认证

  + 通过/user/login 接口进行登录，获取access_token

    + 通过访问网关：http://localhost:9999/business-oauth2/user/login

  + 设置 `Authorization` 的 value，格式：bearer [空格] <access_token>，例如：

    ```text
    bearer 9ead55fb-138f-4e3e-b2ac-288c35ee8fa7
    ```


### IDEA RunDashboard 组件（旧版本组件，新版本Services组件功能类似）

导入项目，加载出.idea配置文件，目标：workspace.xml

+ 添加如下配置：

```xml
<component name="RunDashboard">
    <option name="configurationTypes">
      <set>
        <option value="SpringBootApplicationConfigurationType" />
      </set>
    </option>
    <option name="ruleStates">
      <list>
        <RuleState>
          <option name="name" value="ConfigurationTypeDashboardGroupingRule" />
        </RuleState>
        <RuleState>
          <option name="name" value="StatusDashboardGroupingRule" />
        </RuleState>
      </list>
    </option>
</component>
```
*重启idea即可生效*

---
### 日志
*20200204*
+ 修改配置文件，关闭consumer自动检测provider
+ 对应修改readme相关说明

*20200205*
+ 自定义security认证Exception Response
```json
{
  "code": 4700,
  "data": "",
  "msg": "无效token"
}
```
详细请参照AuthExceptionEntryPoint、CustomAccessDeniedHandler
