<template>
  <form @submit.prevent="submit">
    
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
   
      <input v-model="data.amka" type="text" class="form-control"  placeholder="amka">

      <input v-model="data.email" type="email" class="form-control"  placeholder="name@example.com">
      
      <input v-model="data.password" type="password" class="form-control"  placeholder="Password">

      <input v-model="data.role" type="text" class="form-control"  placeholder="role">
      
    <button class="btn btn-primary w-100 py-2" type="submit">Submit</button>
    
  </form>
</template>

<script lang="ts">
import { reactive } from 'vue'; //Automaticly change the variables when we change the input
import { useRouter } from 'vue-router';
export default {
    name:"RegisterPage",
    setup(){
        const data = reactive({
          amka:'',
          email:'',
          password:'',
          role:''
        }); 

        //After submit redirect to LoginPage
        const router = useRouter();

        const submit2 = () =>{
          console.log(data)
          }

        //Submit the form to the DB
        const submit = async () =>{
          console.log(data)
          await fetch ('http://localhost:8080/auth/register', {
            method:'POST',
            headers:{'Content-Type':'application/json'},
            body: JSON.stringify(data)
          });

            await router.push('/login');

}
        return{data, submit}

        
    }
}
</script>

<style>

</style>