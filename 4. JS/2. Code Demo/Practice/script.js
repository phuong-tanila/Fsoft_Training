console.log("Đây là thông báo");
const a = 1;
const b = 2;

function sum(a, b) {
  return a + b;
}
console.log(sum(1, 3));

var arr = [40, 100, 1, 5, 25, 10];

function sortAscending() {
  for (let i = 0; i < arr.length - 1; i++) {
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[i] > arr[j]) {
        let temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
  }
  return arr;
}

console.log(sortAscending());
