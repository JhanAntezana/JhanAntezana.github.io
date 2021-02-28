const miCarrito = new Vue({
    el:'#cesta',
    data:{
        juegos: null,
        cantidad: 1,
        costoEnvio: 7.50,
        subTotal: 379.70,
        total: 0,
        id_usuario: 1,
        cant:1
    },
    computed:{
        sumarSubtotal(){
            return calcularSubtotal();
        },
        sumarTotal(){
            this.total = 0;
            this.total = this.subTotal + this.costoEnvio;
            return this.total
        }
    },
    methods:{
        calcularSubtotal(){
            juegos.forEach(juego => {
                this.subTotal = this.subTotal + juego.precio;
            });
            return this.subTotal
        },
        quitarDelCarrito(){
            
        }
    },
    mounted(){
        axios.get("http://localhost:8080/carrito",{
            params: {
                id_usuario: this.id_usuario
            }
        })
        .then(response =>(this.juegos = response.data))
        .catch(e =>{
            console.log(e)
        })
    }
})