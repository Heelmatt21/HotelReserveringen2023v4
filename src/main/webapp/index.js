const url = "http://localhost:8081/HotelReserveringen2023v4_war/api/locatie/list"
const dataElement = document.getElementById('data');
const form = document.getElementById('form');
const locatieInput = document.getElementById('locatienaam');
const distriktInput = document.getElementById('distrikt');
const submitButton = document.getElementById('submit-button');

// Get all data
async function getLocatie() {
    const response = await fetch(url)
        .then(response => response.json())
        .then(data => {
            // Use the data here
            dataElement.innerHTML = JSON.stringify(data);
        })
        .catch(error => {
            // Handle errors here
            console.error(error);

        });


}
/*async function getTableBody() {
    var tableBody = document.getElementById("table-body");
    fetch(url)
        .then(response => response.json())
        .then(data => {
            for (var i = 0; i < data.length; i++) {
                var row = tableBody.insertRow(-1);
                var idCell = row.insertCell(0);
                var locatieCell = row.insertCell(1);
                var distriktCell = row.insertCell(2);
                idCell.innerHTML = data[i].locatie_id;
                locatieCell.innerHTML = data[i].locatienaam;
                distriktCell.innerHTML = data[i].distrikt;
            }
        })
        .catch(error => console.error(error));
}*/
//Show data table
function displayTable(apiData) {
    var table = document.getElementById("myTable");
    fetch('http://localhost:8081/HotelReserveringen2023v4_war/api/locatie/list')
        .then(response => response.json())
        .then(data => {
            for (var i = 0; i < apiData.length; i++) {
                var row = table.insertRow(i+1);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);
                cell1.innerHTML = apiData[i].locatie_id;
                cell2.innerHTML = apiData[i].locatienaam;
                cell3.innerHTML = apiData[i].distrikt;
            }
        })
        .catch(error => console.error(error));
    /*fetch('http://localhost:8080/HotelReserveringen2023v4_war/api/locatie/list')
        .then(response => response.json())
        .then(data => {
            // Call the displayTable function with the retrieved data
            displayTable(data);
        })
        .catch(error => console.error(error));*/

}
