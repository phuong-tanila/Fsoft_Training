var myData = "Phuong, Anh, Binh, Cuong, Dung";

console.log(myData);

var arr = myData.split(",");
console.log(arr);

console.log(arr[0]);

console.log(arr[arr.length - 1]);

arr.length -= 1; //remove last element in array
console.log(arr);
console.log(arr.join("/"));

// var number = [1, 2, 3, 4, 5, 6, 6, 7];
// number.forEach((i) => {
//   if (i % 2 == 0) {
//     console.log(i + " là số chẵn");
//   } else
//     console.log(i + " là số lẻ");
//   }
// });

// var num = [2, 3, 6, 9, 12, 8, 45, 90];
// var num2 = [2, 3, 5, 9];
// for (let i = 0; i < num.length; i++) {
//   var result = [];
//   for (let j = 0; j < num2.length; j++) {
//     if (num[i] % num2[j]) {
//       result.push(num[i]);
//     }
//   }
// }

function a(n) {
  let i = 0;
  while (n > 0) {
    i = i * 10 + (n % 10);
    n = parseInt(n / 10);
  }
  return i;
}
console.log(a(1234));

let b = (n) => {
  let i = 0;
  while (n > 0) {
    i = i * 10 + (n % 10);
    n = parseInt(n / 10);
  }
  return i;
};
console.log(b(24681357));
