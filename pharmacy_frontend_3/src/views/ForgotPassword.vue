<template>
    <form @submit.prevent="handleSubmit">
        <h3>Forgot Password</h3>

        <div class="form-group">
            <label>Email</label>
            <input type="email" class="form-control" placeholder="Email">
        </div>

        <button class="btn btn-primary btn-block">Submit</button>

    </form>
  </template>
  
  <script>
  import axios from 'axios'
  export default {
    name:'ForgotPassword',
    data(){
        return{
            email:''
        }
    },
      methods:{
        async handleSubmit(){
            const response = await axios.post('forgot', {
                email: this.email
            });
            console.log(response)
        }
      }
  }
  </script>
  
  <style>
  
  </style>