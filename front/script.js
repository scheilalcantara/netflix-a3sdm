function abrirPopup() {
    document.getElementById("popup").style.display = "flex";
}

function fecharPopup() {
    document.getElementById("popup").style.display = "none";
}

function amizade() {

    fetch("http://localhost:8080/amigos",
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },

            method: "POST",
            body: JSON.stringify({



            })

        })
        .then(function (res) { console.log(res) })
        .catch(function (res) { console.log(res) })

}