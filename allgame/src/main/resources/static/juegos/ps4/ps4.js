const play4 = new Vue ({
    el:'#ps4',
    data:{
        juegos: null,
        consola:"Playstation 4"
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