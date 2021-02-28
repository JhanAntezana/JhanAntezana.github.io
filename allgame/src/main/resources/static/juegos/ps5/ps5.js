const play5 = new Vue ({
    el:'#ps5',
    data:{
        juegos: {},
        consola:"Playstation 5"
    },
    mounted(){
        axios.get("http://localhost:8080/juegos/consola",{
            params:{
                consola : this.consola
            } 
        })
        .then(response =>(this.juegos = response.data))
    }
})