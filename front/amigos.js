const searchField = document.getElementById("pesquisar-input");
const resultsDiv = document.getElementById("results");

    searchField.addEventListener("keydown", function (e) {
        if (e.key === "Enter") { 
            e.preventDefault(); 

            const query = searchField.value.trim(); 
            if (query) {
                search(query); 
            } else {
                console.error("Digite algo para pesquisar.");
                resultsDiv.innerHTML = "<p> Por favor, insira um termo de pesquisa.</p>";
            }
        }
    });


    async function search(query) {
        console.log(`Pesquisando por: ${query}`);

        try {
            
            const response = await fetch(`http://localhost:8080/cadastro${encodeURIComponent(query)}`);

            if (!response.ok) {
                throw new Error(`Erro: ${response.status}`);
            }

            const results = await response.json();

            if (results.length === 0) {
                resultsDiv.innerHTML = "<p> Nenhum resultado encontrado. </p>";
            } else {
                resultsDiv.innerHTML = results
                    .map(
                        (item) =>
                            `<div>
                                <h4>${item.name}</h4>
                                <p>${item.username}</p>
                            </div>`
                    )
                    .join("");
            }
        } catch (error) {
            console.error("Erro ao buscar resultados:", error.message);
            resultsDiv.innerHTML = "<p> Erro ao buscar resultados. </p>";
        }
    }
