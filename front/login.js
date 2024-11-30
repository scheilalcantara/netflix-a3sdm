const formulario = document.querySelector("form");
const botao = document.querySelector("button");
const Iemail = document.getElementById("email");
const Isenha = document.getElementById("senha");


async function logar() {

    let resp = await fetch('http://localhost:8080/login',
        {
            method: "POST",
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify({

                email: Iemail.value,
                senha: Isenha.value,
            })
        });

            if (!resp.ok) {
                alert("Erro fetch");
            }

            const data = await resp.json();

            if(data.sucesse) {
                 window.location.href="http://127.0.0.1:8081/front/index.html"

            } else {  
                alert("Erro ao realizar login. Por gentileza tente outra vez!");

            }

};

function clear() {
  
    Iemail.value = "";
    Isenha.value = "";
};

formulario.addEventListener('submit', function (event){
    event.preventDefault();

    logar();
    clear();

})