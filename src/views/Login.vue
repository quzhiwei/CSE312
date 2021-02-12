<template>
<div>
  <form action="">
    <label >Account Name: </label><br>
    <input type="text" v-model = " accountName"><br>
    <label for="password">Password: </label><br>
    <input type="password" id="password"><br>
    <button type="submit" @click = "submitLogin">Login</button>
    <br>
    <router-link to="/register">I do not have an account, register Now!</router-link>
  </form>
</div>
</template>

<script>
export default {
  name: "Login",
  data(){
    return{
      accountName:"",
      accountPassword:"",
    }
  },
  methods:{
    submitLogin(){
      const url = "http://localhost:8080/login";
      this.axios.post(url,{userName:this.accountName,password:this.accountPassword}).then(res=>{
        if(res.data == false){
          alert("Incorrect username or password");
          return;
        }
      })
    }

  }

}
</script>

<style scoped>

</style>