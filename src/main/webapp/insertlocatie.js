let url= "http://localhost:8081/HotelReserveringen2023v4_war/api/locatie";


function insertlocatie(){
    let xhttp = new XMLHttpRequest();
    let locatie = {
        locatienaam: document.getElementById('locatienaam').value,
        distrikt: document.getElementById('distrikt').value,

    }

    xhttp.open('POST', url + '/add', true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send(JSON.stringify(locatie));
}