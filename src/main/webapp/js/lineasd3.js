var datos = [];


function cargar(){
    d3.json('datos.json',(err,data)=>{
        datos = data;
        graficar();
    });
    
}

function graficar(){
    var width=300, heigth=200;
    var svg = d3.select("body").append("svg")
            .attr("width",width)
            .attr("heigth",height)
            .append("g");
}

xRange = d3.scale.lineal()
        .range([0,width])
        .domain([d3.min(datos,(d)=>{
                return d.x;
        }),
            d3.max(datos,(d)=>{
                return d.x;
            })
        ]);