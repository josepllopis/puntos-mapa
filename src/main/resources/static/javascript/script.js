let map;
let marcador;

$(document).ready(function() {


cargarPuntos();
initMap()


});



function initMap() {
    // Coordenadas iniciales por defecto
    const centro = { lat: 0, lng: 0 };
    map = new google.maps.Map(document.getElementById("map"), {
        zoom: 2,
        center: centro,
    });
}

function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    };
}

async function cargarPuntos(){

  const request = await fetch('/api/v1/puntos', {
    method: 'GET',
    headers : getHeaders()

  });
  const puntos = await request.json();

 
    let listaPuntos = '';
for(let punto of puntos){
 
     const fecha = new Date(punto.tiempo);

      const botonInfo = `
      <button class="btn btn-info btn-sm" onclick="marcarPunto(${punto.lat}, ${punto.longi})">
        <i class="fas fa-info-circle"></i>
      </button>
    `;

    // Darle formato bonito (por ejemplo DD/MM/YYYY HH:mm)
    const fechaFormateada = fecha.toLocaleString('es-ES', {
      day: '2-digit',
      month: '2-digit',
      year: 'numeric',
      hour: '2-digit',
      minute: '2-digit',
      second: '2-digit'
    });
    let puntoHtml = ' <tr><td>'+punto.lat+'</td><td>'+punto.longi+'</td><td>'+fechaFormateada+'</td><td>'+botonInfo+'</td></tr>'
    listaPuntos+=puntoHtml;
}



document.querySelector('#puntos tbody').innerHTML = listaPuntos;
  console.log("puntos");





}

function marcarPunto(lat, lng) {
    const posicion = { lat: lat, lng: lng };
    map.setCenter(posicion);
    map.setZoom(8);

    // Si ya hay marcador, lo eliminamos
    if (marcador) {
        marcador.setMap(null);
    }

    // Añadir marcador nuevo
    marcador = new google.maps.Marker({
        position: posicion,
        map: map,
        title: `Lat: ${lat}, Lng: ${lng}`
    });
}