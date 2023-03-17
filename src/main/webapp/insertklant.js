let url= "http://localhost:8081/HotelReserveringen2023v4_war/api/klant";
// const form = document.querySelector('form');
//
// form.addEventListener('submit', (event) => {
//     event.preventDefault(); // prevent the form from submitting normally
//
//     const formData = new FormData(form);
//
//     fetch('http://localhost:8081/HotelReserveringen2023v4_war/api/klant/add', {
//         method: 'POST',
//         body: formData
//     })
//         .then(response => response.json())
//         .then(data => console.log(data))
//         .catch(error => console.error(error));
// });


function insertklant(){
    let xhttp = new XMLHttpRequest();
    let klanten = {
        familienaam: document.getElementById('familienaam').value,
        voornaam: document.getElementById('voornaam').value,
        adres: document.getElementById('adres').value,
        distrikt: document.getElementById('distrikt').value,
        land: document.getElementById('land').value,
        telefoonnummer: document.getElementById('telefoonnummer').value,
        klantnummer: document.getElementById('klantnummer').value
    }




    // xhttp.onreadystatechange = function () {
    //     if (this.readyState === 4 && this.status === 200) {
    //         let keuring = JSON.parse(this.response);
    //         let tableBody = document.getElementById('meesteKeuringen');
    //         tableBody.innerHTML = `<tr>
    //             <td>` + keuring.naam + `</td>
    //             <td>` + keuring.voorNaam + `</td>
    //             <td>` + keuring.aantalKeuringen + `</td>
    //         </tr>`;
    //     }
    // };

    xhttp.open('POST', url + '/add', true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send(JSON.stringify(klanten));
}


