document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("auth").addEventListener("submit", authUser);
});

async function authUser(e) {
  e.preventDefault();
  user = document.getElementById("user").value;
  pass = document.getElementById("password").value;
  let URL = "http://localhost:8084/airline_tickets_Api-RESTFul/sign/in";
  await fetch(URL, {
    method: "POST",
    body: JSON.stringify({ user: user, password: pass }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((res) => res.text())
    .then((response) => {
      console.log(response);
      if (
        typeof response !== "undefined" &&
        response !== null &&
        response !== "undefined" &&
        response !== "Denegado"
      ) {
        sincronizarStorageLogin(response);
        getInfoUser();
        document.location.href = "../sign-up/index.html";
      } else {
        removerStorageLogin();
        removerStorageInfoUser();
        setTimeout(() => {}, 15000);
        document.location.href = "../sign-in/index.html";
      }
    });
}

function sincronizarStorageLogin(auth) {
  localStorage.setItem("Login", auth);
}

function removerStorageLogin() {
  localStorage.removeItem("Login");
}

function getInfoUser() {
  var login = JSON.parse(localStorage.getItem("Login")) || [];

  let URL =
    "http://localhost:8084/airline_tickets_Api-RESTFul/infoUser/" + login.id;
  console.log(URL);
  fetch(URL, {
    method: "GET",
  })
    .then((res) => res.json())
    .then((data) => {
      console.log("ger info user", data);
      sincronizarStorageInfoUser(data);
    });
}

function sincronizarStorageInfoUser(user) {
  localStorage.setItem("InfoUser", JSON.stringify(user));
}

function removerStorageInfoUser() {
  localStorage.removeItem("InfoUser");
}
