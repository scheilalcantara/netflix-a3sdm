const formulario = document.querySelector("form");
const botao = document.querySelector("button");
const Inome = document.querySelector(".input-nome");
const Iemail = document.querySelector(".input-email");
const Iusername = document.querySelector(".input-username");
const Isenha = document.querySelector(".input-senha");



async function cadastrar() {

    let resposta = await fetch('http://localhost:8080/cadastro',
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify({
                nome: Inome.value,
                email: Iemail.value,
                username: Iusername.value,
                senha: Isenha.value
            })
        })

        .then(function (resposta) {console.log (resposta) })
        .catch(function (resposta) {console.log (resposta)})

};

function limpar() {
    Inome.value = "";
    Iemail.value = "";
    Iusername.value = "";
    Isenha.value = "";
};

formulario.addEventListener('submit', function (event){
    event.preventDefault();

    cadastrar();
    limpar();
});