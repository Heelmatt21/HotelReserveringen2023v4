let url = "http://localhost:8081/HotelReserveringen2023v4_war/api/reservering";

function addReservation() {
    let reservation = {
        // "klant_id": document.getElementById("klant_id").value,
        // "location_id": document.getElementById("restaurant").value,

// er moet een get by name komen met een event listener
//     "tafel_id": document.getElementById("table").value,
    "reservation_date": document.getElementById("reservationDate").value,
    // "reservation_time": document.getElementById("reservationTime").value,
    // "number_of_guest": document.getElementById("numberOfGuest").value,
    // "special_requests": document.getElementById("specialRequest").value
        };
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open('POST', url + '/add', true);
    xmlhttp.onreadystatechange = function () {
    if (xmlhttp.readyState > 3 && xmlhttp.status === 204) {
    clearInputFields();        }    };
    xmlhttp.setRequestHeader('Content-Type', 'application/json');
    xmlhttp.send(JSON.stringify(reservation));}


// function insertreservering() {
//     let xhttp = new XMLHttpRequest();
//     let klanten = {
//         reserveerDatum: document.getElementById('reserveerDatum').value,
//         reserveringsnummer: document.getElementById('reserveringsnummer').value,
//         locatieId: document.getElementById('locatieId').value,
//         klantId: document.getElementById('klantId').value,
//
//     };
//
//
//     xhttp.open('POST', url + '/add', true);
//     xhttp.setRequestHeader('Content-Type', 'application/json');
//     xhttp.send(JSON.stringify(klanten));
// }
// function submitReserveringForm() {
//     var form = document.getElementById("reservering-form");
//     var reserveerDatum = document.getElementById("reserveerDatum").value;
//     var reserveringsnummer = document.getElementById("reserveringsnummer").value;
//     var locatieId = document.getElementById("locatieId").value;
//     var klantId = document.getElementById("klantId").value;
//
//
//     var xhr = new XMLHttpRequest();
//     xhr.open("POST", "http://localhost:8081/HotelReserveringen2023v4_war/api/reservering/add");
//     xhr.setRequestHeader("Content-Type", "application/json");
//
//     xhr.onload = function () {
//         if (xhr.status == 200) {
//             alert("Reservering added successfully!");
//             form.reset();
//         } else {
//             alert("Error adding reservering");
//         }
//     };
//
//     var data = JSON.stringify({
//         reserveerDatum: reserveerDatum,
//     });
//
//     xhr.send(data);
// }
//
// var form = document.getElementById("reservering-form");
// form.addEventListener("submit", function(event) {
//     event.preventDefault();
//     submitReserveringForm;
// });