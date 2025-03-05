<script>
import Input_Field from "@/components/Input_Field.vue";
import Button_Form from "@/components/Button_Form.vue";

export default {
  name: "LoginForm",
  components: {
    Input_Field,
    Button_Form,
  },
  props: {
    formTitle: {
      type: String,
      required: true
    },
    backgroundColor: {
      type: String,
      default: "#fff"
    }
  },
  data() {
    return {
      username: '',
      email: '',
      password: '',
      rememberMe: false
    };
  },
  methods: {
    submitForm() {
      console.log("Logging in with:", this.username, this.email, this.password);
      // Add your API call or form validation here

      // Navigate to the Profile page after successful login
      this.$router.push({ name: 'Profile' });
    },
    navigateToRegistration() {
      this.$router.push({ name: 'Registration' });
    }
  }
};
</script>

<template>
  <div class="form-container" :style="{ backgroundColor: backgroundColor }">
    <h1 class="form-title">{{ formTitle }}</h1>
    <form class="form-content" @submit.prevent="submitForm">
      <!-- Input Fields with v-model -->
      <Input_Field label="User Name" id="username" type="text" placeholder="Enter your username..." v-model="username"/>
      <Input_Field label="Email Address" id="email" type="email" placeholder="Enter your email..." v-model="email"/>
      <Input_Field label="Password" id="password" type="password" placeholder="Enter your password..." v-model="password"/>

      <div class="checkbox-container">
        <label id="remember">
          <input type="checkbox" id="remember-me" v-model="rememberMe" />
          Remember me
        </label>
      </div>
      <Button_Form label="Log In" :type="'submit'" />
    </form>

    <!-- Link to Registration Page -->
    <p class="account-text">Don’t Have an Account</p>
    <Button_Form
        id="acc-btn"
        label="Create Account"
        :type="'button'"
        @click="navigateToRegistration"
    />
  </div>
</template>


<style scoped>
* {
  font-family: 'Roboto', sans-serif;
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

.form-container {
  padding: 60px 60px;
  border-radius: 10px;
  box-shadow: 5px 5px 20px rgba(0, 0, 0, 0.25);
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.form-title {

  letter-spacing: 2px;
  text-align: center;
  margin-bottom: 20px;
}

.form-content {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  width: 100%;
  gap: 10px;
}

.checkbox-container {
  display: flex;
  align-items: center;
  justify-content: flex-start;
  width: 100%;
}

.account-text {
  margin: 10px 0;
  font-size: 16px;
  letter-spacing: 1px;
  font-weight: lighter;
  text-align: left;
  width: 100%;
}
</style>

