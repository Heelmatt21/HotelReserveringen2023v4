function displayReserveringnTable(apiReserveringData) {
    var table = document.getElementById("reserveringTable");
    fetch('http://localhost:8081/HotelReserveringen2023v4_war/api/reservering/list')
        .then(response => response.json())
        .then(data1 => {
            for (var i = 0; i < apiReserveringData.length; i++) {
                var row = table.insertRow(-1);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);
                var cell4 = row.insertCell(3);
                var cell5 = row.insertCell(4);
                // var cell6 = row.insertCell(5);
                // var cell7 = row.insertCell(6);
                //var cell8 = row.insertCell(7);
                cell1.innerHTML = apiReserveringData[i].reservering_id;
                cell2.innerHTML = apiReserveringData[i].reserveerDatum;
                cell3.innerHTML = apiReserveringData[i].reserveringsnummer;
                cell4.innerHTML = apiReserveringData[i].locatieId;
                cell5.innerHTML = apiReserveringData[i].klantId;
                // cell6.innerHTML = apiReserveringData[i].familienaam;
                // cell7.innerHTML = apiReserveringData[i].voornaam;
                //cell8.innerHTML = apiReserveringData[i].locatienaam;
            }
        })
        .catch(error => console.error(error));
//     const date = new Date(mysqlDate);
//     const formattedDate = date.toLocaleDateString(); // Formats the date as "MM/DD/YYYY"
//
// // Output the formatted date to an HTML element with ID "myElement"
//     document.getElementById("myElement").textContent = formattedDate;
}
