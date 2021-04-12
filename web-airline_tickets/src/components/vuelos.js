function listarVuelosHTML() {
  lista.array.forEach((element) => {
    listar.innerHTML = `<p>${element.idVuelo}</p>`;
  });
}
