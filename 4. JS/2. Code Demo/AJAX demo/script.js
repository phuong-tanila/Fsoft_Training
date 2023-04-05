function getAll() {
  $.ajax({
    url: "https://dummyjson.com/products",
  }).done(function (result) {
    var total = 0;
    result.products.forEach((i) => {
      rederProduct(i);
      total += i.price;
    });
    // for (var i = 0; i < result.products.length; i++) {
    //   rederProduct(result.products[i]);
    //   total += result.products[i].price;
    // }
    const tableTotal = document.querySelector("#totalPrice");
    tableTotal.innerHTML = total;

    function rederProduct(product) {
      const tableBodyElement = document.querySelector("tbody");
      tableBodyElement.innerHTML += ` <tr>
  
                  <td>${product.id}</td>
                  <td>${product.title}</td>
                  <td>${product.description}</td>
                  <td class="price">${product.price}</td>
                  <td>${product.brand}</td>
                  <td>
                    <img src="${product.images[0]}" />
                  </td>
                  <td>
                  <button id="btn-edit" onclick="handleEdit(this)">edit</button>
                  <button id="btn-remove" onclick="handleRemove(this)">remove</button>
                  </td>
                </tr>`;
    }
  });
}
getAll();

function calculatePrice() {
  const price = document.querySelectorAll(".price");
  let total = 0;
  price.forEach((e) => {
    total += parseInt(e.innerHTML);
  });
  const tableTotal = document.querySelector("#totalPrice");
  tableTotal.innerHTML = total;
}

function handleRemove(el) {
  const curentTableDataEls =
    el.parentElement.parentElement.querySelectorAll("td");
  const id = curentTableDataEls[0].innerHTML;
  if (confirm("Do you want to delete?")) {
    el.parentElement.parentElement.remove();
    calculatePrice();
    fetch("https://dummyjson.com/products/" + id, {
      method: "DELETE",
    })
      .then((res) => res.json())
      .then(console.log);
  }
}

function handleSave() {
  const tittleEls = document.querySelector("#tittle");
  const descriptionEls = document.querySelector("#desc");
  const brandEls = document.querySelector("#brand");
  const priceEls = document.querySelector("#price");
  const tittle = tittleEls[0].value;
  const desc = descriptionEls[0].value;
  const price = priceEls[0].value;
  const brand = brandEls[0].value;
  if (checkWrongInput(tittle, desc, brand, price)) {
    alert("Invalid input text or number specified");
    return;
  } else {
    const tableBodyElement = document.querySelector("tbody");
    tableBodyElement.innerHTML =
      ` <tr>
      <td>${product.title}</td>
      <td>${product.description}</td>
      <td>${product.price}</td>
      <td>${product.brand}</td>
      <td>
        <img src="${product.images[0]}" />
      </td>
      <td>
      <button id="btn-edit" onclick="handleEdit(this)">edit</button>
      <button id="btn-remove" onclick="handleRemove(this)">remove</button>
      </td>
      
    </tr>` + tableBodyElement.innerHTML;
  }
}

function checkWrongInput(tittle, desc, brand, price) {
  return (
    tittle === "" ||
    desc === "" ||
    brand === "" ||
    price === "" ||
    parseInt(price) <= 0
  );
}

function handleEdit(el) {
  const curentTableDataEls =
    el.parentElement.parentElement.querySelectorAll("td");
  if (el.innerHTML === "save") {
    const id = curentTableDataEls[0].querySelector("#id").value;
    const tittle = curentTableDataEls[1].querySelector("#tittle").value;
    const desc = curentTableDataEls[2].querySelector("#desc").value;
    const price = curentTableDataEls[3].querySelector("#price").value;
    const brand = curentTableDataEls[4].querySelector("#brand").value;
    if (checkWrongInput(tittle, desc, brand, price)) {
      alert("Invalid input text or number specified");
      return;
    } else {
      curentTableDataEls[0].innerHTML = id;
      curentTableDataEls[1].innerHTML = tittle;
      curentTableDataEls[2].innerHTML = desc;
      curentTableDataEls[3].innerHTML = price;
      curentTableDataEls[4].innerHTML = brand;
      fetch("https://dummyjson.com/products/" + id, {
        method: "PUT" /* or PATCH */,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          title: tittle,
          description: desc,
          price: price,
          brand: brand,
        }),
      })
        .then((res) => res.json())
        .then(console.log);
      el.innerHTML = "edit";
      calculatePrice();
    }
  } else {
    const currentId = curentTableDataEls[0].innerHTML;
    const currentTittle = curentTableDataEls[1].innerHTML;
    const currentDescription = curentTableDataEls[2].innerHTML;
    const currentPrice = curentTableDataEls[3].innerHTML;
    const currentBrand = curentTableDataEls[4].innerHTML;
    curentTableDataEls[0].innerHTML = `<input id="id" type="text" placeholder="Input id" disable value="${currentId}"/>`;
    curentTableDataEls[1].innerHTML = `<input id="tittle" type="text" placeholder="Input title" value="${currentTittle}"/>`;
    curentTableDataEls[2].innerHTML = `<input id="desc" type="text" placeholder="Input description" value="${currentDescription}"/>`;
    curentTableDataEls[3].innerHTML = `<input id="price" type="number" placeholder="Input price" value="${currentPrice}"/>`;
    curentTableDataEls[4].innerHTML = `<input id="brand" type="text" placeholder="Input brand" value="${currentBrand}"/>`;
    el.innerHTML = "save";
  }
}

function handleSubmit() {
  const productEls = document.querySelectorAll("tr");

  var count = 0;
  productEls.forEach((row) => {
    const tdEls = row.querySelectorAll("td");
    if (count != 0 && count != productEls.length - 1) {
      fetch("https://dummyjson.com/products/add", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          id: tdEls[0].innerHTML,
          title: tdEls[1].innerHTML,
          description: tdEls[2].innerHTML,
          price: tdEls[3].innerHTML,
          brand: tdEls[4].innerHTML,
          images: tdEls[5].querySelector("img").getAttribute("src"),
        }),
      })
        .then((res) => res.json())
        .then(console.log);
    }
    count++;
  });
}
