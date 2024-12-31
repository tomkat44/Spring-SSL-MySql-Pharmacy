<template>
  <div class="d-flex gap-2 justify-content-center py-5">
  <router-link :to="{name:'UserList'}" class="btn btn-primary rounded-pill px-3" type="button">Users</router-link>
  <button class="btn btn-secondary rounded-pill px-3" type="button">Prescriptions</button>
  <button class="btn btn-success rounded-pill px-3" type="button">Excecutions</button>
  <button class="btn btn-danger rounded-pill px-3" type="button">Drugs</button>
  <button class="btn btn-warning rounded-pill px-3" type="button">Active Substance</button>
  <button class="btn btn-info rounded-pill px-3" type="button">Info</button>
  <button class="btn btn-light rounded-pill px-3" type="button">Light</button>
  <button class="btn btn-dark rounded-pill px-3" type="button">Dark</button>
</div>
  <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Corporis aut dolores sapiente cum similique sequi excepturi ducimus quam eos, et ipsam veritatis error! Voluptatibus optio explicabo provident cupiditate ex rem, dolores quis nostrum libero quam. Impedit non exercitationem sunt, nam corporis eligendi eaque nostrum facilis explicabo ut repudiandae numquam magni aut tenetur officia et suscipit est nulla consectetur iusto praesentium laborum doloribus? Nulla deleniti sint cupiditate, a saepe eveniet, provident minus assumenda maxime tenetur sed dicta impedit? Eligendi sunt consequatur incidunt quae natus labore rerum cum dicta alias non illo, at consectetur nam hic, possimus consequuntur similique magnam nemo quidem!</p>
</template>

<script>
// import axios from 'axios';
// export default {
//     name: "HomePage",

//     async created(){
//       console.log(localStorage.getItem('token'));
//       const response = await axios.get('user/getAll');

//       const userList = response.data._embedded.userList

//       console.log(response);
//       console.log(userList[4].amka);
//     }
// }
</script>

<style>

</style>