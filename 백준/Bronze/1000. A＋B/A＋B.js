const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
let input = require("fs").readFileSync(filePath).toString().trim().split("\n")
    
let [A, B] = input[0].split(" ").map(Number) // 공백으로 구분해 입력받기

console.log(A+B)