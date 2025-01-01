//I call the functions in ACTION with the command >this.$store.dispatch('login', response.data.token);
//THis actions change the mutation and then change the state
//To attach the getters i should install getters as it appears in NavPage
import { createStore } from 'vuex';

export default createStore({
  state: {
    token: localStorage.getItem('jwtToken') || null, // Initialize from localStorage
  },
  mutations: {
    setToken(state, token) {
      state.token = token;
      if (token) {
        localStorage.setItem('jwtToken', token);
      } else {
        localStorage.removeItem('jwtToken');
      }
    },
  },
  actions: {
    login({ commit }, token) {
      commit('setToken', token);
    },
    logout({ commit }) {
      commit('setToken', null);
    },
  },
  getters: {
    isTokenValid: (state) => !!state.token,
  },
});


// Vue.use(Vuex)

// const state = {
//     user: null
// };

// const store = new Vuex.Store({
//     state,
//     getters:{
//         //we get the current value of the user
//         user:(state) =>{
//             return state.user;
//         }
//     },
//     actions:{
//         user(context, user){
//             context.commit('user', user)
//         }
//     },
//     mutations:{
//         //this change the state of the user
//         //The way to change the mustation is by action
//         user(state, user){
//             state.user = user;
//         }
//     }

// });

// export default store;