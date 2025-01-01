<template>
  <form @submit.prevent="handleSubmit">
    
    <div v-if="error" class="alert alert-danger" role="alert">
      {{ error }}
    </div>

    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
   
      <input v-model="email" type="email" class="form-control"  placeholder="name@example.com">
      
      <input v-model="password"  type="password" class="form-control"  placeholder="Password">
      
    <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>

    <p class="forgot-password text-right">
      <router-link to="forgotPassword">Forgot Password</router-link>
    </p>
    
  </form>
</template>

<script >
import axios from 'axios';

export default{
  name:'LoginPage',


  data(){
  return{
    email:'',
    password:'',
    error:''

  }
},
methods:{
 
  async handleSubmit(){
    try{
      const response = await axios.post('http://localhost:8080/auth/authenticate',{
      email: this.email,
      password: this.password
    });
    console.log(response);
    //localStorage.setItem('token', response.data.token);
    
    //Uses Store from vuex
    this.$store.dispatch('login', response.data.token);
    
    this.$router.push('/')
    } catch(e) {
      this.error = 'Invalid Username or Password'
    }
    

  }
}
}



</script>

<style>

</style>