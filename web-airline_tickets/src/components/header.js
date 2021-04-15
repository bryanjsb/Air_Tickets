function mostrarBotonLoginHeader() {
  const listar = document.getElementById("listarLog");
  let log = document.createElement("div");

  log.innerHTML = `  <div class="text-end">
            <a href="../src/views/sign-in/index.html">
              <button type="button" class="btn btn-outline-light me-2">
                Login
              </button></a
            >
            <a href="../src/views/sign-up/index.html">
              <button type="button" class="btn btn-warning">Sign-up</button></a
            >
          </div>`;

  listar.appendChild(log);
}

function mostrarBotonInfoUserHeader() {
  const listar = document.getElementById("listarLog");
  info = JSON.parse(localStorage.getItem("Login")) || [];
  console.log(info);
  let log = document.createElement("div");

  log.innerHTML = `  <div class="text-end">
            <a href="../src/views/sign-in/index.html">
              <button type="button" class="btn btn-outline-light me-2">
                ${info.user}
              </button></a
            >
            <a href="../src/views/sign-up/index.html">
              <button type="button" class="btn btn-warning">Sign-up</button></a
            >
          </div>`;

  listar.appendChild(log);
}

mostrarBotonInfoUserHeader();
