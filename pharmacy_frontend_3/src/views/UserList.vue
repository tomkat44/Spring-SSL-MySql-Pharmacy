<template>
    

    <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Amka</th>
      <th scope="col">Email</th>
      <th scope="col">Role</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for=" u in users" :key="u.email">
      <th scope="row">{{u.id}}</th>
      <td>{{u.amka}}</td>
      <td>{{u.email}}</td>
      <td>{{u.role}}</td>
    </tr>
</tbody>
</table>
</template>

<script>
import axios from 'axios';
export default {
    name: "UserList",

    data() {
    return {
        users:[]
      
    }
   },

    async created(){
      console.log(localStorage.getItem('token'));
      const response = await axios.get('user/getAll');
      this.users = response.data._embedded.userList
      console.log(response);
      console.log(response.data._embedded.userList);
    }

}
</script>

<style>

</style>