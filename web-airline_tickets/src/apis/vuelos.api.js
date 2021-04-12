const listar = document.getElementById("#listarVuelos");
function getApiListaVuelos() {
  var lista = [];
  let URL =
    "http://localhost:8084/airline_tickets_Api-RESTFul/vuelo/listaVuelos";
  fetch(URL, {
    method: "GET",
  })
    .then((res) => res.json())
    .then((data) => {
      lista = data;
      data.forEach((element) => {
        lista.push(element);
      });
      return lista;
    });
}

console.log(getApiListaVuelos());
