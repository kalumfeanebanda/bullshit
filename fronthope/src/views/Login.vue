<script>
import LoginForm from "@/components/LoginForm.vue";
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "LoginPage",
  components: {
    LoginForm,
    Header,
    Footer,
  },
};
</script>

<template>

    <div class="login-page-wrapper">
      <div class="login-page">
        <!-- Login Form Component with its props -->
        <LoginForm formTitle="User Log In" backgroundColor="#8FAD88" />
      </div>

  </div>
</template>

<style scoped>
.login-page-wrapper {
  max-width: 1728px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  padding: 60px 0 60px 0;
  background-color: #ebeadf;

}

.login-page {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 20px;
  flex-grow: 1;

}
</style>
