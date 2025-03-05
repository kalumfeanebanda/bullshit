<script>
import Button_Form from "@/components/Button_Form.vue";

export default {
  name: "Profile",
  components: {
    Button_Form
  },
  data() {
    return {
      intro: "",
      address: "",
      county: "",
      imageUrl: null
    };
  },
  methods: {
    handleImageUpload(event) {
      const file = event.target.files[0];
      if (file) {
        this.imageUrl = URL.createObjectURL(file);
      }
    },
    submitProfile() {
      console.log("Profile updated with:", {
        intro: this.intro,
        address: this.address,
        county: this.county,
        imageUrl: this.imageUrl
      });

    }
  }
};
</script>
<template>
  <div
      class="container">
    <div class="profile-container">
      <h1 class="profile-title">Profile</h1>

      <div class="profile-image">
        <input type="file" @change="handleImageUpload" accept="image/*" />
        <img :src="imageUrl" alt="Profile Image" v-if="imageUrl" class="profile-image-preview" />
        <p v-else>No image uploaded</p>
      </div>

      <!-- Profile Info Section -->
      <form @submit.prevent="submitProfile" class="profile-info-form">
        <div class="form-group">
          <label for="intro">Short Introduction</label>
          <textarea id="intro" v-model="intro" placeholder="Write a short introduction..." rows="4"></textarea>
        </div>

        <div class="form-group">
          <label for="address">Address</label>
          <input type="text" id="address" v-model="address" placeholder="Enter your address" />
        </div>

        <div class="form-group">
          <label for="county">County</label>
          <input type="text" id="county" v-model="county" placeholder="Enter your county" />
        </div>
        <Button_Form label="Save Profile" :type="'submit'" />
      </form>
    </div>
  </div>
</template>



<style scoped>
* {
  max-width: 1728px;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Roboto', sans-serif;
}

.container {
  max-width: 1728px;
  padding-top: 80px;
  padding-bottom: 80px;
  background: #ebeadf;
  margin: 0 auto;
}

.profile-container {
  padding: 40px;
  background-color: #f7f7f7;
  border-radius: 10px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  max-width: 700px;
  margin: auto;
}

.profile-title {
  font-size: 24px;
  text-align: center;
  margin-bottom: 20px;
}

.profile-image {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 20px;
}

.profile-image input[type="file"] {
  margin-bottom: 10px;
}

.profile-image-preview {
  width: 120px;
  height: 120px;
  border-radius: 50%;
  object-fit: cover;
  margin-top: 10px;
}

.profile-info-form {
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.form-group {
  display: flex;
  flex-direction: column;
}

.form-group label {
  font-size: 14px;
  margin-bottom: 5px;
}

.form-group input,
.form-group textarea {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.form-group textarea {
  resize: vertical;
}

button {
  align-self: center;
  cursor: pointer;
}

button:hover {
  background-color: #689068;
  color: #fff;
}

</style>



