function fetchData(url) {
    fetch(url)
        .then((response) => response.json())
        .then((data) => {
            console.log(data); // Log the data
            const table = document.getElementById("table");
            data.forEach(customer => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>${customer.phone}</td>
                `;
                table.appendChild(row);
            });
        })
        .catch((error) => console.error("Fetch error:", error));
}

fetchData("http://localhost:8080/javabank5/api/customer");
