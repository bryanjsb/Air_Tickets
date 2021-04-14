const listar = document.getElementById("listarVuelos");
var l = [];
function getApiListaVuelos() {
  let URL =
    "http://localhost:8084/airline_tickets_Api-RESTFul/vuelo/listaVuelos";
  fetch(URL, {
    method: "GET",
  })
    .then((res) => res.json())
    .then((data) => {
      console.log(data);

      for (var i = 0; i < data.length; i += 2) {
        let o1 = document.createElement("div");

        o1.innerHTML = `
     <div class="row">
    <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Vuelo a ${data[i].destino}</h5>
        <p class="card-text">
        Origen:  ${data[i].destino}
        fecha de ida: ${data[i].fechaIda}
        fecha de regreso: ${data[i].fechaRegreso}
        Descuento:  ${data[i].descuento}%
        Cantidad de Pasajeros:  ${data[i].cantidadPasajeros}
        </p>
        <a href="#" class="btn btn-primary agregar-carrito" data-id="${
          data[i].idVuelo
        }">Reservar</a>
      </div>
    </div>
     </div>

     <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Vuelo a ${data[i + 1].destino}</h5>
        <p class="card-text">
        Origen:  ${data[i + 1].destino}
        fecha de ida: ${data[i + 1].fechaIda}
        fecha de regreso: ${data[i + 1].fechaRegreso}
        Descuento:  ${data[i + 1].descuento}%
        Cantidad de Pasajeros:  ${data[i + 1].cantidadPasajeros}
        </p>
        <a href="#" class="btn btn-primary agregar-carrito" data-id="${
          data[i + 1].idVuelo
        }">Reservar</a>
      </div>
    </div>
     </div>
    
  </div>
</div>
`;
        listar.appendChild(o1);
      }
    });
}

getApiListaVuelos();
