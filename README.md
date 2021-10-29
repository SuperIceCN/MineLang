# MineLang  
木兰编程语言在JVM上的第三方重置版  

## 项目状态  
项目当前正在处于早期开发阶段，尚不能投入测试或生产。  
当前阶段的主要目标是完成一个能运行的解释器。debugger、标准库暂未投入资源开发。

欢迎各位参与MineLang开发。

## 背景  
### 关于命名
MyMulan => MyUlang => MineUlang => MineLang

更多信息请参阅[MineLang开发背景](docs/背景.md)

## 目标  

本项目的目标是打造一个易于学习与使用的<del>胶水</del>工具语言。

本项目的目标不是完全忠实地实现原木兰语言的全部内容，因原木兰语言一些设计并不是很理想， 
一些设计个人认为并不适合面向无编程基础人群，一些设计在JVM平台上难以实现或效率低下，有必要加以修改。
此外，此项目也会添加一些其他的利于实现项目目标的语言特性。

### 里程碑列表  

优先级越高，星号越少
- 实现原木兰编程语言的大部分内容
  - 实现基本类型
  - 实现函数与自定义类型
  - 实现函数调用
  - 实现模块加载*
- 制作在JVM上运行的解释器
  - 能够正确运行程序
  - 严格而快速的数学运算
  - 达到50%的Python速度*
- 互操作性（胶水性）
  - JVM互操作性、导入jar包
  - Node.js互操作性、导入npm包*
  - Webassembly集成*
  - 本机二进制库调用*
  - Ruby互操作性、导入gem包**
  - Python互操作性、导入pip包**
- 拓展内容
  - 良好的教程及文档
  - 内置并行数据操作方法*
  - trait特征判断*
  - 自动并行与GPU计算加速**
  - AOT编译的解释器*

## 贡献  
此处对贡献的定义即为本项目开源许可证中对贡献的定义。

对本项目源代码、测试套件、编译工具相关脚本及配置文件的贡献，欢迎您通过Pull Request推送到本仓库。
请您遵守开源协议并确保代码中尽可能少出现或不出现bug，请确保您在提交前已经自行进行了测试并充分了解其运作方式和具体细节。
我们希望您使用与已有代码风格一致的方式进行编写。

目前，对本项目官方文档、教程、wiki等的贡献请联系仓库所有者或管理员。

非官方的文档、 教程、代码库等请按照对应项目的规则进行或联系对应项目的负责人。

## 声明  
1. 本项目与中科院（中国科学院）、中国科学院计算技术研究所、刘雷、中科智芯没有任何直接或间接关联。
2. 本项目未使用原木兰编程语言的任何代码，仅参考了其设计。
3. 任何关于本项目的活动请确保不违反[木兰公共许可证第二版](LICENSE)。
4. 本项目不提供任何形式的保证，仅作个人学习娱乐用途。