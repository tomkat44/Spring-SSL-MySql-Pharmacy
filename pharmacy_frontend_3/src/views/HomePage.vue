<template>
  Home
</template>

<script>
import axios from 'axios';
export default {
    name: "HomePage",

    async created(){
      console.log(localStorage.getItem('token'));
      const response = await axios.get('user/getAll');

      console.log(response);
    }
}
</script>

<style>

</style>