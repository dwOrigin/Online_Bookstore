<script>
    import {createStore} from 'vuex'
    const store = createStore({
      state () {
        return {
            loginName:"null",
            islogin:false,
            
        }
      },
      mutations: {
          updatename(state,n){
              state.loginName = n;
          },
          updateislogin(state,n){
              state.islogin = n;
          }
      }
    })
    export default store;
    </script>