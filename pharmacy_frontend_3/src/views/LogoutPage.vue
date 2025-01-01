<template>
  <h3>You are Loged out</h3>
</template>

<script>

export default {
  name:'LogoutPage',
    created(){
        //localStorage.removeItem('token');
        this.$store.dispatch('logout');
        this.$router.push('/');
    }
}
</script>

<style>

</style>