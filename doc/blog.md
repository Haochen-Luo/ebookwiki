
## 2022/2/9 

### 输入test/list的逻辑

入口在TestController,/test/list对应的方法返回的是testService.list()

而testService.list()方法会调用TestMapper的list()方法

TestMapper再去找对应的xml

### 修改mybatis-generator的配置文件generator.xml

修改连接还有domain mapper的targetPackage所在位置

## 2022/2/10

### 用Mybatis generator生成的demoMapper的selectByExample
demoMapper.selectByExample(null);类似于 where. null 意味着select all

### 快捷键
Ctrl+Alt+v

### EbookExample.Criteria 类似于 where