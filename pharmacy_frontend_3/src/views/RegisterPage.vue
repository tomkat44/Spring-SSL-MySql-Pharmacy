<template>
  <form @submit.prevent="handleSubmit">
    
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
   
      <input v-model="amka" type="text" class="form-control"  placeholder="amka">

      <input v-model="email" type="email" class="form-control"  placeholder="name@example.com">
      
      <input v-model="password" type="password" class="form-control"  placeholder="Password">

      <input v-model="role" type="text" class="form-control"  placeholder="role">
      
    <button class="btn btn-primary w-100 py-2" type="submit">Submit</button>
    
  </form>
</template>

<script>
import axios from 'axios';
export default{
  name:'RegisterPage',
  data(){
    return{
      amka:'',
      email:'',
      password:'',
      role:''
    }

  },
  methods:{
    async handleSubmit(){
      const data = {
        amka: this.amka,
        email: this.email,
        password: this.password,
        role: this.role
      }
      console.log(data)

      //this is a try-catch
      const response = await axios.post('http://localhost:8080/auth/register', data);
      
      console.log(response);

      this.$router.push('/login')
    }
  }

}

</script>

<style>

</style>