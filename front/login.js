const formulario = document.querySelector("form");
const botao = document.querySelector("button");
const Iemail = document.getElementById("email");
const Isenha = document.getElementById("senha");


async function logar(email, senha) {

    const url = "http://localhost:8080/login";


    const dados = {

        emal: Iemail.value,
        senha: Isenha.value
    };

    try{

    const response = await fetch(url,
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(dados)
        });

    if (!response.ok) {
        const erro = await response.json();
        alert("Erro: " + (erro.error || "E-mail ou senha inválidos."));
        return;
    }

    const resultado = await response.json();
    alert(`Bem-vindo, ${resultado.nome}!`);
    console.log(resultado);
    window.location.href = "http://127.0.0.1:8081/front/index.html"

} catch (erro) {
    alert("Erro ao conectar ao servidor.");
    console.error("Erro na requisição:", erro);
}
       
};

function clear() {

    Iemail.value = "";
    Isenha.value = "";
};

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    logar();
    clear();

})