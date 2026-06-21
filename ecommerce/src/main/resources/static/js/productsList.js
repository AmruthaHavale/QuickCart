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
    removeBtn.style.color = "darkred";
    removeBtn.onclick = () => row.remove();
    removeCell.appendChild(removeBtn);

    row.appendChild(nameCell);
    row.appendChild(priceCell);
    row.appendChild(removeCell);

    cartList.appendChild(row);
}
