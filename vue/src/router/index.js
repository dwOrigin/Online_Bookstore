import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [{
        path: '/home',
        name: 'Home',
        component: Home
    },
    {
        path: '/login',
        name: 'Login',
        component: () =>
            import ('../views/Login.vue')
    },
    {
        path: '/detail',
        name: 'Detail',
        component: () =>
            import ('../views/Detail.vue')
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router