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
    },
    {
        path: '/cart',
        name: 'Cart',
        component: () =>
            import ('../views/Cart.vue')
    },
    {
        path: '/goods',
        name: 'Goods',
        component: () =>
            import ('../views/Goods.vue')
    },
    {
        path: '/orders',
        name: 'Orders',
        component: () =>
            import ('../views/Orders.vue')
    },
    {
        path: '/usr',
        name: 'Usr',
        component: () =>
            import ('../views/Usr.vue')
    },
    {
        path: "/:pathMatch(.*)",
        name: "NotFound",
        component: () =>
            import ("@/views/404.vue"),
    },


    {
        path: '/help',
        name: 'Help',
        component: () =>
            import ('../views/Help/Help.vue')
    },
    {
        path: '/contact',
        name: 'Contact',
        component: () =>
            import ('../views/Help/Contact.vue')
    },
    {
        path: '/rule',
        name: 'Rule',
        component: () =>
            import ('../views/Help/Rule.vue')
    },
    {
        path: '/library',
        name: 'Library',
        component: () =>
            import ('../views/library/LibraryIndex.vue')
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router