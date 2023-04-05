function handleSave() {
  const nameEls = document.querySelectorAll("input[type=text]");
  const ageEls = document.querySelectorAll("input[type=number]");
  const name = nameEls[0].value;
  const age = ageEls[0].value;
  if (checkWrongInput(name, age)) {
    alert("Invalid name or age specified");
    return;
  } else {
    const tableBodyElement = document.querySelector("tbody");
    tableBodyElement.innerHTML =
      ` <tr>
                <td>${name}</td>
                <td class="age">${age}</td>
                <td>
                <button id="btn-edit" onclick="handleEdit(this)">edit</button>
                <button id="btn-remove" onclick="handleRemove(this)">remove</button>
                </td>
            </tr>` + tableBodyElement.innerHTML;
    nameEls[0].value = "";
    ageEls[0].value = "";
    renderAvgAge();
  }
}

function checkWrongInput(name, age) {
  return name === "" || age === "" || parseInt(age) <= 0;
}

function renderAvgAge() {
  let total = 0;
  const ageElments = document.querySelectorAll(".age");

  ageElments.forEach((i) => {
    total += parseInt(i.innerHTML);
  });
  document.querySelector(".avg-age").innerHTML =
    ageElments.length === 0 ? 0 : total / ageElments.length;
}

function handleRemove(el) {
  if (confirm("Do you want to delete?")) {
    el.parentElement.parentElement.remove();
    renderAvgAge();
  }
}

function handleEdit(el) {
  const curentTableDataEls =
    el.parentElement.parentElement.querySelectorAll("td");
  if (el.innerHTML === "save") {
    const name = curentTableDataEls[0].querySelector("input[type=text]").value;
    const age = curentTableDataEls[1].querySelector("input[type=number]").value;
    if (checkWrongInput(name, age)) {
      alert("Invalid name or age specified");
      return;
    } else {
      curentTableDataEls[0].innerHTML = name;
      curentTableDataEls[1].innerHTML = age;
      el.innerHTML = "edit";
      renderAvgAge();
    }
  } else {
    const currentName = curentTableDataEls[0].innerHTML;
    const currentAge = curentTableDataEls[1].innerHTML;
    curentTableDataEls[0].innerHTML = `<input type="text" placeholder="Input name" value="${currentName}"/>`;
    curentTableDataEls[1].innerHTML = `<input type="number" placeholder="Input age" value="${currentAge}"/></td>`;
    el.innerHTML = "save";
  }
}
