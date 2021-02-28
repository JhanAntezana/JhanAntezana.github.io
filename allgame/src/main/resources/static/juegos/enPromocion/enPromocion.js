const enPromocion = new Vue ({
    el:'#promo',
    data:{
        juegos: null
    },
    mounted(){
        axios.get("http://localhost:8080/juegos/inventario")
        .then(response =>(this.juegos = response.data))
    }
    
})