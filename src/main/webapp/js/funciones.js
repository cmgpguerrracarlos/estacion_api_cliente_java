let url = "http://localhost:8080/Estacion/api/estacion";
const fetchParams = {
    method: "GET",
    mode: "cors",
    cache: "default"
};

fetch(url, fetchParams)
        .then(res => res.json())
        .then(data => {
            const id1 = [... data.filter(d => d.id_estacion === 1)];
            const id2 = [... data.filter(d => d.id_estacion === 2)];
            const id3 = [... data.filter(d => d.id_estacion === 3)];
            const id4 = [... data.filter(d => d.id_estacion === 4)];
            const id5 = [... data.filter(d => d.id_estacion === 5)];

            const fechas = [... id1.map(s => s.fecha)];
            const teme1 = [... id1.map(s => parseFloat(s.temperatura))];
            const teme2 = [... id2.map(s => parseFloat(s.temperatura))];
            const teme3 = [... id3.map(s => parseFloat(s.temperatura))];
            const teme4 = [... id4.map(s => parseFloat(s.temperatura))];
            const teme5 = [... id5.map(s => parseFloat(s.temperatura))];

            const databa = {
                labels: fechas,
                options: {
                    scales: {
                        y: {suggestedMin: 0}}
                },
                datasets: [{
                        label: 'Estacion:1',
                        data: teme1,
                        borderColor: 'rgb(0, 192, 192)'
                    },
                    {
                        label: 'Estacion:2',
                        data: teme2,
                        borderColor: 'rgb(75, 0, 192)'
                    },
                    {
                        label: 'Estacion:3',
                        data: teme3,
                        borderColor: 'rgb(75, 192, 0)'
                    },
                    {
                        label: 'Estacion:',
                        data: teme4,
                        borderColor: 'rgb(255, 0, 0)'
                    },
                    {
                        label: 'Estacion:5',
                        data: teme5,
                        borderColor: 'rgb(75, 0, 0)'
                    }
                ]
            };

            let cfgline = {type: 'line', data: databa};

            let myChart = new Chart(
                    document.getElementById('grafica'),
                    cfgline
                    );
        });
