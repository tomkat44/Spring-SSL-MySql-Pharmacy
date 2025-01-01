<template>
    <form @submit.prevent="handleSubmit">
        <h3>Reset Password</h3>
        <div class="form-group"> 
            <label>Password</label>
            <input v-model="password" type="password" class="form-control" placeholder="Password"/>
        </div>

        <div class="form-group">
            <label>Password Confirm</label>
            <input v-model="passwordConfirm" type="password" class="form-control" placeholder="Password Confirm"/>
        </div>

        <button class="btn btn=primary btn-block">Submit</button>

    </form>

    </template>

    <script>
    import axios from 'axios'
    export default {
        name:'ResetPassword',
        data(){
            return{
                password:'',
                passwordConfirm:''
            }
        },
        methods:{
            async handleSubmit(){
                const response = await axios.post('reset', {
                    password: this.password,
                    passwordConfirm: this.passwordConfirm,
                    token: this.$route.params.token //collects the token from the URL
                });
                console.log(response)
            }
        }
    }
        
    </script>