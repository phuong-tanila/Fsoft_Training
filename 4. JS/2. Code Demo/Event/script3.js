function changeColor(a) {
  a.target.style.backgroundColor = "yellow";
  a.target.nextElementSibling.style.backgroundColor = "red";
}
document.getElementById("btnCheck").addEventListener("click", changeColor);

function changeText(b) {
  b.target.value = "Hello ku!!!";
  b.target.previousElementSibling.value = "Ahihi";
  b.target.style.backgroundColor = "yellow";
  b.target.previousElementSibling.style.backgroundColor = "red";
  b.target.style.color = "white";
  b.target.previousElementSibling.style.color = "white";
}
document.getElementById("btnCheckNum").addEventListener("click", changeText);
