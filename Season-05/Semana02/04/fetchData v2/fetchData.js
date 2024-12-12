function fetchData(url) {
    fetch(url)
        .then((response) => response.json())
        .then((data) => {
            console.log(data); // Log the data
            const tbody = document.querySelector("#table tbody"); // Selecionar o <tbody>
            tbody.innerHTML = ""; // Limpa o conteúdo anterior, se necessário

            data.forEach(customer => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>${customer.phone}</td>
                    <td>
                        <button class="edit-btn">Edit</button>
                        <button class="delete-btn">Delete</button>
                    </td>
                `;
                tbody.appendChild(row);
            });
        })
        .catch((error) => console.error("Fetch error:", error));
}

fetchData("http://localhost:8080/javabank5/api/customer");
