<template>
  <form @submit.prevent="handleSubmit">
    
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
   
      <input v-model="email" type="email" class="form-control"  placeholder="name@example.com">
      
      <input v-model="password"  type="password" class="form-control"  placeholder="Password">
      
    <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
    
  </form>
</template>

<script >
import axios from 'axios';

export default{
  name:'LoginPage',

  data(){
  return{
    email:'',
    password:''

  }
},
methods:{
 
  async handleSubmit(){
    const response = await axios.post('http://localhost:8080/auth/authenticate',{
      email: this.email,
      password: this.password
    });
    console.log(response);
    localStorage.setItem('token', response.data.token);

  }
}
}



</script>

<style>

</style>