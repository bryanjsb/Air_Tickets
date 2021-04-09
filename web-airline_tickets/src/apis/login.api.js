function verifyUser() {
  let URL =
    "http://localhost:8084/airline_tickets_Api-RESTFul/vuelo/listaVuelos";
  fetch(URL, {
    method: "GET",
  })
    .then((res) => res.json())
    .then((data) => {
      console.log(data);
    });
}
