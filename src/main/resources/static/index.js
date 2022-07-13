"use strict";

document.querySelector("body > form").addEventListener("submit", function (event) {
    event.preventDefault(); // turns off the page refresh/redirect
    

    console.log("THIS:", this);

    const data = {
        brand: this.brand.value,
        fuel: this.fuel.value,
        engine: this.engine.value
    }

    console.log("DATA:", data);

    axios.post("http://localhost:8080/createCar", data)
            .then(res => {
                console.log("RES:", res);
                this.reset();
                this.brand.focus();
                renderCars();
            })
            .catch(err => console.error(err));
});

const output = document.querySelector("#output");

function renderCars() {
    axios.get("http://localhost:8080/carGetAll")
        .then(res => {
            console.log("cars: ", res.data);
            output.innerHTML = "";
            for (let car of res.data) {
                const carCol = document.createElement("div");
                carCol.className = "col";

                const carCard = document.createElement("div");
                carCard.className = "card";
                carCol.appendChild(carCard);

                const carDiv = document.createElement("div");
                carDiv.className = "card-body";
                carCard.appendChild(carDiv);

                const carBrand = document.createElement("h2");
                carBrand.innerText = car.brand;
                carDiv.appendChild(carBrand);

                const carFuel = document.createElement("p");
                carFuel.innerText ="Fuel: " + car.fuel;
                carDiv.appendChild(carFuel);

                const carEngine = document.createElement("p");
                carEngine.innerText = "Engine: " + car.engine;
                carDiv.appendChild(carEngine);

                const carDelete = document.createElement('button');
                carDelete.innerText = "DELETE";
                carDelete.addEventListener("click", () => {
                    console.log("CAR: ", car);
                    deleteCar(car.id);
                });
                carDiv.appendChild(carDelete);

                output.appendChild(carCol);
            }
        })
        .catch(err => console.error(err));
}

const deleteDino = (id) => {
    axios.delete("http://localhost:8080/removeCar/" + id)
            .then(res => {
                console.log("Delete successful");
                renderCars();
            }).catch(err => console.error(err));
}

renderCars();