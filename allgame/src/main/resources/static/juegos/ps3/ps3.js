const play3 = new Vue ({
    el:'#ps3',
    data:{
        juegos: {},
        consola:"Playstation 3"
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