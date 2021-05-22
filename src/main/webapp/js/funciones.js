//http://localhost:8080/Estacion/api/estacion
let url = "http://localhost:8080/Estacion/api/estacion";
const fetchParams = {
    method: "GET",
    mode: "cors",
    cache: "default"
};

let r = fetch("http://localhost:8080/Estacion/api/estacion", fetchParams)
        .then(res => res.json())
        .then(data => {
            const id1 = [... data.filter(d=>d.id_estacion===1)];
            const id2 = [... data.filter(d=>d.id_estacion===2)];
            const id3 = [... data.filter(d=>d.id_estacion===3)];
            const id4 = [... data.filter(d=>d.id_estacion===4)];
            const id5 = [... data.filter(d=>d.id_estacion===5)];
            
            const fechas = [... id1.map(s => s.fecha)];
            const teme1 = [... id1.map(s => parseFloat(s.temperatura))];
            const teme2 = [... id2.map(s => parseFloat(s.temperatura))];
            const teme3 = [... id3.map(s => parseFloat(s.temperatura))];
            const teme4 = [... id4.map(s => parseFloat(s.temperatura))];
            const teme5 = [... id5.map(s => parseFloat(s.temperatura))];
            
            const databa = {
                labels: fechas,
                datasets: [{
                        label: 'temp est 1',
                        data: teme1,
                        borderColor: 'rgb(0, 192, 192)',
                        backgroundColor: 'rgb(0, 192, 192)'
                    },
                    {
                        label: 'temp est 2',
                        data: teme2,
                        borderColor: 'rgb(75, 0, 192)',
                        backgroundColor: 'rgb(75, 0, 192)'
                    },
                    {
                        label: 'temp est 3',
                        data: teme3,
                        borderColor: 'rgb(75, 192, 0)',
                        backgroundColor: 'rgb(75, 192, 0))'
                    },
                    {
                        label: 'temp est 4',
                        data: teme4,
                        borderColor: 'rgb(0, 0, 192)',
                        backgroundColor: 'rgb(0, 0, 192)'
                    },
                    {
                        label: 'temp est 5',
                        data: teme5,
                        borderColor: 'rgb(75, 0, 0)',
                        backgroundColor: 'rgb(75, 0, 0)'
                    }
                ]
            };

            let cfgline = {type: 'line', data: databa};

            var myChart = new Chart(
                    document.getElementById('grafica'),
                    cfgline
                    );
        });
const poblacion1 = [
    0.5, 0.7, 0.9, 1.05, 2.6, 2.8, 3, 3.1, 3.2, 3.3
];
const poblacion2 = [
    1, 1.7, 1.9, 1.95, 3.6, 3.5, 3.4, 2.1, 3.1, 3.3
];
const ano = [1879, 1882, 1900, 1910, 1963, 1975, 1985, 1996, 2004, 2011];

const bgColor = [
    'rgb(0, 0, 0)',
    'rgb(20, 20, 20)',
    'rgb(40, 40,40)',
    'rgb(60, 60, 60)',
    'rgb(80, 80, 80)',
    'rgb(100, 100, 100)',
    'rgb(120, 120, 120)',
    'rgb(140, 140, 140)',
    'rgb(160, 160, 160)',
    'rgb(180, 180, 180)'
]

const data = {
    labels: ano,
    datasets: [{
            label: 'Evolucion de la poblacion1',
            data: poblacion1,
            borderColor: 'rgb(75, 192, 192)',
            backgroundColor: bgColor
        },
        {
            label: 'Evolucion de la poblacion2',
            data: poblacion2,
            borderColor: 'rgb(0, 0, 192)',
            backgroundColor: bgColor
        }]
};

const databar = {
    labels: ano,
    datasets: [{
            label: 'Evolucion de la poblacion1',
            data: poblacion1,
            borderColor: 'rgb(75, 192, 192)',
            backgroundColor: 'rgb(75, 192, 192)'
        },
        {
            label: 'Evolucion de la poblacion2',
            data: poblacion2,
            borderColor: 'rgb(0, 0, 192)',
            backgroundColor: 'rgb(0, 0, 192)'
        }]
};

const dataradar = {
    labels: ano,
    datasets: [{
            label: 'Evolucion de la poblacion1',
            data: poblacion1,
            borderColor: 'rgb(75, 192, 192)'
        },
        {
            label: 'Evolucion de la poblacion2',
            data: poblacion2,
            borderColor: 'rgb(0, 0, 192)'
        }]
};

const configline = {
    type: 'line',
    data: databar
};

const configbar = {
    type: 'bar',
    data: databar
};

const configbubble = {
    type: 'bubble',
    data: databar
};

const configpie = {
    type: 'pie',
    data: data
};

const configradar = {
    type: 'radar',
    data: dataradar
};

