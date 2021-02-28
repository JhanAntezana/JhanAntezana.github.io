const nintendoSwitch = new Vue ({
    el:'#nintendo',
    data:{
        juegos: null,
        consola:"Nintendo Switch"
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