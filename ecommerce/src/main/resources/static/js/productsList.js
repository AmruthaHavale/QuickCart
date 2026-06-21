document.addEventListener("DOMContentLoaded", () => {
    const buttons = document.querySelectorAll(".ItemButton");

    buttons.forEach(button => {
        button.addEventListener("click", () => {
            const name = button.getAttribute("data-name");
            const price = button.getAttribute("data-price");
            addToCart(name, price);
        });
    });
});

// productsList.js

function addToCart(productName, productPrice) {
    const cartList = document.getElementById("cartList");

    const row = document.createElement("tr");

    const nameCell = document.createElement("td");
    nameCell.textContent = productName;

    const priceCell = document.createElement("td");
    priceCell.textContent = productPrice;

    const removeCell = document.createElement("td");
    const removeBtn = document.createElement("button");
    removeBtn.textContent = "Remove";
    removeBtn.style.border = "none";
    removeBtn.style.backgroundColor = "transparent";
    removeBtn.style.color = "red";
    removeBtn.onclick = () => row.remove();
    removeCell.appendChild(removeBtn);

    row.appendChild(nameCell);
    row.appendChild(priceCell);
    row.appendChild(removeCell);

    cartList.appendChild(row);
}

// Calculate total prices
function calculateTotal() {
    const cartList = document.getElementById("cartList");
    const rows = cartList.getElementsByTagName("tr");
    let total = 0;

    // Skip the header row (index 0)
    for (let i = 1; i < rows.length; i++) {
        const priceCell = rows[i].getElementsByTagName("td")[1];
        if (priceCell) {
            total += parseFloat(priceCell.textContent);
        }
    }

    document.getElementById("totalDisplay").textContent = "Total: ₹" + total;
}

// Attach event listener to the button
document.addEventListener("DOMContentLoaded", () => {
    const totalBtn = document.getElementById("showTotalBtn");
    totalBtn.addEventListener("click", calculateTotal);
});
