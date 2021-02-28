let data = {};

const app = new Vue({
    el: '#App',
    data:{
        saludo: 'Hola mundo',
        juegos: null,
        mensaje: "",
        mostrarInicio: true,
        mostrarLogin: false,
        mostrarRegister: false,
        usuario : {
            id_usuario: 0,
            nombre: "",
            apellido: "",
            username: "",
            email: "",
            password: "",
        },
        juegoBuscado:null,
        busqueda:null,
        id_usuario: 1,
        id:1,
        cant:1
    },
    methods:{
        btnChange: function(){
            this.btnIR = !this.btnIR;
            this.btnUS = !this.btnUS;
        },
        mostrarI: function(){
            this.mostrarLogin = false;
            this.mostrarInicio = true;
            this.mostrarRegister = false;
        },
        mostrarL: function(){
            this.mostrarLogin = true;
            this.mostrarInicio = false;
            this.mostrarRegister = false;
        },
        mostrarR: function(){
            this.mostrarLogin = false;
            this.mostrarInicio = false;
            this.mostrarRegister = true;
        },
        logIn: function(event){ //FUNCIONA
            this.mostrarI();
            this.btnChange();
            axios.get(`http://localhost:8080/usuarios/logIn/${this.usuario.username}/${this.usuario.password}`)
                .then(response => data = response.data)
                .catch(e => console.log(e));
            
        },
        register: function(event){ //FUNCIONA
            this.mostrarI();
            this.btnChange();
            axios.post("http://localhost:8080/usuarios", this.usuario)
            .then(response => data = this.usuario);
        },
        añadirAlCarrito(id_usuario,id_juego){
            axios.post('http://localhost:8080/carrito',{
                prarms:{
                    id_usuario: id_usuario,
                    id_juego: id_juego,
                    cant_juego: this.cant
                }
            })
            .catch(e =>{
                
            })
        },
        buscarJuego(){
            axios.get(`http://localhost:8080/juegos/${this.juegoBuscado}`)
            .then(response =>(this.busqueda = response.data))
            .catch(e => console.log(e));
        }
    },
    mounted(){
        axios.get("http://localhost:8080/juegos/inventario")
        .then(response =>(this.juegos = response.data))
    }

})