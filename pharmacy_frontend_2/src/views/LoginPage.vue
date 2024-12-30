<template>
  <form @submit.prevent="submit">
    
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
   
      <input v-model="data.email" type="email" class="form-control"  placeholder="name@example.com">
      
      <input  v-model="data.password" type="password" class="form-control"  placeholder="Password">
      
    <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
    
  </form>
</template>

<script lang="ts">
import { reactive } from 'vue';
import { useRouter } from 'vue-router';

export default {
  name:"LoginPage",



  setup() {
    const data = reactive({
      email:'',
      password:''
    });
    const router = useRouter();

     //Submit the form to the DB
     const submit = async () =>{
          await fetch ('http://localhost:8080/auth/authenticate', {
            method:'POST',
            headers:{'Content-Type':'application/json'},
            credentials: 'include',
            body: JSON.stringify(data)
          });

          await router.push('/');
        }
    return{data, submit}
  }

}

</script>

<style>

</style>