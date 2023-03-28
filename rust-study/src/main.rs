use std::io;
use std::io::stdin;

fn main() { var_test() }

// 值对象定义
fn var_test() {
    let x = 10;
    let mut muty = 12;
    println!("x:{}", x);
    println!("muty:{}", muty);

    // will error
    // x = 11;
    muty = 13;
}

/**
我们已经在本书中使用过像 println! 这样的宏了，不过还没完全探索什么是宏以及它是如何工作的。
宏（Macro）指的是 Rust 中一系列的功能：使用 macro_rules! 的 声明（Declarative）宏，和三种 过程（Procedural）宏：

自定义 #[derive] 宏在结构体和枚举上指定通过 derive 属性添加的代码
类属性（Attribute-like）宏定义可用于任意项的自定义属性
类函数宏看起来像函数不过作用于作为参数传递的 token
我们会依次讨论每一种宏，不过首要的是，为什么已经有了函数还需要宏呢？
使用 macro_rules! 的声明宏用于通用元编程

 */
fn marco() {}
