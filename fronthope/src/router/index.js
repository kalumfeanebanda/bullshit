import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import Login from '../views/Login.vue';
import Profile from '../views/Profile.vue';

import Registration from "@/views/Registration.vue";

import ListCategory from "@/views/ListCategory.vue";
import CategoryForm from "@/views/CategoryForm.vue";
import EmployeeList from "@/views/EmployeeList.vue";
import EmployeeForm from "@/views/EmployeeForm.vue";



const routes = [
    { path: '/', name: 'Home', component: Home },
    { path: '/login', name: 'Login', component: Login },
    { path: '/registration', name: 'Registration', component: Registration},
    {path:'/profile',name:'Profile',component: Profile},// Ensure this route is correct


{ path: '/listCategory', name: 'ListCategory', component: ListCategory },
{ path: '/add-category', name: 'AddCategory', component: CategoryForm },
{ path: '/edit-category/:id', name: 'EditCategory', component: CategoryForm, props: true },

    { path: '/employeelist', name: 'EmployeeList', component: EmployeeList }, // Employee List
    { path: '/add-employee', name: 'Add-employee', component: EmployeeForm }, // Add Employee
    { path: '/edit-employee/:id', name: 'EditEmployee', component: EmployeeForm, props: true }, // Edit Employee
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;


