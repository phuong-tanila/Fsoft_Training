var btnCheck = document.getElementById("btnCheck");
btnCheck.onclick = () => {
  var value = document.getElementById("inputNumber").value;
  if (value % 2 == 0) {
    result = value + " là số chẵn";
  } else {
    result = value + " là số lẻ";
  }
  document.getElementById("alert").innerHTML = result;
};

let newAlert = document.createElement("div");
newAlert.classList.add("alert");

var btnCheckNum = document.getElementById("btnCheckNum");
btnCheckNum.onclick = () => {
  var value = document.getElementById("inputNumber").value;
  var num = [2, 3, 5, 9];
  var rs = [];
  for (let i = 0; i < num.length; i++) {
    if (value % num[i] == 0) {
      rs.push(num[i]);
    }
  }
  if (rs.length == 0) {
    msg = value + " không chia hết cho số 2, 3, 5, 9";
    newAlert.classList.add("alert-success");
  } else {
    msg = `${value} chia hết ${rs.join(",")}`;
    newAlert.classList.add("alert-danger");
  }
  newAlert.innerHTML = msg;
  document.querySelector(".notification").classList.remove("d-none");
  document.querySelector(".notification").appendChild(newAlert);
  setTimeout(() => {
    newAlert.remove();
  }, 3000);
};
