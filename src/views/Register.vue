/* eslint-disable */
<template>
<div>
  <form action="">
    <label >Account Name:</label><br>
    <input type="text" v-model="accountName"><br>
    <button class = "blueunderline" >Check Account Name</button><br><br>
    <label for="email">Email:</label><br>
    <input type="email" id="email"><br><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password"><br>

    <button type = "button" >Register!</button>
    <br>
    <router-link>I have an account, login now</router-link>
  </form>
</div>
</template>

<script>
/* eslint-disable */
export default {
  name: "Register",
  data(){
    return{
      accountName:"",
    }
  },
  methods:{
    checkAccountName:()=> {
      const pattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
      // var realEmail = /^[\w\-\.]+@[a-z0-9]+(\-[a-z0-9]+)?(\.[a-z0-9]+(\-[a-z0-9]+)?)*\.[a-z]{2,4}$/i;
      var isOk = pattern.test(this.accountName);
      if (isOk == false) {
        alert("Please Enter Correct Email!");
        this.accountName.focus();
      }
      return isOk;
    }
  }
}
</script>

<style scoped>

</style>