const tbody = document.querySelector("tbody");
const calculateTotalTax = () => {
    let totalTax = 0;
    document.querySelectorAll(".tax").forEach((i) => {
        totalTax += parseFloat(i.innerHTML.replace("$", ""));
    });
    document.querySelector(".total-tax").innerHTML = totalTax;
};
const formatMoney = (money) => {
    const formatter = new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
    });

    return formatter.format(parseFloat(money));
};
const calculateCurrentTax = (currentRow) => {
    const price = parseFloat(
        currentRow.querySelector(".price").innerHTML.replace("$", "")
    );
    const quantity = parseFloat(
        currentRow.querySelector(".input-quantity").value.replace("$", "")
    );
    const result = Math.round(((price * quantity * 12.5) / 100) * 1) / 1;
    currentRow.querySelector(".tax").innerHTML = formatMoney(result);
    return result;
};
const calculateCurrentTotal = (currentRow) => {
    const tmpDiscount = parseFloat(
        currentRow.querySelector(".discount").innerHTML.replace("$", "")
    );
    const discount = isNaN(tmpDiscount) ? 0 : tmpDiscount;
    const quantity = parseFloat(
        currentRow.querySelector(".input-quantity").value.replace("$", "")
    );
    const price = parseFloat(
        currentRow.querySelector(".price").innerHTML.replace("$", "")
    );
    const tax = parseFloat(
        currentRow.querySelector(".tax").innerHTML.replace("$", "")
    );
    currentRow.querySelector(".total").innerHTML = formatMoney(quantity * price - discount + tax);
};
const calculateTotalPrice = () => {
    let totalPrice = 0;
    let totalDiscount = 0;
    let totalTax = 0;
    const trEls = tbody.querySelectorAll("tr");
    trEls.forEach(row => {
        const currentPrice = parseFloat(
            row.querySelector(".total").innerHTML.replace("$", "")
        );
        totalPrice += currentPrice;

        const currentTax = parseFloat(
            row.querySelector(".tax").innerHTML.replace("$", "")
        );
        totalTax += currentTax;

        const tmpDiscount = parseFloat(
            row.querySelector(".discount").innerHTML.replace("$", "")
        );
        const currentDiscount = isNaN(tmpDiscount) ? 0 : tmpDiscount;
        totalDiscount += currentDiscount;
    })
    console.log(formatMoney(totalPrice))
    document.querySelector(".total-price").innerHTML = formatMoney(totalPrice);
    document.querySelector(".total-tax").innerHTML = formatMoney(totalTax);
    document.querySelector(".total-discount").innerHTML = formatMoney(totalDiscount);
}
const calculateAll = (currentRow) => {
    if (currentRow != null) {
        calculateCurrentTax(currentRow);
        calculateCurrentTotal(currentRow);
    }else{
        console.log(1)
    }
    calculateTotalPrice();
};
const handleMinus = (el) => {
    const inputEl = el.parentElement.querySelector("input");

    if (inputEl.value == 1) return;
    else {
        inputEl.value -= 1;
    }
    calculateAll(el.parentElement.parentElement);
};

const handleAdd = (el) => {
    const inputEl = el.parentElement.querySelector("input");
    inputEl.value = parseInt(inputEl.value) + 1;
    calculateAll(el.parentElement.parentElement);
};
const handleCancel = (el) => {
    el.parentElement.parentElement.remove();
    calculateAll(null);
};
window.addEventListener('DOMContentLoaded', () => {
    document.querySelectorAll(".btn-minus").forEach(i => {
        i.addEventListener("click", (e) => {
            handleMinus(e.path[0])
        })
    })
    document.querySelectorAll(".btn-add").forEach(i => {
        i.addEventListener("click", (e) => {
            handleAdd(e.path[0])
        })
    })
    document.querySelectorAll(".btn-cancel").forEach(i => {
        i.addEventListener("click", (e) => {
            handleCancel(e.path[0])
        })
    })
});
// tdEls.forEach(i => {
//     i.querySelector(".btn-minus").addEventListener("click", handleMinus(e));
//     i.querySelector(".btn-add").addEventListener("click", handleAdd);
//     i.querySelector(".btn-cancel").addEventListener("click", handleCancel);
// })
