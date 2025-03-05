<script>
import Input_Field from "@/components/Input_Field.vue";
import Button_Form from "@/components/Button_Form.vue";

import {useRouter} from "vue-router";

export default {
  name: "Account",
  components: {
    Input_Field,
    Button_Form,
  },

  setup() {
    const router = useRouter();
    const navigateToLogin = () => {
      router.push("/login");
    };
    return {navigateToLogin};
  },
};
</script>
<template>
<div
    class ="main">
  <div class="container">
    <div class="image-container">
      <img src="@/assets/images/register.png" alt="Your Image" class="image" />
    </div>
    <div class="form-container">
      <form id="form" action="">
        <h1 class="form-title">Register</h1>
        <div class="form-fields">
          <Input_Field
              class="user"
              type="text"
              placeholder="User Name"
              required
              id="user-name"
              label="User Name"
          />
        </div>

        <div class="form-group">
          <Input_Field
              label="First Name"
              id="first-name"
              type="text"
              placeholder="Enter your first name"
              required
          />
          <Input_Field
              label="Last Name"
              id="last-name"
              type="text"
              placeholder="Enter your last name"
              required
          />
        </div>

        <div class="form-group">
          <Input_Field
              label="Email Address"
              id="email"
              type="email"
              placeholder="Enter your email address"
              required
          />

          <Input_Field
              label="Phone Number"
              id="phone-number"
              type="tel"
              placeholder="Enter your phone number"
              required
          />
        </div>

        <div class="form-group">
          <Input_Field
              label="Password"
              id="password"
              type="password"
              placeholder="Enter your password"
              required
          />
          <Input_Field
              label="Confirm Password"
              id="confirm-password"
              type="password"
              placeholder="Confirm your password"
              required
          />
        </div>

        <div class="checkbox-row">
          <input type="checkbox" id="terms" required />
          <label for="terms">I Agree to the Terms & Conditions</label>
        </div>


        <div class="button-row">
          <Button_Form label="Create Account" class="create-account-btn" />
        </div>

        <div class="already-have-account">
          <label for="login">Already have an Account?</label>
        </div>

        <div class="button-row" @click="navigateToLogin">
          <Button_Form
              label="Log in"
              type="button"
              class="login-btn"
              style="background-color: #92af92;"
          />
        </div>
      </form>
    </div>
  </div>
</div>
</template>



<style scoped>
* {
  max-width: 1728px;
  font-family: 'Roboto', sans-serif;
  margin: 0 auto;
  padding: 0;
  box-sizing: border-box;

}

.main{
  background-color: #ebeadf;
}


.button-row {
  text-align: center;
}

.form-title {
  text-align: center;
  letter-spacing: 2px;
}

.form-fields {
  display: grid;
  grid-template-columns: 1fr;
  gap: 10px;
  margin-bottom: 20px;
}

.form-group {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 10px;
  margin-bottom: 20px;
}

:deep(.user .input-field) {
  width: 610px;
}

.checkbox-row {
  padding: 0 0 20px 0;
}

.already-have-account {
  padding: 16px 0 20px 0;
}

.container {
  display: flex;
  justify-content: center;
  align-items: stretch;
  padding: 70px 0 70px 0;

}

.image-container {
  flex:
      0 1 40%;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom:-6px ;
}

.image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 8px 0 0 8px;
}

.form-container {
  flex: 1;
  width: 700px;
  padding: 40px ;
  background-color: white;
  border-radius: 0 8px 8px 0;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  margin-left: -2px
}
.form-title {
  text-align: center;
}

</style>

