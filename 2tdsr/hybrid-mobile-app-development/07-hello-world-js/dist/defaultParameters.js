"use strict";

function soma(a) {
  var b = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 0;

  return a + b;
}

console.log(soma(10));
console.log(soma(10, 2));