let map;
let marcador;

function initMap() {
    const centro = { lat: 0, lng: 0 };
    map = new google.maps.Map(document.getElementById("map"), {
        zoom: 2,
        center: centro,
    });

    // Cargamos los puntos una vez que el mapa esté listo
    cargarPuntos();
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
      <button class="btn btn-danger btn-sm" onclick="deletePunto(${punto.id})">
              <i class="fas fa-trash"></i>
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

listaPuntos+= ` <tr>
                           <td colspan =2><input id="inLatitud" step="0.01" style="text-align:center; width:80%" type= number min=-90 max=90 placeholder = 'Ingresa la latitud'/></th>
                           <td><input id="inLongitud" step="0.01" style="text-align:center; width:80%" type= number min=-180 max=180 placeholder = 'Ingresa la longitud'/></th>
                           <td><a onclick="addPunto()" class="btn btn-danger btn-circle"><i class="fas fa-add"></i></a></th>
                         </tr>`;



document.querySelector('#puntos tbody').innerHTML = listaPuntos;
  console.log("puntos");





}

async function deletePunto(id){
    if(!confirm("¿Seguro que quieres eliminar este punto?")) return;

     const request = await fetch('/api/v1/puntos/'+id, {
            method: 'DELETE',
            headers : getHeaders(),
          });

        cargarPuntos();
}

async function addPunto(){


    let addLatitud = document.getElementById('inLatitud').value;
    let addLongitud = document.getElementById('inLongitud').value;

    if(!addLatitud){
        alert('Introduce la latitud');
        return;
    }

    if(!addLongitud){
        alert('Introduce la longitud');
        return;
    }

    if(addLatitud < -90 || addLatitud > 90){
        alert('La latitud tiene que estar entre -90 y 90');
        return;
    }

    if(addLongitud < -180 || addLongitud > 180){
            alert('La latitud tiene que estar entre -90 y 90');
            return;
        }


   const datos = {
     lat: parseFloat(addLatitud),
     longi: parseFloat(addLongitud),
     tiempo: new Date().toISOString()
   };

    const request = await fetch('/api/v1/puntos', {
        method: 'POST',
        headers : getHeaders(),
        body: JSON.stringify(datos)

      });

    cargarPuntos();
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