/*async function getKlanten() {
    const response = await fetch("http://localhost:8081/HotelReserveringen2023v4_war/api/klant/list")
        .then(response => response.json())
        .then(data1 => {
            // Use the data here
            dataElement.innerHTML = JSON.stringify(data1);
        })
        .catch(error => {
            // Handle errors here
            console.error(error);

        });
}*/
function displayKlantenTable(apiKlantData) {
    var table = document.getElementById("klantenTable");
    fetch('http://localhost:8081/HotelReserveringen2023v4_war/api/klant/list')
        .then(response => response.json())
        .then(data1 => {
            for (var i = 0; i < apiKlantData.length; i++) {
                var row = table.insertRow(-1);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);
                var cell4 = row.insertCell(3);
                var cell5 = row.insertCell(4);
                var cell6 = row.insertCell(5);
                var cell7 = row.insertCell(6);
                var cell8 = row.insertCell(7);
                cell1.innerHTML = apiKlantData[i].klant_id;
                cell2.innerHTML = apiKlantData[i].familienaam;
                cell3.innerHTML = apiKlantData[i].voornaam;
                cell4.innerHTML = apiKlantData[i].adres;
                cell5.innerHTML = apiKlantData[i].distrikt;
                cell6.innerHTML = apiKlantData[i].land;
                cell7.innerHTML = apiKlantData[i].telefoonnummer;
                cell8.innerHTML = apiKlantData[i].klantnummer;
            }
        })
        .catch(error => console.error(error));
}
// function deleteKlant() {
//     const form = document.getElementById('delete-form');
//     const result = document.getElementById('result');
//
//     form.addEventListener('submit', (event) => {
//         event.preventDefault();
//
//         const id = document.getElementById('klant_id').value;
//
//         fetch(`/api/klant/remove/${id}`, {
//             method: 'DELETE'
//         })
//             .then((response) => {
//                 if (response.ok) {
//                     result.textContent = 'Resource deleted successfully.';
//                 } else {
//                     result.textContent = 'Error deleting resource.';
//                 }
//             })
//             .catch((error) => {
//                 result.textContent = 'Error deleting resource.';
//             });
//     });
// }
