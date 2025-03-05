<!--<template>-->
<!--  <div id="app">-->
<!--    <Header/>-->



<!--&lt;!&ndash;     Main content area where routed components will appear&ndash;&gt;-->
<!--    <main>-->
<!--      <router-view></router-view> &lt;!&ndash; Vue Router renders the active component here &ndash;&gt;-->
<!--    </main>-->
<!--    <Footer/>-->

<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import Home from "@/views/Home.vue";-->
<!--import Header from "@/components/Header.vue";-->
<!--import Footer from "@/components/Footer.vue";-->

<!--export default {-->
<!--  name: 'App',-->
<!--  components: {Header, Home, Footer}-->
<!--}-->
<!--</script>-->


<!--<style scoped>-->



<!--</style>-->


<template>
  <div id="app">
    <Header/>
    <!-- Main content area where routed components will appear -->
    <main>
      <router-view></router-view> <!-- Vue Router renders the active component here -->
    </main>
    <Footer/>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: 'App',
  components: { Header, Footer }
}
</script>

<style scoped>
/* Add any additional styles here */
</style>
