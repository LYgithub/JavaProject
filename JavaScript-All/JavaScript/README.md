## JavaScript





### 函数

#### 内嵌函数
```javascript
function method() {
   let count = 0;
   function inner() {
     count += 1;
   }
   inner();
   return count;
}
```

> 每次函数调用，都会重新初始化 count 不能够实现计数功能能。

#### 闭包函数
```javascript
var add = (function method() {
  let count = 0;
  return function() {
    return count+= 1;
  }
})();

function click_btn() {
  document.getElementById("span").innerHTML = add();
}
```
> 闭包函数
> 自调函数只执行一次，并且是在加载的时候调用。
> 自调函数返回值为 一个方法，通过 `add()` 可以调用返回的方法，通过 