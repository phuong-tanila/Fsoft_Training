var products = [
  {
    id: 1,
    image: "image/camera.png",
    name: "MASSA AST",
    color: "black",
    material: "metal",
    price: 120.0,
    discount: 25.0,
    quantity: 1,
  },
  {
    id: 2,
    image: "image/SD_Extreme.jpg",
    name: "MASSA AST",
    color: "black",
    material: "metal",
    price: 7.0,
    discount: 0.0,
    quantity: 1,
  },
  {
    id: 3,
    image: "image/sony.jpg",
    name: "MASSA AST",
    color: "black",
    material: "metal",
    price: 120.0,
    discount: 25.0,
    quantity: 1,
  },
];

getAllProduct();

function getAllProduct() {
  let totalPrice = 0;
  let totalTax = 0;
  let totalDiscount = 0;
  let currentTable = ` 
        <thead>
            <th>Product</th>
            <th>Description</th>
            <th>Quantity/Update</th>
            <th>Price</th>
            <th>Discount</th>
            <th>Tax</th>
            <th>Total</th>
        </thead>
    `;

  for (const product of products) {
    let discount = product.discount == 0 ? "--" : "$" + product.discount;
    let tax = getTax(product.quantity, product.price);
    let total = getTotalPrice(
      product.quantity,
      product.price,
      product.discount,
      tax
    );
    totalPrice += total;
    totalDiscount += product.discount;
    totalTax += tax;
    currentTable += `
    <tbody>
        <tr>
        <td><img class="table-image" src="${product.image}"/></td>
        <td>${product.name}<br/>Color : ${product.color}, Material : ${product.material}</td>
        <td>
            <div class="table-quantity">
                <input type="number" name="quantity" value="${product.quantity}" readonly class="quantity" id="quantity-${product.id}" />
                <button type="button" class="table-btn minus" onclick="minusQuatity(${product.id})" >
                    <i class="fas fa-minus"></i>
                </button>
                <button type="button" class="table-btn add" onclick="addQuantity(${product.id})">
                    <i class="fas fa-plus"></i>
                </button>
                <button type="button" class="table-btn delete" onclick="deleteProduct(${product.id})">
                    <i class="fas fa-times"></i>
                </button>
            </div>
        </td>
        <td id="price-${product.id}">$${product.price}.00</td>
        <td id="discount-${product.id}">${discount}</td>
        <td class="tax" id="tax-${product.id}">$${tax}.00</td>
        <td class="total-price" id="total-${product.id}" onchange="">$${total}.00</td>
        </tr>
    </tbody>
        `;
  }

  currentTable += ` 
        <tr>
            <td colspan="6" class="tfoot-total">Total Price: </td>
            <td id="totalPrice">$${totalPrice}.00</td>
        </tr>
        <tr>
            <td colspan="6" class="tfoot-total">Total Discount: </td>
            <td id="totalDiscount">$${totalDiscount}.00</td>
        </tr>
        <tr>
            <td colspan="6" class="tfoot-total">Total Tax: </td>
            <td id="totalTax">$${totalTax}.00</td>
        </tr> 
    `;
  currentTable += `
        </tbody>
    </table>`;
  document.getElementById("currentTable").innerHTML = currentTable;
}

function getTotalPrice() {
  return products.reduce((totalPrice, currentProduct) => {
    return (
      totalPrice +
      getTotalPrice(
        currentProduct.quantity,
        currentProduct.price,
        currentProduct.discount,
        getTax(currentProduct.quantity, currentProduct.price)
      )
    );
  }, 0);
}

function addQuantity(id) {
  let product = products.find((e) => e.id === id);
  product.quantity++;
  getAllProduct();
}

function minusQuatity(id) {
  let product = products.find((e) => e.id === id);
  if (product.quantity - 1 === 0) return;
  product.quantity--;
  getAllProduct();
}

function deleteProduct(id) {
  products = products.filter((e) => e.id !== id);
  getAllProduct();
}

function getTax(quantity, price) {
  return Math.round((quantity * price * 12.5) / 100);
}

function getTotalPrice(quantity, price, discount, tax) {
  if (isNaN(discount)) {
    discount = 0;
  }
  return quantity * price - discount + tax;
}
